package com.klu.java_hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
int id;
String fn,ln;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFn() {
	return fn;
}
public void setFn(String fn) {
	this.fn = fn;
}
public String getLn() {
	return ln;
}
public void setLn(String ln) {
	this.ln = ln;
}

}
