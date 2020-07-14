package com.org.springhateoasexample.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.org.springhateoasexample.controller.DepartmentController;
import com.org.springhateoasexample.data.Department;
import com.org.springhateoasexample.to.DepartmentResource;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

/**
 * created by niket.shah on 20/06/20
 */
@Component
public class DepartmentResourceAssembler extends RepresentationModelAssemblerSupport<Department, DepartmentResource> {
  public DepartmentResourceAssembler() {
    super(DepartmentController.class, DepartmentResource.class);
  }

  @Override
  public DepartmentResource toModel(Department entity) {

    DepartmentResource departmentResource = instantiateModel(entity);
    departmentResource.setId(entity.getId());
    departmentResource.setName(entity.getName());
    departmentResource.setCode(entity.getCode());
    departmentResource.add(linkTo(methodOn(DepartmentController.class).getDepartment(entity.getId())).withSelfRel());
    return departmentResource;
  }

  @Override
  public CollectionModel<DepartmentResource> toCollectionModel(Iterable<? extends Department> entities)
  {
    CollectionModel<DepartmentResource> actorModels = super.toCollectionModel(entities);

    actorModels.add(linkTo(methodOn(DepartmentController.class).getAllDepartments()).withSelfRel());

    return actorModels;
  }
}
