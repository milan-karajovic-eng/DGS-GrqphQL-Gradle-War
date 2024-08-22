package com.example.presscentric.test_milan_karajovic_presscetnric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.presscentric.test_milan_karajovic_presscetnric.common.AppConstants;
import com.example.presscentric.test_milan_karajovic_presscetnric.domain.User;
import com.example.presscentric.test_milan_karajovic_presscetnric.repository.UserRepository;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new DgsEntityNotFoundException(AppConstants.USER_NOT_FOUND_BY_ID +id);
		} else {
			return userRepository.findById(id).get();
		}
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
    public User updateUser(Integer id, String name, String email ) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new DgsEntityNotFoundException(AppConstants.USER_CAN_NOT_BE_UPDATED_BY_ID + id);
		} else {
		 User userForUpdate = user.get();
		 if(name != null) userForUpdate.setName(name);
		 if(email != null) userForUpdate.setEmail(email);
		 return userRepository.save(userForUpdate);
		}
    }
	
	@Transactional
	public User deleteUserById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new DgsEntityNotFoundException(AppConstants.USER_CAN_NOT_BE_DELETED_BY_ID +id);
		} else {
			userRepository.delete(user.get());
			return user.get();
		}
	}
	
	
}
