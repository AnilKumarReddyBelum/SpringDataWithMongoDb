package com.spring.mongodb.home.customer.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

@Document(collection="RoomMember")
public class RoomMember implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	
	@Field
	private String name;
	@Field
	private String mailId;
	@Field
	private String spentVia;
	@Field
	private Double amount;
	
	@Field
	private Date spentOn= new Date();

	public String getSpentVia() {
		return spentVia;
	}

	public void setSpentVia(String spentVia) {
		this.spentVia = spentVia;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getSpentOn() {
		return spentOn;
	}

	public void setSpentOn(Date spentOn) {
		this.spentOn = spentOn;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
