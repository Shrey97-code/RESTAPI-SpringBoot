package com.example.API.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.payloads.UserDTO;
import com.example.API.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Post-Create User
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userdto)
	{
		UserDTO createUserDto=this.userService.createUser(userdto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	//PUT-Update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userdto, @PathVariable Integer userId)
	{
		UserDTO updatedUser= this.userService.updateUser(userdto, userId);
		return ResponseEntity.ok(updatedUser);
	}

	//DELETE-Delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId")Integer uid)
	{
		this.deleteUser(uid);
		return new ResponseEntity(Map.of("message","User deleted successfully"),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
	return ResponseEntity.ok(this.userService.getAllUsers());	
	}	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable("userId")Integer uid)
	{
	return ResponseEntity.ok(this.userService.getUserById(uid));	
	}	
}
