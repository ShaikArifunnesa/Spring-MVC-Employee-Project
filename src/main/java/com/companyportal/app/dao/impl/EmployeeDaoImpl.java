package com.companyportal.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveEmployeeData(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Employee> getEmployeesData() {
		List<Employee> empList=new ArrayList<Employee>();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		empList=session.createQuery("From Employee").list();
		session.getTransaction().commit();
		session.close();
		
		return empList;
	}

	@Override
	public void deleteEmployeeById(int id) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null)
		{
			session.delete(emp);
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Employee getById(int employeeId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Employee emp=session.get(Employee.class, employeeId);
		session.getTransaction().commit();
		session.close();
		return emp;
	}

	@Override
	public void update(Employee employee) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(employee);
		session.getTransaction().commit();
		session.close();
	}

	/*@Override
	public Employee search(int id) {
		Session session=sessionFactory.openSession();
    	Employee employee=(Employee) session.get(Employee.class, id);
		return employee;
	}*/
	
}
