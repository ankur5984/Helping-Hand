package com.app.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="happiness_details")
public class Hapiness_Support implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Properties
	private Integer H_id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	Date time;
	private String location;
	private String event;
	private Integer User_id;
	private Integer Ngo_id;
	//Default Constructor
	public Hapiness_Support() {
		super();
	}
	// Constructor
	
	public Hapiness_Support(Integer h_id, Date time, String location, String event, Integer user_id, Integer ngo_id) {
		super();
		H_id = h_id;
		this.time = time;
		this.location = location;
		this.event = event;
		User_id = user_id;
		Ngo_id = ngo_id;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getH_id() {
		return H_id;
	}
	public void setH_id(Integer h_id) {
		H_id = h_id;
	}
	
	
	  @Column(name="venue_date")
	  @Temporal(TemporalType.DATE) public Date getTime() { return time; }
	  public void setTime(Date time) { this.time = time; }
	 
	
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getLocation() {
		return location;
	}
	
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public Integer getUser_id() {
		return User_id;
	}
	
	
	public void setUser_id(Integer user_id) {
		User_id = user_id;
	}
	
	
	public Integer getNgo_id() {
		return Ngo_id;
	}
	
	
	public void setNgo_id(Integer ngo_id) {
		Ngo_id = ngo_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public String toString() {
		return "Hapiness_Support [H_id=" + H_id + ", location=" + location + ", User_id=" + User_id
				+ ", Ngo_id=" + Ngo_id + "]";
	}
	
	
	
	
	

}
