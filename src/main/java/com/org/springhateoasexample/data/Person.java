package com.org.springhateoasexample.data;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by niket.shah on 21/04/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends RepresentationModel<Person> {

    private Long id;
    private String name;
    private Integer age;
    private String gender;

    @JsonIgnore
    private List<Address> address;
}
