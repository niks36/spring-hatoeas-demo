package com.org.springhateoasexample.data;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * created by niket.shah on 01/06/20
 */
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department implements Serializable {

  @Id
  @GeneratedValue
  Long id;

  String name;

  String code;

}
