package com.admin.module.service;

import java.util.List;


import com.admin.module.dto.UserDTO;
import com.admin.module.model.user.UserType;
import com.admin.module.model.user.Users;

public interface UserService {

	List<UserDTO> retrieveUsers();
	List<UserDTO> retrieveNMUsers(); 
	List<UserDTO> retrieveAgentUsers();
	List<UserDTO> retrieveAdminUsers();
	/*
	 * List<NMUserDTO> retrieveNMUsers(String userType); List<AgentUserDTO>
	 * retrieveAgentUsers(String userType); List<AdminUserDTO>
	 * retrieveAdminUsers(String userType);
	 */
	UserDTO retrieveUser(int userId);
<<<<<<< HEAD
	UserDTO createUser(UserDTO newUserDTO, int userLocation);
=======
	UserDTO createUser(UserDTO newUserDTO);
>>>>>>> 8b7ff0406c9ee65cea817dec36710cbf66071268
	

}
