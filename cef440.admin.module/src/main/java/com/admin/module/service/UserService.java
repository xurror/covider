package com.admin.module.service;

import java.util.List;

import com.admin.module.dto.AdminUserDTO;
import com.admin.module.dto.AgentUserDTO;
import com.admin.module.dto.NMUserDTO;
import com.admin.module.dto.UserDTO;
import com.admin.module.model.user.Users;

public interface UserService {

	List<UserDTO> retrieveUsers();
	List<UserDTO> retrieveNMUsers(String userType);
	List<UserDTO> retrieveAgentUsers(String userType);
	List<UserDTO> retrieveAdminUsers(String userType);
	/*
	 * List<NMUserDTO> retrieveNMUsers(String userType); List<AgentUserDTO>
	 * retrieveAgentUsers(String userType); List<AdminUserDTO>
	 * retrieveAdminUsers(String userType);
	 */
	NMUserDTO retrieveNMUser(String userType, int userId);
	AgentUserDTO retrieveAgentUser(String userType, int userId);
	AdminUserDTO retrieveAdminUser(String userType, int userId);
	UserDTO createUser(UserDTO newUserDTO);
	

}
