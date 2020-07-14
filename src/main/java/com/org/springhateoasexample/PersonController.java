package com.org.springhateoasexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springhateoasexample.data.Address;
import com.org.springhateoasexample.data.Person;
import com.org.springhateoasexample.service.PersonService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * created by niket.shah on 21/04/20
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public Person getPerson(@PathVariable String id){
        Person person = personService.get(id);
        person.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
        person.add(linkTo(methodOn(PersonController.class).getAddressOfPerson(id)).withRel("address"));
        return person;
    }

    @GetMapping(value = "/{id}/address", produces = "application/hal+json")
    public CollectionModel<Address> getAddressOfPerson(@PathVariable String id){
        List<Address> addressList = personService.getAddress(id);

        addressList.forEach(address1 -> {
                    address1.add(linkTo(methodOn(PersonController.class).getAddressById(id, address1.getId().toString())).withSelfRel());
                });
        Link link = linkTo(methodOn(PersonController.class).getAddressOfPerson(id)).withSelfRel();
        CollectionModel<Address> result = new CollectionModel<>(addressList, link);

        return result;
    }

    @GetMapping(value = "/{id}/address/{addressId}", produces = "application/hal+json")
    public Address getAddressById(@PathVariable String id, @PathVariable String addressId){
        Address address = personService.getAddressWithId(id,addressId);

        //address.add(linkTo(methodOn(PersonController.class).getAddressById(id,addressId)).withSelfRel());
        return address;
    }
}
