package com.vic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vic.entity.User;
import com.vic.modal.ResponseModal;
import com.vic.service.IRedisService;
import com.vic.service.IUserService;

@RestController
public class ExampleController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRedisService redisService;


    @RequestMapping("/sync")
    public int sync(){
        List<User> users = userService.getAll();
        //ResponseModal modal = new ResponseModal(200,true,"",users);
        //return modal;
        int suceflag=1;
        for(User user:users){
            boolean isOk=redisService.set(user.getC_data_type()+"_"+user.getIiiii(),user.getC_data_type_new());
            if(!isOk){
                suceflag=0;
                break;
            }
        }
        return suceflag;
    }

	@RequestMapping("/users")
	public List<User> users(){
		List<User> users = userService.getAll();
		//ResponseModal modal = new ResponseModal(200,true,"",users);
		//return modal;
        return users;
	}

	@RequestMapping("/redis/set")
	public ResponseModal redisSet(@RequestParam("value")String value){
		boolean isOk = redisService.set("name", value);
		return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
	}

	@RequestMapping("/redis/get")
	public ResponseModal redisGet(){
		String name = redisService.get("name");
		return new ResponseModal(200, true,"success",name);
	}

}
