package com.example.MyDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeService es;
	@PostMapping(value="/post")
	public String Postvalues(@RequestBody Employee e) {
		return es.Post(e);
	}
	@PostMapping(value="/postAll")
	String PostAll(@RequestBody List<Employee> e) {
		return es.PostAll(e);
	}
	@GetMapping(value="/Get/{id}")
	public Employee getById(@PathVariable int id) {
		return es.getById(id);
	}
	@GetMapping(value="/GetAll")
	public List<Employee> getAll() {
		return es.getAll();
	}
	@DeleteMapping(value="/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return es.deleteById(id);
	}
	@PutMapping(value="/update")
	public String update(@RequestBody Employee e) {
		return es.update(e);
	}
	@GetMapping(value="/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return es.getByGender(gender);
	}
	@GetMapping (value="/getByAge") 
	public Employee getByAge() {
		return es.getByAge();
	}
	@GetMapping(value="/getByGenders/{gender}")
	public List<String> getByGenders(@PathVariable String gender) {
		return es.getByGenders(gender);
	}
	@GetMapping(value="/getByAges/{a}/{b}")
	public List<Employee> getByAges(@PathVariable int a,@PathVariable int b) {
		return es.getByAges(a,b);
	}
	
	@GetMapping(value="/getByLastCh/{name}")
	public List<Character> getByLastch(@PathVariable String name) {
		return es.getByLastCh(name);
	}
}

