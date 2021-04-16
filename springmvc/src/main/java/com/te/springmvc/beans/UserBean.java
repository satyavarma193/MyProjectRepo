package com.te.springmvc.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable {

	private String user;

	private int pwd;

}
