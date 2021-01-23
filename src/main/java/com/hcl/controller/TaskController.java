package com.hcl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Task;
import com.hcl.service.TaskService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping("/api/tasks/{id}")
	public Optional<Task> getTask(@PathVariable long id) {
		return service.findTaskById(id);
	}
	
	@GetMapping("/saran")
	public String getTest() {
		return "welcome2.html";
	}
	
	@GetMapping("/api/tasks")
	public List<Task> getAllTasks() {
		return service.findAllTasks();
	}
	
	@PostMapping("/api/tasks")
	//public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
	public Task addNewTask(@RequestBody Task task) {
		//return ResponseEntity.ok(service.saveTask(task));
		service.saveTask(task);
		return task;
	}
	///////////////////////////////NEEEEEEEEEEEEDSSSSS TRY CATCH
	@PutMapping("/api/tasks/{id}")
	public Task editTask(@PathVariable long id, @RequestBody Task task) {
		task.setId(id);
		service.saveTask(task);
		return task;
	}
	
	@DeleteMapping("/api/tasks/{id}")
	public List<Task> deleteTask(@PathVariable long id) {
		service.deleteTask(id);
		return service.findAllTasks();
	}
	
	
/*
	@GetMapping("/listtsk")
	public ModelAndView listTsk() {
		//List<Employee> allemps = (List<Employee>) repo.findAll();
		System.out.println("----------1)inside listTsk");
		List<Task> alltsks = (List<Task>) service.findAllTasks();
		System.out.println("----------2)inside listTsk");
		return new ModelAndView("tsks", "tasks", alltsks);
		
	}
	@GetMapping("/addtsk")
	public ModelAndView addnewTsk() {
		
		Task t1 = new Task();
		return new ModelAndView("newtsk", "form", t1);  //model attribure<form:form modelAttribute="form">
	}
	@PostMapping("/addtsk")
	public String newTsk(Task tsk) {
		//repo.save(emp);
		try {
			service.saveTask(tsk);
		} catch (FailedDatabaseActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("--------------BEFORE REDIRECTING----------");
		return ("redirect:/listtsk");
	}
	
	@GetMapping("/edittsk")
	public ModelAndView getEditTsk() {
		Task t1 = new Task();
		System.out.println("--------------INSIDE EDITPOST----------");
		return new ModelAndView("taskeditform", "form", t1);
	}
	@PostMapping("/edittsk")
	public ModelAndView postEditTsk(@ModelAttribute("Task") Task tsk) {
		

		try {
			Task t = service.findTaskById(tsk.getId()).get();
			long id = t.getId();
			return new ModelAndView("redirect:/editingtsk/" + id);
		} catch (Exception e) {
			return new ModelAndView("wrong");
			//throw new WrongInputException("wrong");
			
		}
	}
//	@GetMapping("/editingtsk")
//	public ModelAndView getEditingTsk(@RequestParam("id") long id)  {
//		System.out.println("toooooooooooooodaaaaaaaaaaaaaaaaaaaaaaaaaaaayyyyyyyyyyyyyyyyyyyyyy");
//		Optional<Task> tsk = service.findTaskById(id);
//		return new ModelAndView("taskediting", "edittsk", tsk);
//	}
//	
	
	
	@GetMapping("/editingtsk/{id}")
	public ModelAndView getEditingTsk(@PathVariable("id") long id)  {
		ModelAndView mav = new ModelAndView("taskediting");
		try {
			Task tsk = service.findTaskById(id).get();
			mav.addObject("edittsk", tsk);

		} catch (Exception e) {
			//throw new WrongInputException("wrong");
			return new ModelAndView("wrong");
		}
		return mav;
	}
	@PostMapping("/editingtsk/{id}")
	public ModelAndView postgetEditingTsk(@ModelAttribute("Task") Task tsk) {
		try {
			service.saveTask(tsk);
		} catch (FailedDatabaseActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/listtsk");
	}
	/////////////////////
	/////////////////////
	@GetMapping("/deletetsk")
	public ModelAndView getDeleteTsk() {
		Task t1 = new Task();
		System.out.println("--------------INSIDE EDITPOST----------");
		return new ModelAndView("taskdeleteform", "form", t1);
	}
	@PostMapping("/deletetsk")
	public ModelAndView postDeleteTsk(@ModelAttribute("Task") Task tsk) {
		try {
			Task t = service.findTaskById(tsk.getId()).get();
			long id = t.getId();
			return new ModelAndView("redirect:/deletingtsk/" + id);
		} catch (Exception e) {
			return new ModelAndView("wrong");
		}
	}
	@GetMapping("/deletingtsk/{id}")
	public ModelAndView getDeletingTsk(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("taskdeleting");
		try {
			Task tsk = service.findTaskById(id).get();
			mav.addObject("dlttsk", tsk);

		} catch (Exception e) {
			return new ModelAndView("wrong");
		}
		return mav;
	}
	@PostMapping("/deletingtsk/{id}")
	public ModelAndView postgetDeletingTsk(@ModelAttribute("Task") Task tsk) {
		//service.saveTask(tsk);
		try {
			service.deleteTask(tsk);
		} catch (FailedDatabaseActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/listtsk");
	}
*/	
	
	
}
