package com.guxuede.myca.service;


import org.springframework.stereotype.Service;

import com.guxuede.myca.entity.ChatSession;
import com.guxuede.myca.entity.Forum;
import com.guxuede.myca.entity.Room;

@Service
public class ChatService {

	public Forum createOrJoinForum(Room r,ChatSession session){
		Forum f=DB.forums.get(r);
		if(f==null){
			session.setRoom(r);
			f=new Forum(r,session);
			DB.forums.put(r,f);
		}else{
			f.joinUser(session);
		}
		return f;
	}
	
	public void userSpeack(ChatSession session,String msg){
		DB.forums.get(session.getRoom()).speackAll(session, msg);
	}
}
