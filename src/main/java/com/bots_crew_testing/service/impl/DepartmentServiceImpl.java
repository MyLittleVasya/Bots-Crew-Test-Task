package com.bots_crew_testing.service.impl;

import com.bots_crew_testing.entity.Degree;
import com.bots_crew_testing.entity.Department;
import com.bots_crew_testing.entity.Lector;
import com.bots_crew_testing.entity.repo.DepartmentRepository;
import com.bots_crew_testing.entity.repo.LectorRepository;
import com.bots_crew_testing.service.DepartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  private final LectorRepository lectorRepository;

  @Override
  public String getHeadOfDepartment(String departmentName) {

    final var department = departmentRepository.findDepartmentByName(departmentName);

    return department.map(dep -> String.format("Head of %s department is %s", departmentName,
        dep.getHeadOfDepartment().getFullName())).orElseThrow(() -> new RuntimeException("Aboba not found"));

  }

  @Override
  public String showEmployeeStatistics(String departmentName) {
    final var department = departmentRepository.findDepartmentByName(departmentName);

    if (department.isPresent()) {
      Department dep = department.get();
      long assistantsCount = dep.getEmployees().stream()
          .filter(lector -> lector.getDegree() == Degree.ASSISTANT)
          .count();

      long associateProfessorsCount = dep.getEmployees().stream()
          .filter(lector -> lector.getDegree() == Degree.ASSOCIATE_PROFESSOR)
          .count();

      long professorsCount = dep.getEmployees().stream()
          .filter(lector -> lector.getDegree() == Degree.PROFESSOR)
          .count();

      return String.format("Degrees count in the %s department:\n" +
          "Assistants - %d\n" +
          "Associate Professors - %d\n" +
          "Professors - %d", departmentName, assistantsCount, associateProfessorsCount, professorsCount);
    } else {
      throw new RuntimeException("Department not found");
    }
  }

  @Override
  public String getAverageSalary(String departmentName) {
    final var department = departmentRepository.findDepartmentByName(departmentName);

    if (department.isPresent()) {
      Department dep = department.get();

      if (dep.getEmployees().isEmpty()) {
        throw new RuntimeException("No employees in the department");
      }

      final var average = dep.getEmployees().stream()
          .mapToInt(Lector::getSalary)
          .average()
          .getAsDouble();

      return String.format("The average salary of %s is %s", departmentName, average);
    } else {
      throw new RuntimeException("Department not found");
    }
  }

  @Override
  public String getEmployeeCount(String departmentName) {
    final var department = departmentRepository.findDepartmentByName(departmentName);

    if (department.isPresent()) {
      Department dep = department.get();

      return String.format("The count of employees is %s", dep.getEmployees().size());
    } else {
      throw new RuntimeException("Department not found");
    }
  }

  @Override
  public String globalSearch(String searchArgument) {
    List<Department> departments = departmentRepository.findByNameContaining(searchArgument);
    List<Lector> lectors = lectorRepository.findByFullNameContaining(searchArgument);

    StringBuilder result = new StringBuilder();

    for (Department department : departments) {
      result.append("Department: ").append(department.getName()).append("\n");
    }

    for (Lector lector : lectors) {
      result.append("Lector: ").append(lector.getFullName()).append("\n");
    }

    return result.toString();
  }
}
