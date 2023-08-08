package com.example.API.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.entities.User;
import com.example.API.payloads.UserDTO;
import com.example.API.services.UserService;
import com.example.API.exceptions.*;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private com.example.API.repositories.UserRepo UserRepo;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		User user=this.dtoToUser(userdto);
		User saveduser=this.UserRepo.save(user);
		return this.userToDto(saveduser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		User user=this.UserRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getPassword());
		user.setPassword(userDto.getPassword());
		User updatedUser=this.UserRepo.save(user);
		UserDTO userdto1=this.userToDto(updatedUser);
		return userdto1;
	}

	@Override
	public UserDTO getUserById(Integer UserId) {
		User user=this.UserRepo.findById(UserId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",UserId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users=this.UserRepo.findAll();
		List<UserDTO> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer UserId) {
		User user=this.UserRepo.findById(UserId)
				.orElseThrow(()->new ResourceNotFoundException("User","id",UserId));
	this.UserRepo.delete(user);	
	}
	private User dtoToUser(UserDTO userdto)
	{
		User user=new User();
		user.setAbout(userdto.getAbout());
		user.setEmail(userdto.getEmail());
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setId(userdto.getId());
		return user;
		
	}
	public UserDTO userToDto(User user)
	{
		UserDTO userdto=new UserDTO();
		userdto.setAbout(user.getAbout());
		userdto.setEmail(user.getEmail());
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setPassword(user.getPassword());
		return userdto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
