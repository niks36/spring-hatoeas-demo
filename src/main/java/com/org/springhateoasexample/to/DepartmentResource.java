package com.org.springhateoasexample.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.org.springhateoasexample.data.Department;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * created by niket.shah on 20/06/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "department")
@Relation(collectionRelation = "departments")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentResource extends RepresentationModel<DepartmentResource> {
    private Long id;
    private String name;
    private String code;
}
