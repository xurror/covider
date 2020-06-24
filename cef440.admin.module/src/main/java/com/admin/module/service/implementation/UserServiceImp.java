package com.admin.module.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        
        return loadUserDTOS(users);
	}
	
	
	
	@Override
	public List<UserDTO> retrieveNMUsers(String userType) {
		// TODO Auto-generated method stub
		Iterable<Users> users = usersRepository.findByUserType("NORMAL");
		List<UserDTO> nmUserDTOS = new ArrayList<>();
		nmUserDTOS=loadUserDTOS(users);
		return nmUserDTOS;
		  
	}

	@Override
	public List<UserDTO> retrieveAgentUsers(String userType) {
		// TODO Auto-generated method stub
		Iterable<Users> users = usersRepository.findByUserType("AGENT");
		List<UserDTO> agentUserDTOS = new ArrayList<>();
		agentUserDTOS=loadUserDTOS(users);
		return agentUserDTOS;
	}

	@Override
	public List<UserDTO> retrieveAdminUsers(String userType) {
		// TODO Auto-generated method stub
		Iterable<Users> users = usersRepository.findByUserType("ADMIN");
		List<UserDTO> adminUserDTOS = new ArrayList<>();
		adminUserDTOS=loadUserDTOS(users);
		return adminUserDTOS;
	}
	
	@Override
	public NMUserDTO retrieveNMUser(String userType, int userId) {
		// TODO Auto-generated method stub
		List<UserDTO> nmUserDTOS = retrieveNMUsers(userType);
		for(UserDTO userDTO: nmUserDTOS) {
			if(userDTO.getUserId() == userId) {
				return (NMUserDTO) userDTO;
			} 
			
		}
		return null;
		//throw new ResourceNotFoundException("No category set found with identifier"+categorySetString);
	}
	
/*	
	@Override
    public UserDTO retrieveNMUser(int userId) {
        Optional<Users> nmUserOptional = usersRepository.findById(userId);

        if(nmUserOptional.isPresent()) {
            Users user = nmUserOptional.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUserFullName(user.getUserFullName());
            userDTO.setUserName(user.getUserName());
            userDTO.setUserEmail(user.getUserEmail());
            userDTO.setUserDOB(user.getUserDOB());
            userDTO.setUserPassword(user.getUserPassword());
            userDTO.setUserType(user.getUserType());
            userDTO.setUserDateOfBirthString(user.getUserDateOfBirthString());
         

            return  userDTO;
        } else {
            throw new ResourceNotFoundException("Requested category does not exist");
        }
    }
*/
	
	
	@Override
	public AgentUserDTO retrieveAgentUser(String userType, int userId) {
		// TODO Auto-generated method stub
		List<UserDTO> agentUserDTOS = retrieveNMUsers(userType);
		for(UserDTO userDTO: agentUserDTOS) {
			if(userDTO.getUserId() == userId) {
				return (AgentUserDTO) userDTO;
			} 
			
		}
		return null;
		//throw new ResourceNotFoundException("No category set found with identifier"+categorySetString);
	}
	
	@Override
	public AdminUserDTO retrieveAdminUser(String userType, int userId) {
		// TODO Auto-generated method stub
		List<UserDTO> adminUserDTOS = retrieveAdminUsers(userType);
		for(UserDTO userDTO: adminUserDTOS) {
			if(userDTO.getUserId() == userId) {
				return (AdminUserDTO) userDTO;
			} 
			
		}
		return null;
		//throw new ResourceNotFoundException("No category set found with identifier"+categorySetString);
	}
	
	public List<UserDTO> loadUserDTOS(Iterable<Users> users) {
		
		List<UserDTO> userDTOS = new ArrayList<>();
		for(Users user : users){
            
            userDTOS.add(copyUsertoUserDTO(user));
            
        }
		return userDTOS;
	}

	@Override
	public UserDTO createUser(UserDTO newUserDTO) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user = copyUserDTOtoUser(newUserDTO);
		user = usersRepository.save(user);
		
		return copyUsertoUserDTO(user);
	}

	public UserDTO copyUsertoUserDTO(Users user) {
		UserDTO userDTO = new UserDTO();
        
        userDTO.setUserId(user.getUserId());
        userDTO.setUserFullName(user.getUserFullName());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserDOB(user.getUserDOB());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setUserType(user.getUserType());
        userDTO.setUserDateOfBirthString(user.getUserDateOfBirthString());
       
        return userDTO;
    }
	
	public Users copyUserDTOtoUser(UserDTO newUserDTO) {
        
		Users user = new Users();
		user.setUserFullName(newUserDTO.getUserFullName());
		user.setUserName(newUserDTO.getUserName());
		user.setUserEmail(newUserDTO.getUserEmail());
		user.setUserDOB(newUserDTO.getUserDOB());
		user.setUserPassword(newUserDTO.getUserPassword());
		user.setUserType(newUserDTO.getUserType());
		user.setUserDateOfBirthString(newUserDTO.getUserDateOfBirthString());       
        return user;
    }
	

}
