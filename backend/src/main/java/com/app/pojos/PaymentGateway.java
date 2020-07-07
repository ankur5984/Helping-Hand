package com.app.pojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paymentgateway_details")
public class PaymentGateway implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer paymentId;
	private Integer amount;
	private String description;
	private Integer userId;
	
	
	private Childinfo childInfo;
	@OneToOne
	@JoinColumn(name="childId")
	public Childinfo getChildInfo() {
		return childInfo;
	}


	public void setChildInfo(Childinfo childInfo) {
		this.childInfo = childInfo;
	}


	public PaymentGateway() {
		super();
	}
	
	
	public PaymentGateway(Integer paymentId, Integer amount, String description,Integer userId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.description = description;
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "PaymentGateway [paymentId=" + paymentId + ", amount=" + amount + ", description=" + description
				+ ", userId=" + userId + "]";
	}

}
