package com.user.entity;

public class Contact {
	private int cId;
	private String email;
	private String contactName;
	private Long userId;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int cId, String email, String contactName, Long userId) {
		super();
		this.cId = cId;
		this.email = email;
		this.contactName = contactName;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", email=" + email + ", contactName=" + contactName + ", userId=" + userId + "]";
	}
	
	
}
