package com.service.impl;

import static com.bots_crew_testing.entity.Degree.ASSISTANT;
import static com.bots_crew_testing.entity.Degree.ASSOCIATE_PROFESSOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bots_crew_testing.entity.Department;
import com.bots_crew_testing.entity.Lector;
import com.bots_crew_testing.entity.repo.DepartmentRepository;
import com.bots_crew_testing.entity.repo.LectorRepository;
import com.bots_crew_testing.exception.NotFoundException;
import com.bots_crew_testing.service.impl.DepartmentServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

  @InjectMocks
  private DepartmentServiceImpl departmentService;

  @Mock
  private DepartmentRepository departmentRepository;

  @Mock
  private LectorRepository lectorRepository;

  @Test
  public void testGetHeadOfDepartment() {
    String departmentName = "TestDepartment";
    Department department = new Department();
    department.setName(departmentName);
    Lector headOfDepartment = new Lector();
    headOfDepartment.setFullName("HeadLector");
    department.setHeadOfDepartment(headOfDepartment);

    Mockito.when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(Optional.of(department));

    String result = departmentService.getHeadOfDepartment(departmentName);

    assertEquals("Head of \"TestDepartment\" department is \"HeadLector\"", result);

  }

  @Test
  public void testGetHeadOfDepartmentNotFound() {
    String departmentName = "NonExistentDepartment";

    Mockito.when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(Optional.empty());

    assertThrows(NotFoundException.class, () -> departmentService.getHeadOfDepartment(departmentName));
  }

  @Test
  public void testShowEmployeeStatistics() {
    // Arrange
    String departmentName = "TestDepartment";
    Department department = new Department();
    department.setName(departmentName);
    Lector lector1 = new Lector();
    lector1.setDegree(ASSISTANT);
    Lector lector2 = new Lector();
    lector2.setDegree(ASSISTANT);
    Lector lector3 = new Lector();
    lector3.setDegree(ASSOCIATE_PROFESSOR);
    department.setEmployees(List.of(lector1, lector2, lector3));

    Mockito.when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(Optional.of(department));

    String result = departmentService.showEmployeeStatistics(departmentName);

    assertTrue(result.contains("Assistants - 2"));
    assertTrue(result.contains("Associate Professors - 1"));
    assertTrue(result.contains("Professors - 0"));
  }

  @Test
  public void testGetAverageSalary() {
    // Arrange
    String departmentName = "TestDepartment";
    Department department = new Department();
    department.setName(departmentName);
    Lector lector1 = new Lector();
    lector1.setSalary(50000);
    Lector lector2 = new Lector();
    lector2.setSalary(60000);
    department.setEmployees(List.of(lector1, lector2));

    Mockito.when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(Optional.of(department));

    // Act
    String result = departmentService.getAverageSalary(departmentName);

    // Assert
    assertEquals("The average salary of \"TestDepartment\" is \"55000.0\"", result);
  }

  @Test
  public void testGetEmployeeCount() {
    // Arrange
    String departmentName = "TestDepartment";
    Department department = new Department();
    department.setName(departmentName);
    Lector lector1 = new Lector();
    Lector lector2 = new Lector();
    department.setEmployees(List.of(lector1, lector2));

    Mockito.when(departmentRepository.findDepartmentByName(departmentName)).thenReturn(Optional.of(department));

    // Act
    String result = departmentService.getEmployeeCount(departmentName);

    // Assert
    assertEquals("The count of employees is \"2\"", result);
  }

  @Test
  public void testGlobalSearch() {
    // Arrange
    String searchArgument = "Test";
    Department department1 = new Department();
    department1.setName("TestDepartment1");
    Department department2 = new Department();
    department2.setName("TestDepartment2");
    Lector lector1 = new Lector();
    lector1.setFullName("TestLector1");
    Lector lector2 = new Lector();
    lector2.setFullName("TestLector2");

    Mockito.when(departmentRepository.findByNameContaining(searchArgument)).thenReturn(List.of(department1, department2));
    Mockito.when(lectorRepository.findByFullNameContaining(searchArgument)).thenReturn(List.of(lector1, lector2));

    // Act
    String result = departmentService.globalSearch(searchArgument);

    // Assert
    assertTrue(result.contains("Department: TestDepartment1"));
    assertTrue(result.contains("Department: TestDepartment2"));
    assertTrue(result.contains("Lector: TestLector1"));
    assertTrue(result.contains("Lector: TestLector2"));
  }
}

