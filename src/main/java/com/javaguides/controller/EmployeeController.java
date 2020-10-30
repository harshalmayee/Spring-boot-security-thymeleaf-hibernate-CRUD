package com.javaguides.controller;

import com.javaguides.model.Employee;
import com.javaguides.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "saveEmployee.html";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employee/getEmpList";
    }

    @GetMapping("/employeeUpdate/{empId}")
    public String updateEmployee(@PathVariable (value = "empId") long empId,Model model){
         // get employee to be updated from service
        Employee employee=employeeService.getEmployeeById(empId);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "updateEmployee.html";
    }

    @GetMapping("/employeeDelete/{empId}")
    public String deleteEmployee(@PathVariable(value = "empId")long empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/getEmpList";
    }


}
