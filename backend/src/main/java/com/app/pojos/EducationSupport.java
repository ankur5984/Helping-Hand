package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="education_details")
public class EducationSupport {
	//properties
	private int Education_id;
	private double amount;
	private String name;
	private String gender;
	private int C_id;
	private int U_id;
	private int N_id;
	//Constructor
	public EducationSupport() {
		System.out.println("In default constructor Education support");
	}
	public EducationSupport(int e_id, double amount, String name, String gender, int c_id, int u_id, int n_id) {
		super();
		Education_id = e_id;
		this.amount = amount;
		this.name = name;
		this.gender = gender;
		C_id = c_id;
		U_id = u_id;
		N_id = n_id;
	}
	//getter setter
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getE_id() {
		return Education_id;
	}
	public void setE_id(int e_id) {
		Education_id = e_id;
	}
	
	@Column(name="amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Column(length=30,name="childName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=15,name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getC_id() {
		return C_id;
	}
	public void setC_id(int c_id) {
		C_id = c_id;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int u_id) {
		U_id = u_id;
	}
	public int getN_id() {
		return N_id;
	}
	public void setN_id(int n_id) {
		N_id = n_id;
	}
	//toString
	@Override
	public String toString() {
		return "EducationSupport [E_id=" + Education_id + ", amount=" + amount + ", name=" + name + ", gender=" + gender
				+ ", C_id=" + C_id + ", U_id=" + U_id + ", N_id=" + N_id + "]";
	}
	
	
}
