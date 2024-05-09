package com.user.entities;

import org.springframework.stereotype.Component;

@Component
public class Number {
	private int aId;
	private String soc;
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getSoc() {
		return soc;
	}
	public void setSoc(String soc) {
		this.soc = soc;
	}
	public Number(int aId, String soc) {
		super();
		this.aId = aId;
		this.soc = soc;
	}
	public Number() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Adress [aId=" + aId + ", soc=" + soc + "]";
	}
	

}
