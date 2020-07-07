		package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="neccessity_details")
public class Neccessity_support{
	private int neccessityId;
	private String name;
	private int quantity;
	private int userId;
	//default constructor
	public Neccessity_support() {
		super();
	}
	//constructor
	public Neccessity_support(int neccessityId, String name, int quantity, int userId) {
		super();
		this.neccessityId = neccessityId;
		this.name = name;
		this.quantity = quantity;
		this.userId = userId;
	}
	//getter and setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getneccessityId() {
		return neccessityId;
	}

	public void setneccessityId(int Id) {
		neccessityId = Id;
	}
	@Column(length=30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//tostring
	@Override
	public String toString() {
		return "Neccessity_support [neccessityId=" + neccessityId + ", name=" + name + ", quantity=" + quantity
				+ ", userId=" + userId + "]";
	}
}
