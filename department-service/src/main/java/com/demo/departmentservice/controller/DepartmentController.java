package com.demo.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.departmentservice.client.EmployeeClient;
import com.demo.departmentservice.model.Department;
import com.demo.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private EmployeeClient employeeClient; 
	
	@PostMapping("/save")
	public Department add(@RequestBody Department department) {
		return repository.addDepartment(department);
	}

	@GetMapping("/getall")
	public List<Department> findAll(){
		return repository.findAll();
	}
	@GetMapping("/get/{id}")
	public Department findById(@PathVariable("id") Long  id) {
		return repository.findById(id);
	}
	
	@GetMapping("/with-employees")
	public List<Department> findWithEmployees(){
		List<Department> departments = repository.findAll();
		departments.forEach(department -> department.setEmployees(employeeClient.findEmployeeByDepartment(department.getId())));
		return departments;
	}
}
