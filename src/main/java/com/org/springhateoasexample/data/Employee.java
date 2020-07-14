package com.org.springhateoasexample.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * created by niket.shah on 01/06/20
 */
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

  @Id
  @GeneratedValue
  Long id;

  String name;

  String employeeCode;

  @OneToOne
  Department department;

}
