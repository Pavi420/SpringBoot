package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }




    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        Iterable<Employee> l = employeeRepository.findAll();
        System.out.println(l);
        return l;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id);

        if(existingEmployee!= null){
            existingEmployee.setEmpNo(employee.getEmpNo());
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setMob(employee.getMob());
            existingEmployee.setEmail(employee.getEmail());
        } else {
            throw new RuntimeException();
        }

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee existingEmployee = employeeRepository.findById(id);

        if(existingEmployee!=null) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }
}
