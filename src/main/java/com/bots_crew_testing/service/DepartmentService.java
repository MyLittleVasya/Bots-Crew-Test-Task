package com.bots_crew_testing.service;

/**
 * Service with business logic related to {@link com.bots_crew_testing.entity.Department}.
 */
public interface DepartmentService {

  /**
   * Returns full name of head of department.
   *
   * @param departmentName department to show head of.
   * @return {@link com.bots_crew_testing.entity.Lector} instance full name.
   */
  String getHeadOfDepartment(String departmentName);

  /**
   * Show employee degrees statistics.
   *
   * @param departmentName department to show statistics of.
   * @return string that contains count for every degree in department.
   */
  String showEmployeeStatistics(String departmentName);

  /**
   * Show average salary among all employees of the department.
   *
   * @param departmentName department to count salary of.
   * @return string that contains average salary values.
   */
  String getAverageSalary(String departmentName);

  /**
   * Show count of department employees
   *
   * @param departmentName department to count employees of.
   * @return string that contains number of employees.
   */
  String getEmployeeCount(String departmentName);

  /**
   * Find any department or employees by search argument
   *
   * @param searchArgument argument of search.
   * @return string that contains all found entities.
   */
  String globalSearch(String searchArgument);

}
