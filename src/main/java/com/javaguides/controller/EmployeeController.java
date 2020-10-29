package com.javaguides.controller;

import com.javaguides.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*
       Display list of all employees
     */
    @GetMapping("/getEmpList")
    public String getAllEmployees(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "employee";
    }
}
