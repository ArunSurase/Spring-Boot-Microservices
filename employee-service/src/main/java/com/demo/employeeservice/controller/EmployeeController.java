package com.demo.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeeservice.model.Employee;
import com.demo.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.addEmployee(employee);
	}
	
	@GetMapping("/get/{id}")
	public Employee findEmployee(@PathVariable("id") Long id) {
		return employeeRepository.findById(id);
	}
	
	@GetMapping("/all")
	public List<Employee> getAll(){
		return employeeRepository.findAll();				
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findEmployeeByDepartment(@PathVariable("departmentId") Long departmentId){
		return employeeRepository.findByDepartment(departmentId);
	}
}
