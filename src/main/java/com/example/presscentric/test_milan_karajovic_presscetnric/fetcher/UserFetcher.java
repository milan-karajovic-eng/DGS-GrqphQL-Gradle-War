package com.example.presscentric.test_milan_karajovic_presscetnric.fetcher;

import java.util.List;

import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class UserFetcher {
	
	@DgsData(parentType = "Query", field = "users")
    public List<User> findAllUsers() {
		// TODO: To be implemented
		return null;
    }
	
	@DgsData(parentType = "Query", field = "user")
    public User findUserById(@InputArgument("id") Integer id) {
		// TODO: To be implemented
		return null;
    }
	
}
