package com.companyportal.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.companyportal.app.dao.impl.EmployeeDaoImpl;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	//enter URL" / " it display registration form
	@RequestMapping(value = "/", method = RequestMethod.GET)
		public String displayRegistrationForm(Model model) {
				// create model attribute to bind form data
		Employee employee = new Employee();	
		model.addAttribute("employee", employee);
		return "employeeform";
	}
	
	//Saving Employee Details...
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	
	//sending data it adds HTTP body
	public String saveEmployeeData(@ModelAttribute Employee employee) {
		//save employee to database
		employeeService.saveEmployeeData(employee);
		
		return "redirect:/employeelist";
	}
	//Updating Employee Details......
	@RequestMapping(value ="/updateEmployee", method = RequestMethod.POST)
	
	//requestParam read the form data provide by user and bind it request parameter
	public ModelAndView editCustomerForm(@RequestParam int employeeId)  {
		// get employee from the service
		Employee emp = employeeService.getById(employeeId);
	    ModelAndView mav = new ModelAndView("editform");
	    mav.addObject("employee", emp);
	 	return mav;
	}
	//Editing employee Details...........
	@RequestMapping(value ="/editData", method = RequestMethod.POST)
	
	//sending data it adds HTTP body
		public String editEmployeeData(@ModelAttribute Employee employee) {
		employeeService.update(employee);
		return "redirect:/employeelist";
	}
	//Deleting Employee details...........
	@RequestMapping(value ="/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employeelist";
	}
	//Searching Employee Details.....
	@RequestMapping(value ="/search", method = RequestMethod.GET)
	
	//requestParam read the form data provide by user and bind it request parameter
	public String searchEmployee(@RequestParam("id") int employeeId,Model model){
		Employee  result = employeeService.getById(employeeId);
			model.addAttribute("employee", result);
			
				return "search";
		
	}
	//Displaying employee list.....
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	
	//model to send and fetch the data
	public String getEmployeesData(Model model) {
		List<Employee> employeeList = employeeService.getEmployeesData();
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
}
