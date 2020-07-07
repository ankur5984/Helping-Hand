package com.app.pojos;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="user_details")
public class User1 {
	Integer userId;
	String name;
	String age;
	String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date dob;
	String address;
	String occupation;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date regisration_date;
	String mobile;
	String email;
	String password;
	//mapping user to child pojo
	
	
	
	private Childinfo childInfo;
	
	@OneToOne
	@JoinColumn(name="childId")
	public Childinfo getChildInfo() {
		return childInfo;
	}

	public void setChildInfo(Childinfo childInfo) {
		this.childInfo = childInfo;
	}

	//constructor
	public User1() {
		System.out.println("in user constructor");
	}
	
	public User1(Integer userId, String name, String age, String gender, Date dob, String address, String occupation,
			Date regisration_date, String mobile, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.occupation = occupation;
		this.regisration_date = regisration_date;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
//getters and setters
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length=30,name="username")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Column(length=15,name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="dateofbirth")
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Column(name="address",length=50)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="Occupation",length=50)
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	@Column(name="reg_date")
	@Temporal(TemporalType.DATE)
	public Date getRegisration_date() {
		return regisration_date;
	}
	public void setRegisration_date(Date regisration_date) {
		this.regisration_date = regisration_date;
	}
	@Column(name="Contact",length=50)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(name="email",length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password",length=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User1 [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dob=" + dob
				+ ", address=" + address + ", occupation=" + occupation + ", regisration_date=" + regisration_date
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}


		

}
