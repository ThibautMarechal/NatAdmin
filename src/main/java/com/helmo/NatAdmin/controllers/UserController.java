package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.UserForm;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@GetMapping
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
		//TODO Validate RUser input
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
		return "{\"status\":1}";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(Model model, @ModelAttribute UserForm userForm) {
		//TODO Validate RUser input
		User user = new User();
		user.setFullName(userForm.getFullName());
		user.setEmail(userForm.getEmail());
		user.setAdmin(userForm.isAdmin());
		long id = userService.create(user);
		return String.format("{\"status\":1,\"newId\":%d}", id);
	}
}
