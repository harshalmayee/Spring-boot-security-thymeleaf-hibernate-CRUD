package com.javaguides.controller;

import com.javaguides.model.Employee;
import com.javaguides.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/loadEmployeeForm")
    public String loadEmployeeForm(Model model){
        // Craete model attribute to bind form data
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "saveEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employee/getEmpList";
    }
}
