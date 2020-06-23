package com.admin.module.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.module.dto.NMUserDTO;
import com.admin.module.dto.UserDTO;
import com.admin.module.dto.AdminUserDTO;
import com.admin.module.dto.AgentUserDTO;
import com.admin.module.model.user.UserType;
import com.admin.module.model.user.Users;
import com.admin.module.repository.user.UsersRepository;
import com.admin.module.service.UserService;


@Service
public class UserServiceImp implements UserService {
	private UsersRepository usersRepository;
	
	
	@Autowired
	public UserServiceImp(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Override
	public List<UserDTO> retrieveUsers() {
		// TODO Auto-generated method stub
		Iterable<Users> users = usersRepository.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();
        for(Users user : users){
            UserDTO userDTO = new UserDTO();
            
            userDTO.
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTO.setCategorySet(category.getCatSet().getCategorySetString());
            categoryDTO.setCategoryDescription(category.getCategoryDescription());
            categoryDTOS.add(categoryDTO);
        }
        
        private Long userId;
    	private String userFullName;
    	private String userName;
    	private String userEmail;
    	private Date userDOB;
    	private String userPassword;
    	private UserType userType;
    	private transient String userDateOfBirthString;
        return categoryDTOS;
	}

	@Override
	public List<NMUserDTO> retrieveNMUsers(String userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AgentUserDTO> retrieveAgentUsers(String userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminUserDTO> retrieveAdminUsers(String userType) {
		// TODO Auto-generated method stub
		return null;
	}

}
