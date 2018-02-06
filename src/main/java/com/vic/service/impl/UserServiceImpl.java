package com.vic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.vic.entity.User;
import com.vic.service.IUserService;

import com.vic.mapper.UserMapper;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper usermapper;

	@Override
	public List<User> getAll() {

		return usermapper.getall();
	}
}