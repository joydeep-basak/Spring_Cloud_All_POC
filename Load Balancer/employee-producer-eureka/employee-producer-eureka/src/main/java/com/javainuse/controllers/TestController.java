package com.javainuse.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;

@RestController
public class TestController {
	
	private static final List<Employee> employeeList = new ArrayList<>();
	
	static {
		for (int i = 0; i < 10; i ++) {
			Employee emp = new Employee();
			emp.setName("emp" + (i +1));
			emp.setDesignation("manager" + (i +1));
			emp.setEmpId((i + 1) + "");
			emp.setSalary(3000 + i);
			
			employeeList.add(emp);
		}
		
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}
	
	@PostMapping(value = "/employess")
	public List<Employee> getAllEmployee() {
		try {
			Thread.currentThread();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

}
