package com.javaguides.service.impl;

import com.javaguides.model.Employee;
import com.javaguides.repository.EmployeeRepository;
import com.javaguides.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long empId) {
        Optional<Employee> optional = employeeRepository.findById(empId);
        Employee employee=null;
        if(optional.isPresent()){
            employee=optional.get();
        }else{
            throw new RuntimeException("Employee Not Found for Id :"+empId);
        }
        return employee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
