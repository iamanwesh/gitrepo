package com.app.anwesh.Controller;


import java.io.InputStream;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.anwesh.DTO.Userdto;
import com.app.anwesh.Entity.UserRegistration;
import com.app.anwesh.Errorhandler.Usernotfound;
import com.app.anwesh.Services.Iuserservice;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/Shoper")
public class UserController {

	@Autowired
	private Iuserservice service;


	@GetMapping("/")
	public String showform(ModelMap model) {
		Userdto userdto = new Userdto();
		model.addAttribute("userdto", userdto);
		return "Register";
	}

	@PostMapping("/save")
	public String Saveusers(@Valid @ModelAttribute Userdto user, BindingResult result) {
		if (user.getImage().isEmpty()) {
			result.addError(new FieldError("user", "image", "Image is required"));
		}
		if (result.hasErrors()) {
			return "Register";
		}
		MultipartFile image = user.getImage();
		String imagefilename = image.getOriginalFilename();

		try {
			String uploadpath = "C:/Users/litun/Documents/Shopping/src/main/resources/static/Images/";
			java.nio.file.Path paths = Paths.get(uploadpath);
			if (!Files.exists(paths)) {
				Files.createDirectories(paths);
			}
			try (InputStream inputstream = image.getInputStream()) {
				Files.copy(inputstream, Paths.get(uploadpath + imagefilename), StandardCopyOption.REPLACE_EXISTING);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		UserRegistration users = new UserRegistration();
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setEmail(user.getEmail());
		users.setGender(user.getGender());
		users.setAddress(user.getAddress());
		users.setPhoneno(user.getPhoneno());
		users.setImage(imagefilename);
		service.registeruser(users);
		return "Register";
	}

	@GetMapping("/users")
	public String showusers(ModelMap model) {
		List<UserRegistration> userlist = service.showuser();
		model.addAttribute("userlist", userlist);
		return "allusers";
	}

	@GetMapping("/edit")
	public String showupdate(@RequestParam Long id, Model model) {
		UserRegistration users = service.getOneuser(id);
		model.addAttribute("users", users);
		
		Userdto userdto=new Userdto();
		userdto.setUsername(users.getUsername());
		userdto.setPassword(users.getPassword());
		userdto.setEmail(users.getEmail());
		userdto.setGender(users.getGender());
		userdto.setAddress(users.getAddress());
		userdto.setPhoneno(users.getPhoneno());
		model.addAttribute("userdto", userdto);
		return "edituser";
	}

	

	@GetMapping("/delete")
	public String deleteuser(@RequestParam Long id, Model model, RedirectAttributes attrib) {
		try {
			service.deleteuserdata(id);
			attrib.addAttribute("message", "User Deleted");

		} catch (Usernotfound e) {

			e.printStackTrace();
			attrib.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:users";
	}
}
