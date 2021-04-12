package com.tyss.assignment.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Results implements Serializable {

	@Column
	private int id;
	@Id
	@Column
	private Date time_Date;
	@Column
	private int marks;
	@Column
	private int percentage;
	@Column
	private String userName;

}
