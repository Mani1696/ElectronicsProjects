package com.example.MyDatabase;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class EmployeService {
	@Autowired
	EmployeDao ed;
	public String Post(Employee e) {
		return ed.Post(e);
	}
	String PostAll(List<Employee> e) {
		return ed.PostAll(e);
	}
	public Employee getById(int id) {
		return ed.getById(id);
	}
	public List<Employee> getAll() {
		return ed.getAll();
	}
	public String deleteById(int id) {
		return ed.deleteById(id);
	}
	public String update(Employee e) {
		return ed.update(e);
	}
	public List<Employee> getByGender(String gender) {
		List<Employee> x=ed.getAll();
		List<Employee> a=x.stream().filter(z-> z.getGender().equals(gender)).collect(Collectors.toList());
		return a;
	}
	public Employee getByAge() {
		List<Employee> x=ed.getAll();
		Employee a=x.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		return a;
	}
	public List<String> getByGenders(String gender) {
		List<Employee> x=ed.getAll();
		List<String> a=x.stream().filter(z-> z.getGender().equals(gender)).map(y->y.getName()).collect(Collectors.toList()); 
		return a;
	}
	public List<Employee> getByAges(int a,int b) {
		List<Employee> x=ed.getAll();
		List<Employee> ab=x.stream().filter(z-> z.getAge()>a && z.getAge()<b).collect(Collectors.toList());
		return ab;
	}
	public List<Character> getByLastCh(String name) {
		List<Employee> x=ed.getAll();
		List<Character> ab=x.stream().map(z-> z.getName().charAt(z.getName().length()-1)).collect(Collectors.toList());
		return ab;
	}

}
