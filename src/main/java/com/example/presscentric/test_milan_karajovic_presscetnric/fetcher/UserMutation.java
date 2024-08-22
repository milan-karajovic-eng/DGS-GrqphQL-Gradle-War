package com.example.presscentric.test_milan_karajovic_presscetnric.fetcher;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.presscentric.test_milan_karajovic_presscetnric.domain.CreateUserInput;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.UpdateUserInput;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.example.presscentric.test_milan_karajovic_presscetnric.service.UserService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import jakarta.validation.Valid;

@DgsComponent
public class UserMutation {
	
	@Autowired
	UserService userService;
	
	@DgsData(parentType = "Mutation", field = "createUser")
    public User createUser(@InputArgument("input") CreateUserInput userInput) {
		return userService.save(new User(null, userInput.getName(), userInput.getEmail()));
	}
	
	@DgsData(parentType = "Mutation", field = "updateUser")
    public User updateUser(@InputArgument("id") Integer id, @Valid @InputArgument("input") UpdateUserInput userInput) {
		return userService.updateUser(id, userInput.getName(), userInput.getEmail());
	}
	
	@DgsData(parentType = "Mutation", field = "deleteUser")
    public User deleteUser(@InputArgument("id") Integer id) {
		return userService.deleteUserById(id);
	}
	
}
