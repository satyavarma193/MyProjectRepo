package com.te.springmvc.dao;

import java.util.List;

import com.te.springmvc.beans.EmployeeBean;

public interface EmployeeDao {

	public EmployeeBean authenticate(int id, String password);

	public EmployeeBean getEmployeeData(int id);

	public boolean deleteEmpData(int id);
	
	public List<EmployeeBean> getAllEmp();

}
