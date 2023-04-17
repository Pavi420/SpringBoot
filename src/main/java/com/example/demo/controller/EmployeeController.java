package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(newEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/employeesList")
    public Iterable<Employee> getAllEmployees(){
        System.out.println("welcome");
        Iterable<Employee> list = employeeService.getAllEmployees();
        System.out.println("welcome"+list);
        return list;

    }

    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        System.out.println("welcome");
        Employee emp = employeeService.getEmployeeById(id);
        System.out.println("welcome"+emp);
        return emp;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}



