package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.EmpRepository;
import com.hcl.exception.FailedDatabaseActionException;
import com.hcl.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepository repo;
	
	public Employee saveEmployee(Employee emp) {
		
			return repo.save(emp);
		
	}
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) repo.findAll();
	}
	
	public Optional<Employee> findEmployeeById(long id) {
		return repo.findById(id);
	}
	
	public void deleteEmployee(Employee emp) {
		
			repo.delete(emp);
		
	}
}
