package com.admin.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.module.dto.UserDTO;
import com.admin.module.model.user.UserType;
import com.admin.module.service.UserService;




@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/trial")
	public String getUsers() {
		return "Brice";
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(userService.retrieveUsers());
	}
	

	@PostMapping("/user/location/{locationId}")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO newUserDTO, @PathVariable("locationId") int locationId) {
		UserDTO userDTO = userService.createUser(newUserDTO, locationId);

		return new ResponseEntity<> (userDTO,HttpStatus.CREATED);
		
	}

	
	@GetMapping("/users/nmuser")
	public ResponseEntity<List<UserDTO>> getAllNMUsers(){ 
		return ResponseEntity.ok().body(userService.retrieveNMUsers());
	}
	
	@GetMapping("/users/agentuser")
	public ResponseEntity<List<UserDTO>> getAllAgentUsers(){
		return ResponseEntity.ok(userService.retrieveAgentUsers());
	}
	
	@GetMapping("/users/adminuser")
	public ResponseEntity<List<UserDTO>> getAllAdminUsers(){
		return ResponseEntity.ok(userService.retrieveAdminUsers());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
		return ResponseEntity.ok().body(userService.retrieveUser(userId));
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/users/{userId}/location/{locationId})")
	public ResponseEntity<Object> editUser(@PathVariable("userId") int userId, @PathVariable("locationId") int locationId, @RequestBody UserDTO newUserDTO) {
		userService.editUser(userId, locationId, newUserDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
}
