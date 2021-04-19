package com.te.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.dao.EmployeeDao;

@Service
public class EmployeeServiceimplementation implements EmployeeService {

	@Autowired
	EmployeeDao employee;

	@Override
	public EmployeeBean authenticate(int id, String password) {

		return employee.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployeeData(int id) {

		return employee.getEmployeeData(id);
	}

	@Override
	public boolean deleteEmpData(int id) {

		return employee.deleteEmpData(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {

		return employee.getAllEmp();
	}

}
