package com.clc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clc.business.ItemBO;
import com.clc.business.UserBO;
import com.clc.model.Item;
import com.clc.model.User;

@Controller
public class MainController {
	@Autowired
	public UserBO userBO;

	@Autowired
	public ItemBO itemBO;

	private Map<String, Object> serviceResult = new HashMap<String, Object>();
	// private List<Item> items = new ArrayList<Item>();
	private String message = "";
	// private Logger LOGGER = Logger.getLogger(message, MainController.class);

	@RequestMapping(path = { "/register" }, method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = new User();
		String method = request.getMethod();
		if (method.equalsIgnoreCase(RequestMethod.GET.toString())) {
			mv.setViewName("register");

		} else if (method.equalsIgnoreCase(RequestMethod.POST.toString())) {
			user.setPassword((String) request.getParameter("password"));
			user.setUsername((String) request.getParameter("username"));
			boolean didRegister = userBO.registerUser(user);
			if (didRegister) {
				message += "User registered successfully";
			} else {
				message += "User already exists";
			}
			// mv.addObject("message", message);
			serviceResult.put("message", message);
			serviceResult.put("user", user);
			mv.addAllObjects(serviceResult);
			mv.setViewName("login");
		}
		return mv;

	}

	@GetMapping(path = { "/", "/home" })
	public ModelAndView viewHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView loginUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		// mv.addObject("message", "Welcome to user registration");
		return mv;
	}

	@GetMapping("/order")
	public ModelAndView showKitchen() {
		ModelAndView mv = new ModelAndView();
		serviceResult.put("items", itemBO.fetchAll());
		mv.addAllObjects(serviceResult);
		mv.setViewName("order");
		return mv;
	}

	/*
	 * @PostMapping(path = { "/login" }) public ModelAndView
	 * login(@RequestParam("username") String username, @RequestParam("password")
	 * String password) throws Exception { ModelAndView mv = new ModelAndView();
	 * User user = new User(); List<Item> items = itemBO.fetchAll();
	 * user.setPassword(password); user.setUsername(username); boolean isAllowLogin
	 * = userBO.login(user); if (isAllowLogin) { mv.addObject("message",
	 * "Login Successful"); mv.addObject("items", items); serviceResult.put("user",
	 * user); mv.addObject("user", user); mv.setViewName("kitchen"); } else {
	 * mv.addObject("message", "Invalid User/Password"); mv.setViewName("login"); }
	 * return mv; }
	 */

	@SuppressWarnings("unused")
	@PostMapping(path = "/checkout")
	public ModelAndView processOrder(@RequestParam("item") List<Integer> itemIds) throws Exception {
		List<Item> itemsList = itemBO.fetchAll();
		List<Item> itemsSelectedList = new ArrayList<Item>();
		for (int x = 0; x < itemIds.size(); x++) {
			itemsSelectedList.add(itemBO.findById(itemIds.get(x)));
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemsSelected", itemsSelectedList);
		mv.addObject("message", "Successfully placed the order");
		mv.setViewName("checkout");
		return mv;
	}

	@PostMapping(path = "/logout")
	public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			serviceResult = null;
		}
		return "redirect:/";
	}
}
