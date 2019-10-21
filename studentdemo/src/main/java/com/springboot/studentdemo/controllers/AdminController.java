package com.springboot.studentdemo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.studentdemo.dao.CourseRepository;
import com.springboot.studentdemo.model.Course;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private CourseRepository courserepository;
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home()
	{
		return "admin";
	}
	
	@RequestMapping(value = "/adminlogin",method = RequestMethod.GET)
	public String adminlogoin(HttpServletRequest req)
	{
		String username = req.getParameter("uname");
		String password= req.getParameter("pass");
		if(username.equals("keerthi") && password.equals("9963"))
		{
			return "welcome";
		}
		else
		{
			return "admin";
		}
	}
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String update(Model model)
	{
		model.addAttribute("course", new Course());
		return "course";
	}
	
	
	  @RequestMapping(value = "/addcourse",method = RequestMethod.POST)
	  public String addcourse(@ModelAttribute("course") Course course) { 
		  Course co=courserepository.save(course);
		  if(co!=null)
		  {
		return "welcome"; 
		  }
		  else
		  {
			  return "admin";
		  }
	  }
	 
}
