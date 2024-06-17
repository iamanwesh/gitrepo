package com.product;
import java.io.*;
@SuppressWarnings("serial")
public class Productbean implements Serializable {
private String PCode,Pname;
private int Price,Quant;
public Productbean() {}
public String getPCode() {
	return PCode;
}
public void setPCode(String pCode) {
	PCode = pCode;
}
public String getPname() {
	return Pname;
}
public void setPname(String pname) {
	Pname = pname;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
public int getQuant() {
	return Quant;
}
public void setQuant(int quant) {
	Quant = quant;
}
}
