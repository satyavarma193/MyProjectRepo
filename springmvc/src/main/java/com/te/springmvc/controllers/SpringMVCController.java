package com.te.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.springmvc.beans.UserBean;

@Controller
public class SpringMVCController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping(path = "/hi", method = RequestMethod.GET)
	public ModelAndView getHiPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hiPage");
		return modelAndView;
	}

	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public ModelAndView getData(ModelAndView modelAndView, HttpServletRequest request) {
		String name = request.getParameter("name");
		modelAndView.addObject("username", name);
		modelAndView.setViewName("search");
		return modelAndView;

	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "loginForm";

	}

	@PostMapping("/login")
	public String getFormData(HttpServletRequest request, ModelMap map) {
		String name = request.getParameter("user");
		int password = Integer.parseInt(request.getParameter("pwd"));
		map.addAttribute("user", name);
		map.addAttribute("pwd", password);
		return "userData";

	}

	@PostMapping("/login1")
	public String getDataTwo(ModelMap map, int pwd, String user) {
		map.addAttribute("user", user);
		map.addAttribute("pwd", pwd);
		return "userData";
	}

	@PostMapping("/login2")
	public String getDataBean(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute("user", userBean.getUser());
		modelMap.addAttribute("pwd", userBean.getPwd());
		return "userData";
	}

	@PostMapping("/login3")
	public String getFormDataRequestParam(ModelMap modelMap, @RequestParam(name = "") String user,
			@RequestParam(name = "pwd") int password) {
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("pwd", password);
		return "userData";
	}

}
