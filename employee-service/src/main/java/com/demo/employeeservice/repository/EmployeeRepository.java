package com.demo.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.employeeservice.model.Employee;

@Repository
public class EmployeeRepository {

	List<Employee> employees = new ArrayList<>();
	
	public Employee addEmployee(Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	public Employee findById(Long id) {
		return employees.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Employee> findAll(){
		return employees;
	}
	
	public List<Employee> findByDepartment(Long id){
		return employees.stream().filter(employee -> employee.departmentId().equals(id)).toList();
		
	}
}
