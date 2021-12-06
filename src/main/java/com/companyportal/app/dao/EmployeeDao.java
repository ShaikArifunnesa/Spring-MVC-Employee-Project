package com.companyportal.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

public interface EmployeeDao {

	void saveEmployeeData(Employee employee);
		
	void deleteEmployeeById(int id);
	
	Employee getById(int employeeId);
	
	void update(Employee employee);
	
	List<Employee> getEmployeesData();
	
	//Employee search(int id);

}
