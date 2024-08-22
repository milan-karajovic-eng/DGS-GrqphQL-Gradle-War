package com.example.presscentric.test_milan_karajovic_presscetnric.fetcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.presscentric.test_milan_karajovic_presscetnric.common.AppConstants;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.example.presscentric.test_milan_karajovic_presscetnric.service.UserService;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.exceptions.QueryException;

@SpringBootTest
public class UserFetcherTest {

	@Autowired
    DgsQueryExecutor executor;
	
	@Test
	void test_findAllUsers_success() {
		
		// given
		String query = "{ users { email name } }";
		
		// when
		User[] users = executor
                .executeAndExtractJsonPathAsObject(query, "data.users[*]", User[].class);
		
		// then
		assertTrue(users.length > 0);
		assertEquals("Milan Karajovic", users[0].getName());
		assertEquals("milan.karajovic@gmail.com", users[0].getEmail());
		
	}
	

	@Test
	void test_findUserById_success() {
		
		// given
		String query = "{ user(id: \"0\") { id email name } }";
		
		// when
		User user = executor
                .executeAndExtractJsonPathAsObject(query, "data.user", User.class);
		
		// then
		assertEquals(0, user.getId());
		assertEquals("Milan Karajovic", user.getName());
		assertEquals("milan.karajovic@gmail.com", user.getEmail());
		
	}
	
	@Test
	void test_findUserById_BadId() {
		
		// given
		String query = "{ user(id: \"100\") { id email name } }";
		
		// when
		QueryException exception = assertThrows(QueryException.class, () -> {
			executor
            .executeAndExtractJsonPathAsObject(query, "data.user", User.class);
        });
		
		// then
		assertEquals(AppConstants.USER_NOT_FOUND_BY_ID + "100", exception.getMessage());
		
	}
	
}
