package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MoneySupport")
public class MoneySupport
{
private int MoneyId;
private double amount;
private String details;
private int UserId;
private int NgoId;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int getMoneyId() {
	return MoneyId;
}

public void setMoneyId(int moneyId) {
	MoneyId = moneyId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public int getNgoId() {
	return NgoId;
}
public void setNgoId(int ngoId) {
	NgoId = ngoId;
}
@Override
public String toString() {
	return "MoneySupport [MoneyId=" + MoneyId + ", amount=" + amount + ", details=" + details + ", UserId=" + UserId
			+ ", NgoId=" + NgoId + "]";
}


}
