package com.te.springmvc.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeBean implements Serializable {

	@Id
	@Column
	private Integer id;
	@Column
	private String name;
	@Column(name = "dob")
	private Date birthDate;
	@Column
	@Exclude
	private String password;

}
