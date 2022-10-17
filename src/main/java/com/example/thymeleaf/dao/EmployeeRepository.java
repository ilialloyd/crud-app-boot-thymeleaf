package com.example.thymeleaf.dao;

import com.example.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    //add a method to sort by last name
    //Spring Data JPA will parse this method like this ->from Employee order by lastName asc
    public List<Employee> findAllByOrderByLastNameAsc();
}