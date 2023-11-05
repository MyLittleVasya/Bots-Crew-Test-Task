package com.bots_crew_testing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lectors_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lector {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String fullName;

  @Enumerated(EnumType.STRING)
  private Degree degree;

  private int salary;

}
