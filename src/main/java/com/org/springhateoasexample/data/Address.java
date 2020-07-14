package com.org.springhateoasexample.data;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by niket.shah on 22/04/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends RepresentationModel<Address> {

    private Long id;

    private String type;

    private String street;

    private String city;

    private Long zip;
}
