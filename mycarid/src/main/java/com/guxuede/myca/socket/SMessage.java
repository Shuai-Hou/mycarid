package com.guxuede.myca.socket;

import java.io.Serializable;
import java.util.Date;

public class SMessage implements Serializable{

	private static final long serialVersionUID = 3216636701219491800L;
	
	private String name;
	private String room;
	private String avatar;
	private String msg;
	private Date time=new Date();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
