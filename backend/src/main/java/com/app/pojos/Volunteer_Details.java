package com.app.pojos;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="volunteer_details")
public class Volunteer_Details {
	
	public int volunteerId;
	public String name;
	public String gender;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date dateOfBirth;
	public String occupation;
	public String address;
	public String email;
	public String password;
	public String mobileNo;
	
	
	
	public Volunteer_Details(int volunteerId, String name, String gender, Date dateOfBirth, String occupation,
			String address, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.occupation = occupation;
		this.address = address;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}
	
	
	public Volunteer_Details() {
		System.out.println("in volunteer constructor");
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="DateOfBirth")
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	
	
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Volunteer_Details [volunteerId=" + volunteerId + ", name=" + name + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", occupation=" + occupation + ", address=" + address + ", email="
				+ email + ", password=" + password + ", mobileNo=" + mobileNo + "]";
	}

}
