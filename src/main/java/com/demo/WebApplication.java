package com.demo;

import com.demo.model.Employee;
import com.demo.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
class WebApplication {

	@Autowired
	private EmployeeRepository repository;

	final static Logger LOGGER = LoggerFactory.getLogger(WebApplication.class);

	@RequestMapping(path="/", method= {RequestMethod.GET})
	public String index(HttpSession session) {
		session.setAttribute("color", "blue");
		return "index";
	}
	
	@RequestMapping(path="/kill", method= {RequestMethod.GET})
	public void kill() {		
		LOGGER.info("killing the job");
		System.exit(1);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/query")
	@ResponseBody
	public List<Employee> query() throws Exception {

		List<Employee> results = new ArrayList<Employee>();
		repository.findAll().forEach(item->results.add(item));;

		return results;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/save")
	@ResponseBody
	public String save() throws Exception {

		Employee emp1 = new Employee(1, "Richard", 32);
		repository.save(emp1);

		return emp1.toString();
	}


}