package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findALl();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);
}
