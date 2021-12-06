package com.companyportal.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static int count;
	
	@Autowired
	private EmployeeDao employeeDao;

	//private Object employeeRepository;
	
	@Override
	public void saveEmployeeData(Employee employee) {
		employee.setEmployeeId(count++);
		
		employeeDao.saveEmployeeData(employee);
	}
	@Override
	public void deleteEmployeeById(int id) {
	employeeDao.deleteEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployeesData() {
		
		return employeeDao.getEmployeesData();
	}
	@Override
	public Employee getById(int employeeId) {
		return employeeDao.getById(employeeId);
	}
	@Override
	public void update(Employee emp) {
	 employeeDao.update(emp);
		
	}
	/*@Override
	public Employee search(int id) {
			return employeeDao.search(id);
	}*/
	
	
		
}
