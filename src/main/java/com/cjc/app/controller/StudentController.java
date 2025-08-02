package com.cjc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cjc.app.constants.UserCredentials;
import com.cjc.app.model.Student;
import com.cjc.app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@RequestMapping(value = "/")
	public String handleLandingRequest() {
		return "index";
	}

	@RequestMapping(value = "/reg")
	public String handleRegRequest() {
		return "register";
	}

	@RequestMapping(value = "/register")
	public String handleRegisterRequest(@ModelAttribute Student student) {
		System.out.println("In Controller Layer :" + student);
		studentservice.saveStudent(student);
		return "index";
	}

	@RequestMapping(value = "/log")
	public String handleLogRequest() {
		return "login";
	}

	@RequestMapping(value = "/login")
	public String handleLoginRequest(@RequestParam String username, @RequestParam String password, Model model) {
		System.out.println("username :" + username);
		System.out.println("password :" + password);

		// validate username and password
		if (username.equalsIgnoreCase(UserCredentials.USERNAME) && password.equals(UserCredentials.PASSWORD)) {
			List<Student> list = studentservice.getStudents();
			model.addAttribute("data", list);
			return "success";
		}
		return "index";
	}

	@RequestMapping(value = "/delete")
	public String handleDeleteRequest(@RequestParam int rollno, ModelMap modelmap) {
		System.out.println(rollno);

		studentservice.deleteStudent(rollno);

		List<Student> list = studentservice.getStudents();
		modelmap.addAttribute("data", list);
		return "success";
	}

	@RequestMapping(value = "/edit")
	public ModelAndView handleEditRequest(@RequestParam int rollno) {

		Student student = studentservice.getStudent(rollno);

		ModelAndView m = new ModelAndView();
		m.setViewName("update");
		m.addObject("stu", student);
		return m;
	}

	@RequestMapping(value = "/update")
	public ModelAndView handleUpadateRequest(@ModelAttribute Student student) {
		System.out.println("Student data :" + student);
		studentservice.saveStudent(student);

		List<Student> list = studentservice.getStudents();

		ModelAndView mv = new ModelAndView("success", "data", list);

		return mv;
	}

}
