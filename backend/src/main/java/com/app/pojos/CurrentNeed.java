package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="currentneed_details")
public class CurrentNeed
{
	private Integer currentId;
	private String name;
	private double quantity;
	private byte[] images;
	//private String images;
	
	public CurrentNeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CurrentNeed(String name, double quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}



	public CurrentNeed(Integer currentId, String name, double quantity) {
		super();
		this.currentId = currentId;
		this.name = name;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCurrentId() {
		return currentId;
	}
	
	public void setCurrentId(Integer currentId) {
		this.currentId = currentId;
	}
	@Column(length = 40)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CurrentNeed [currentId=" + currentId + ", name=" + name + ", quantity=" + quantity + "]";
	}
	
	@Lob
	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	
//	  public String getImages() { return images; }
//	  
//	  public void setImages(String images) { this.images = images; }
//	 
//	
//	
//	  @Lob public byte[] getImages() { return images; }
//	  
//	  public void setImages(byte[] images) { this.images = images; }
	 
	

}
