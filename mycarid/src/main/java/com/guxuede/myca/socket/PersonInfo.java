package com.guxuede.myca.socket;

import java.io.Serializable;

public class PersonInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String avatar;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
