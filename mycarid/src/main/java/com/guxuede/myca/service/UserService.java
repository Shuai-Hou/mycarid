package com.guxuede.myca.service;

import org.springframework.stereotype.Service;

import com.guxuede.myca.entity.User;

@Service
public class UserService {

	public User createUser(String name,String avatar,String color){
		return new User(name,avatar,color);
	}
}
