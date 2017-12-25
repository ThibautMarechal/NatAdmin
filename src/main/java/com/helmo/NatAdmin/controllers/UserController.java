package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.UserForm;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {
	private final UserService userService;
	private final Environment env;
	
	public UserController(UserService userService, Environment env) {
		this.userService = userService;
		this.env = env;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "users/all";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Long id, Model model) {
		User u = userService.getById(id);
		model.addAttribute("user", u);
		return "users/view";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String edit(@PathVariable("id") Long id, Model model, @ModelAttribute UserForm userForm) {
		//TODO Validate user input
		User user = userService.getById(id);
		user.setFullName(userForm.getFullName());
		user.setEmail(userForm.getEmail());
		user.setAdmin(userForm.isAdmin());
		userService.update(user);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String delete(@PathVariable("id") Long id) {
		//LOGIC
		userService.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(Model model, @ModelAttribute UserForm userForm) {
		//TODO Validate user input
		User user = new User();
		user.setFullName(userForm.getFullName());
		user.setEmail(userForm.getEmail());
		user.setAdmin(userForm.isAdmin());
		user.setPassword(userForm.getPassword());
		long id = userService.create(user);
		return String.format(
			  "{" +
					"\"status\":1," +
					"\"content\":" +
					"{" +
					"\"id\":%d" +
					"\"fullName\": \"%s\"" +
					"\"email\": \"%s\"" +
					"\"admin\": %b" +
					"}" +
					"}", id, user.getFullName(), user.getEmail(), user.isAdmin());
	}
}
