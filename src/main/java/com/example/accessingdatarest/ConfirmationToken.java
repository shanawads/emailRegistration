package com.example.accessingdatarest;

import java.util.Date;
import java.util.UUID;

public class ConfirmationToken {
	
	
	private long tokenid;

	private String confirmationToken;
	
	private Date createdDate;
	
    private Person user;
	
	public ConfirmationToken() {
	}
	
	public ConfirmationToken(Person user) {
		this.user = user;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getTokenid() {
		return tokenid;
	}

	public void setTokenid(long tokenid) {
		this.tokenid = tokenid;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
}
