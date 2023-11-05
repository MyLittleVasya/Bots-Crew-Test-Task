package com.bots_crew_testing.entity.repo;

import com.bots_crew_testing.entity.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  Optional<Department> findDepartmentByName(String name);

  List<Department> findByNameContaining(String searchArgument);
}
