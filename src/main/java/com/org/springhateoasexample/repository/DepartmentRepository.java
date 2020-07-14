package com.org.springhateoasexample.repository;

import com.org.springhateoasexample.data.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * created by niket.shah on 01/06/20
 */
@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department,Long> {
}
