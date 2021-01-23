package com.hcl.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hcl.model.Employee;
import com.hcl.service.EmployeeService;

//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
//	
//	@GetMapping("/api/employees")
//	public List<Employee> getEmployees() {
//		return service.findAllEmployees();
//	}
//	
//	@PostMapping("/api/employees")
//	public Employee addNewEmpoyee(@RequestBody Employee emp) {
//		service.saveEmployee(emp);
//		return emp;
//	}

	@GetMapping(value={"/home","/"})
	public ModelAndView getHome() {
		return new ModelAndView("homepage");
	}

	
	@GetMapping("/registration")
	public ModelAndView getRegistration() {
		System.out.println("----------------------hereeeee---------------");
		Employee e = new Employee();
		return new ModelAndView("registerform", "reg", e);
	}
	@PostMapping("/registration")
	public ModelAndView postRegistration(@ModelAttribute("emp") Employee emp) {
//		try {
			service.saveEmployee(emp);
//		} catch (FailedDatabaseActionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ModelAndView("registered", "correctemp", emp);
	}
	@GetMapping("/login")
	public ModelAndView getLogin() {
		return new ModelAndView("loginform");
	}
	@PostMapping("/login")
	//public ModelAndView postLogin(@RequestParam String name, @RequestParam String password) {
	public RedirectView postLogin(@RequestParam String name, @RequestParam String password) {
		List<Employee> emps = service.findAllEmployees();
		RedirectView rv = new RedirectView();
		//rv.setUrl("http://localhost:3000");
		rv.setUrl("https://sp-sam-heroku-front.herokuapp.com");
		for(Employee e:emps) {
			if(e.getName().equals(name) && e.getPassword().equals(password)) {
				//return new ModelAndView("welcome","correctemp",e);
				return rv;
				//return ("redirect:/http://localhost:3000/api/tasks");
			}
		}
		//return new ModelAndView("wrong");
		rv.setUrl("wrong");
		return rv;
	}
	
}
