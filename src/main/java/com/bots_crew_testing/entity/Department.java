package com.bots_crew_testing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @ManyToOne
  private Lector headOfDepartment;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "departments_employees", joinColumns = @JoinColumn(name = "department_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
  private List<Lector> employees;

}
