package com.admin.bean;
import java.io.*;
@SuppressWarnings("serial")
public class Addproductbean implements Serializable {
private String code,name,image,product_catagory;
private Integer price,stock;
public Addproductbean() {}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProduct_catagory() {
	return product_catagory;
}
public void setProduct_catagory(String product_catagory) {
	this.product_catagory = product_catagory;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Integer getStock() {
	return stock;
}
public void setStock(Integer stock) {
	this.stock = stock;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
}