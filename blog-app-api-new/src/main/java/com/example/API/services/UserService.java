package com.example.API.services;

import java.util.List;

import com.example.API.payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, Integer userId);
	UserDTO getUserById(Integer UserId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer UserId);
	
	
	



}
