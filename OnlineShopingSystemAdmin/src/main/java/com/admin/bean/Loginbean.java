package com.admin.bean;

import java.io.Serializable;
//import java.util.Date;

@SuppressWarnings("serial")
public class Loginbean implements Serializable {
private int id;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Loginbean() {}
}

