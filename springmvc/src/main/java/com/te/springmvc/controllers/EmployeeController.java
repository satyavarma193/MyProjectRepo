package com.te.springmvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employee;

	@GetMapping("/emplogin")
	public String getLogin() {
		return "login";
	}// End of getLogin Method

	@PostMapping("/empLogin")
	public String authenticate(int id, String pwd, HttpServletRequest request, ModelMap map) {
		EmployeeBean bean = employee.authenticate(id, pwd);
		if (bean != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("emp", bean);
			return "homePage";
		} else {
			map.addAttribute("errmsg", "Invalid credentials");
			return "login";
		}

	}// End of authenticate Method

	@GetMapping("/searchForm")
	public String getSearchForm(ModelMap map, HttpSession session) {
		if (session.getAttribute("emp") != null) {
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getSearchForm Method

	@GetMapping("/empsearch")
	public String getEmpSearch(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			EmployeeBean bean = employee.getEmployeeData(id);
			if (bean != null) {
				map.addAttribute("data", bean);
			} else {
				map.addAttribute("msg", "Data not found for id: " + id);
			}
			return "searchForm";
		} else {
			map.addAttribute("errmsg", "Please Login First");
			return "login";
		}

	}// End of getEmpSearch Method

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg", "Logout Sucessfully");
		return "login";
	}// End of logout Method

	@GetMapping("/showDeletePage")
	public String getdeleteForm(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			return "deleteForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}
	}// End of getdeleteForm Method

	@GetMapping("/deleteEmp")
	public String deleteEmp(int id, ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			Boolean dataBoolean = employee.deleteEmpData(id);
			if (dataBoolean) {
				map.addAttribute("msg", "Deleted successfully");
			} else {
				map.addAttribute("msg", " Data not found ");
			}
			return "deleteForm";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of deleteEmp Method

	@GetMapping("/alldata")
	public String getAllEmpData(ModelMap map,
			@SessionAttribute(name = "emp", required = false) EmployeeBean employeeBean) {
		if (employeeBean != null) {
			List<EmployeeBean> data = employee.getAllEmp();
			if (data != null) {
				map.addAttribute("data", data);
			} else {
				map.addAttribute("errmsg", "Empty Table");
			}
			return "showAll";
		} else {
			map.addAttribute("errmsg", "please login first");
			return "login";
		}

	}// End of getAllEmpData Method
}
