package com.org.springhateoasexample.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.org.springhateoasexample.data.Address;
import com.org.springhateoasexample.data.Person;

/**
 * created by niket.shah on 21/04/20
 */
@Service
public class PersonService {

    private List<Person> personList = new ArrayList<>();

    public void add(Person person){
        personList.add(person);
    }

    public Person get(String id){
        return personList.stream().filter(person -> person.getId().toString().equals(id))
                .findFirst().get();
    }

    public List<Address> getAddress(String id){
        return personList.stream().filter(person -> person.getId().toString().equals(id))
                .map(Person::getAddress)
                .findFirst().get();
    }

    public Address getAddressWithId(String id, String addressId){
        return personList.stream().filter(person -> person.getId().toString().equals(id))
                .flatMap(person -> person.getAddress().stream())
                .filter(address -> address.getId().toString().equals(addressId))
                .findFirst().get();
    }

    @PostConstruct
    public void setup(){
        Address address = new Address(1L, "Home", "MJ Road", "AHM", 380002L);
        Address address2 = new Address(2L, "Work", "SVP Road", "AHM", 380001L);
        personList.add(new Person(1L,"John",25,"Male", Arrays.asList(address,address2)));
    }
}
