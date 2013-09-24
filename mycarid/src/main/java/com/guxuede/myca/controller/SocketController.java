package com.guxuede.myca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guxuede.myca.socket.MyEchoSocket;
import com.guxuede.myca.socket.PersonInfo;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping("/socket")
public class SocketController {

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/{room}/users", method = RequestMethod.GET)
	@ResponseBody
	public List<PersonInfo> getUser(Model model,@PathVariable(value="room")String room) {
		System.out.println(room);
		List<PersonInfo> users=new ArrayList<PersonInfo>();
		for(MyEchoSocket s:MyEchoSocket.rooms.get("<a href='?room="+room+"'>"+room+"</a>")){
			PersonInfo p=new PersonInfo();
			p.setName(s.name);
			p.setAvatar(s.avatar);
			users.add(p);
		}
		System.out.println(users);
		return users;
	}
	

}
