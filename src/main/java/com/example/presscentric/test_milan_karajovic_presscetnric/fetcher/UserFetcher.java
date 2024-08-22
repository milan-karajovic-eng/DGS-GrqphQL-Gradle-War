package com.example.presscentric.test_milan_karajovic_presscetnric.fetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.example.presscentric.test_milan_karajovic_presscetnric.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class UserFetcher {
	
	@Autowired
	UserService userService;
	
	
	@DgsData(parentType = "Query", field = "users")
    public List<User> findAllUsers() {
        return userService.findAll();
    }
	
	@DgsData(parentType = "Query", field = "user")
    public User findUserById(@InputArgument("id") Integer id) {
		return userService.findUserById(id);
    }
	
}
