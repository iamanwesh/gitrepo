package com.app.anwesh.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.anwesh.Entity.Student;
import com.app.anwesh.service.IStudentservice;

@Controller
//@RequestMapping("/student")
@RequestMapping({"/student","/"})
public class Studentcontroller {
	
	@Autowired
	private IStudentservice service;
	
	//@GetMapping("/register")
	@GetMapping({"/register","/"})
	public String showRegister()
	{
		return "StudentRegister";
	}
	
	@PostMapping("/save")
	public String SaveData(@ModelAttribute Student student,Model model)
	{
		Integer id=service.savestudent(student);
		String Message="Student '"+id +"'Detail created";
		model.addAttribute("Message", Message);
		return "StudentRegister";
	}
	
	@GetMapping("/all")
	public String showall(Model model)
	{
		List<Student> lst=service.getallstudent();
		model.addAttribute("lst", lst);
		
		return "Studentdata";
	}
	
	@GetMapping("/edit")
	public String showedit(@RequestParam Integer id,Model model)
	{
		String page=null;
		try {
			Student s=service.getstudent(id);
			model.addAttribute("s", s);
			page="Studentedit";
		} catch (Exception e) {
			
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
			page="redirect:all";
			
		}
		return page ;
	}
	@PostMapping("/update")
	public String updatepage(@ModelAttribute Student student,RedirectAttributes attribute)
	{
		service.updateStudent(student);
		attribute.addAttribute("message","Student'"+student.getStdid()+"' Updated");
		return "redirect:all";
	}
	
}
