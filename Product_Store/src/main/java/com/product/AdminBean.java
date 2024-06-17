package com.product;
import java.io.*;
@SuppressWarnings("serial")
public class AdminBean implements Serializable{
private String Uname,Pword,Fname,Lname,Addr,Mail;
private long phno;
public AdminBean()
{
	
}
public String getUname() {
	return Uname;
}
public void setUname(String uname) {
	Uname = uname;
}
public String getPword() {
	return Pword;
}
public void setPword(String pword) {
	Pword = pword;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getAddr() {
	return Addr;
}
public void setAddr(String addr) {
	Addr = addr;
}
public String getMail() {
	return Mail;
}
public void setMail(String mail) {
	Mail = mail;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
}
