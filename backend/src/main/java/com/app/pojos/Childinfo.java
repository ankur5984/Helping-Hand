package com.app.pojos;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="child_info")
public class Childinfo {  
	
	private Integer childId;
	private String name;
	private Integer age;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String ngoId;
	
	@OneToOne(mappedBy = "childInfo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private PaymentGateway p = new PaymentGateway();
	
	@OneToOne(mappedBy = "childInfo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private User1 u = new User1();
	
	
	/*
	 * public PaymentGateway getPaymentGateway() { return paymentGateway; } public
	 * void setPaymentGateway(PaymentGateway paymentGateway) { this.paymentGateway =
	 * paymentGateway; }
	 */
	public Childinfo()
	{
		super();
	}
	public Childinfo(Integer childId, String name, Integer age, String gender, Date dob, String ngoId) {
		super();
		this.childId = childId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.ngoId = ngoId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getChildId() {
		return childId;
	}
	public void setChildId(Integer childId) {
		this.childId = childId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getNgoId() {
		return ngoId;
	}
	public void setNgoId(String ngoId) {
		this.ngoId = ngoId;
	}
	@Override
	public String toString() {
		return "Childinfo [childId=" + childId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dob="
				+ dob + ", ngoId=" + ngoId + ", p=" + p + ", u=" + u + "]";
	}
	

	
	
	

	
}
