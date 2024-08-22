package com.example.presscentric.test_milan_karajovic_presscetnric.fetcher;

import com.example.presscentric.test_milan_karajovic_presscetnric.domain.CreateUserInput;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.UpdateUserInput;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import jakarta.validation.Valid;

@DgsComponent
public class UserMutation {
	
	@DgsData(parentType = "Mutation", field = "createUser")
    public User createUser(@InputArgument("input") CreateUserInput userInput) {
		// TODO: To be implemented
		return null;
	}
	
	@DgsData(parentType = "Mutation", field = "updateUser")
    public User updateUser(@InputArgument("id") Integer id, @Valid @InputArgument("input") UpdateUserInput userInput) {
		// TODO: To be implemented
		return null;
	}
	
	@DgsData(parentType = "Mutation", field = "deleteUser")
    public User deleteUser(@InputArgument("id") Integer id) {
		// TODO: To be implemented
		return null;
	}
	
}
