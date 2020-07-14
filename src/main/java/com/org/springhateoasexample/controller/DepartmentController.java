package com.org.springhateoasexample.controller;

import com.org.springhateoasexample.data.Department;
import com.org.springhateoasexample.repository.DepartmentRepository;
import com.org.springhateoasexample.to.DepartmentResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 * created by niket.shah on 21/06/20
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private RepresentationModelAssemblerSupport<Department, DepartmentResource> assemblerSupport;

  @Autowired
  private PagedResourcesAssembler<Department> pagedResourcesAssembler;


  @GetMapping("/all")
  public ResponseEntity<PagedModel<DepartmentResource>> getAllDepartments(Pageable pageable) {
    Page<Department> departments = departmentRepository.findAll(pageable);
    return new ResponseEntity<>(pagedResourcesAssembler.toModel(departments,assemblerSupport), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}",produces = "application/json")
  public ResponseEntity<DepartmentResource> getDepartment(@PathVariable("id") Long id) {
    return departmentRepository.findById(id)
        .map(assemblerSupport::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostConstruct
  public void setup(){
    Department department = new Department();
    department.setName("Infra");
    department.setCode("INF");
    departmentRepository.save(department);

    department = new Department();
    department.setName("Testing");
    department.setCode("QA");
    departmentRepository.save(department);

    department = new Department();
    department.setName("Development");
    department.setCode("DEV");
    departmentRepository.save(department);
  }
}
