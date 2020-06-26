package com.admin.module.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.admin.module.dto.UserDTO;
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
	public List<UserDTO> retrieveNMUsers() { //String userType
		// TODO Auto-generated method stub
		List<UserDTO> userDTOS = retrieveUsers();
		List<UserDTO> nmUserDTOS = new ArrayList<>();
		for(UserDTO userDTO: userDTOS) {
			if(userDTO.getUserType() == UserType.NORMAL) {
				nmUserDTOS.add(userDTO);
			}
		}
		return nmUserDTOS;
		  
	}

	@Override
	public List<UserDTO> retrieveAgentUsers() {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOS = retrieveUsers();
		List<UserDTO> agentUserDTOS = new ArrayList<>();
		for(UserDTO userDTO: userDTOS) {
			if(userDTO.getUserType() == UserType.AGENT) {
				agentUserDTOS.add(userDTO);
			}
		}
		return agentUserDTOS;
	}

	@Override
	public List<UserDTO> retrieveAdminUsers() {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOS = retrieveUsers();
		List<UserDTO> adminUserDTOS = new ArrayList<>();
		for(UserDTO userDTO: userDTOS) {
			if(userDTO.getUserType() == UserType.ADMIN) {
				adminUserDTOS.add(userDTO);
			}
		}
		return adminUserDTOS;
	}
	
	@Override
	public UserDTO retrieveUser(int userId) {
		// TODO Auto-generated method stub
		Optional<Users> userOptional = usersRepository.findById(userId);
		if(userOptional.isPresent()) {
            Users user = userOptional.get();
            UserDTO userDTO = copyUsertoUserDTO(user);
            return  userDTO;
        } else {
            throw new ResourceNotFoundException("User with User_Id = "+ userId + " does not exist");
        }
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
        //userDTO.setUserDateOfBirthString(user.getUserDateOfBirthString());
       
        return userDTO;
    }
	
	public Users copyUserDTOtoUser(UserDTO newUserDTO) {
		UserType userType = newUserDTO.getUserType();
		UserType type;
		switch(userType) {
		case ADMIN:
			type = userType;
			break;
		case AGENT:
			type = userType;
			break;
		default:
			type = UserType.NORMAL;
		}
		
			
        
		Users user = new Users();
		user.setUserFullName(newUserDTO.getUserFullName());
		user.setUserName(newUserDTO.getUserName());
		user.setUserEmail(newUserDTO.getUserEmail());
		user.setUserDOB(newUserDTO.getUserDOB());
		user.setUserPassword(newUserDTO.getUserPassword());
		user.setUserType(type);
		//user.setUserDateOfBirthString(newUserDTO.getUserDateOfBirthString());       
        return user;
    }
	

}
