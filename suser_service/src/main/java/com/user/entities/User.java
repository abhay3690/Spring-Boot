package com.user.entities;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
private int id;
private String name;
private  Number number;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Number getNumber() {
	return number;
}
public void setNumber(Number number) {
	this.number = number;
}
public User(int id, String name, Number number) {
	super();
	this.id = id;
	this.name = name;
	this.number = number;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", number=" + number + "]";
}





















































}
