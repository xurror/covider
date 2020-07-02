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

import com.admin.module.model.Location;
import com.admin.module.model.user.UserType;
import com.admin.module.model.user.Users;
import com.admin.module.repository.LocationRepository;
import com.admin.module.repository.UsersRepository;

import com.admin.module.service.UserService;

import cef440.admin.module.converter.StringToEnumConverter;



@Service
public class UserServiceImp implements UserService {
	private UsersRepository usersRepository;

	private LocationRepository locationRepository;

	

	@Autowired
	public UserServiceImp(UsersRepository usersRepository, LocationRepository locationRepository) {
		super();
		this.usersRepository = usersRepository;
		this.locationRepository = locationRepository;
		
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
			if(userDTO.getUserType() == UserType.NORMAL.toString()) {
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
			if(userDTO.getUserType() == UserType.AGENT.toString()) {
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
			if(userDTO.getUserType() == UserType.ADMIN.toString()) {
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
	

	
		
	public List<UserDTO> loadUserDTOS(Iterable<Users> users) {
		
		List<UserDTO> userDTOS = new ArrayList<>();
		for(Users user : users){
            
            userDTOS.add(copyUsertoUserDTO(user));
            
        }
		return userDTOS;
	}

	@Override

	public UserDTO createUser(UserDTO newUserDTO, int userLocation) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user = copyUserDTOtoUser(newUserDTO, userLocation);

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
        userDTO.setUserType(user.getUserType().toString());

        userDTO.setUserLocation(user.getUserLocation());

        userDTO.setUserDateOfBirthString(user.getUserDateOfBirthString());
        
        return userDTO;
    }
	

	public Users copyUserDTOtoUser(UserDTO newUserDTO, int locationId) {

		
		String userType = newUserDTO.getUserType();
		String type;
		
		switch(userType.toLowerCase()) {
		case "admin":
			type = userType.toLowerCase();
			break;
		case "agent":
			type = userType.toLowerCase();
			break;
		default:
			type = "normal";
		}

		
		Users user = new Users();
		
		if(!type.equalsIgnoreCase("normal")) {
			user.putUserLocation(new Location(99999999, "Government", "Government", "Government"));
		} else {
			Optional<Location> userLocation = locationRepository.findById(locationId);
			user.putUserLocation(userLocation.get());
		}
		
        
		

		user.setUserFullName(newUserDTO.getUserFullName());
		user.setUserName(newUserDTO.getUserName());
		user.setUserEmail(newUserDTO.getUserEmail());
		user.setUserDOB(newUserDTO.getUserDOB());
		user.setUserPassword(newUserDTO.getUserPassword());
		user.setUserType(new StringToEnumConverter().convert(type));
		user.setUserDateOfBirthString(newUserDTO.getUserDateOfBirthString());       
        return user;
    }
	

}
