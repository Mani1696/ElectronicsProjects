package com.example.MyDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDao {
	@Autowired
	EmpRepo er;
	public String Post(Employee e) {
		er.save(e);
		return "Data Saved Succesfully";
	}
	String PostAll(List<Employee> e) {
		er.saveAll(e);
		return "Data saved successfully";
	}
	public Employee getById(int id) {
		return er.findById(id).get();
	}
	public List<Employee> getAll() {
		return er.findAll();
	}
	public String deleteById(int id) {
		er.deleteById(id);
		return "Data Deleted";
	}
	public String update(Employee e) {
		er.save(e);
		return "Uptaded";
	}

}
