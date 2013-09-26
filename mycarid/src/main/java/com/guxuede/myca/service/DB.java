package com.guxuede.myca.service;

import java.util.concurrent.ConcurrentHashMap;

import com.guxuede.myca.entity.Forum;
import com.guxuede.myca.entity.Room;

public class DB {
	
	public static ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<String,Room>();
	public static ConcurrentHashMap<Room, Forum> forums = new ConcurrentHashMap<Room,Forum>();
	
	static {
		rooms.put("大厅", new Room("大厅",null,null));
		rooms.put("厨房", new Room("厨房",null,null));
	}
}
