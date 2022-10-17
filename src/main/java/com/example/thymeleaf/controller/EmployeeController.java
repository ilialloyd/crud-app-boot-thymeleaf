package com.example.thymeleaf.controller;

import com.example.thymeleaf.entity.Employee;
import com.example.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for /list
    @GetMapping("/list")
    public String getEmployeeList(Model model) {

        //get employees
        List<Employee> employees = employeeService.findALl();

        model.addAttribute("employees",employees);

        //return HTML template name
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee",employee);


        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model model){
        //get the employee from the service
        Employee employee = employeeService.findById(theId);

        //set the employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        //send over our form
        return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int id){
        //delete employee
        employeeService.deleteById(id);

        //redirect to the list
        return "redirect:/employees/list";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent dublicate submissions
        return "redirect:/employees/list";

    }



}
