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
import com.admin.module.dto.AdminUserDTO;
import com.admin.module.dto.AgentUserDTO;
import com.admin.module.dto.UserDTO;
import com.admin.module.dto.NMUserDTO;
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
	
	@PostMapping("/user")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO newUserDTO) {
		UserDTO userDTO = userService.createUser(newUserDTO);
		return new ResponseEntity<> (userDTO,HttpStatus.CREATED);
		
	}
/*	
	 @PostMapping("/private/category/set/{categorySetString}")
	    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CreateCategoryDTO newCategory, @PathVariable String categorySetString) {
	        CategoryDTO categoryDTO = categoryService.saveCategory(newCategory, categorySetString);

	        return new ResponseEntity<> (categoryDTO,HttpStatus.CREATED);
	    }
*/	
	@GetMapping("/users/nmuser/{userType}")
	public ResponseEntity<List<UserDTO>> getAllNMUsers(@PathVariable String userType){
		return ResponseEntity.ok().body(userService.retrieveNMUsers(userType));
	}
	
	@GetMapping("/users/agentuser/{userType}")
	public ResponseEntity<List<UserDTO>> getAllAgentUsers(@PathVariable String userType){
		return ResponseEntity.ok(userService.retrieveAgentUsers(userType));
	}
	
	@GetMapping("/users/adminuser/{userType}")
	public ResponseEntity<List<UserDTO>> getAllAdminUsers(@PathVariable String userType){
		return ResponseEntity.ok(userService.retrieveAdminUsers(userType));
	}
	
	@GetMapping("/users/nmuser/{userType}/userid/{userId}")
	public ResponseEntity<NMUserDTO> getNMUsers(@PathVariable String userType, @PathVariable int userId){
		return ResponseEntity.ok().body(userService.retrieveNMUser(userType, userId));
	}
	
	@GetMapping("/users/agentuser/{userType}/userid/{userId}")
	public ResponseEntity<AgentUserDTO> getAgentUsers(@PathVariable String userType, @PathVariable int userId){
		return ResponseEntity.ok().body(userService.retrieveAgentUser(userType, userId));
	}
	
	@GetMapping("/users/adminuser/{userType}/userid/{userId}")
	public ResponseEntity<AdminUserDTO> getAdminUsers(@PathVariable String userType, @PathVariable int userId){
		return ResponseEntity.ok().body(userService.retrieveAdminUser(userType, userId));
	}
	
	
	

	/*
	  private CategoryService categoryService;

	    @Autowired
	    public CategoryController(CategoryService categoryService) {
	        this.categoryService = categoryService;
	    }

	    @PostMapping("/private/category/set/{categorySetString}")
	    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CreateCategoryDTO newCategory, @PathVariable String categorySetString) {
	        CategoryDTO categoryDTO = categoryService.saveCategory(newCategory, categorySetString);

	        return new ResponseEntity<> (categoryDTO,HttpStatus.CREATED);
	    }

	    @PostMapping("/private/category/set")
	    public ResponseEntity<CategorySetDTO> addCategorySet(@RequestBody CreateCategorySetDTO categorySet) {
	        CategorySetDTO savedCategorySet = categoryService.saveCategorySet(categorySet);

	        return new ResponseEntity<>(savedCategorySet, HttpStatus.CREATED);
	    }

	    @PutMapping("/private/category/{categoryID}")
	    public  ResponseEntity<?> editCategory(@PathVariable("categoryID") int categoryID,
	                                                     @RequestBody CategoryDTO newCategoryData) {

	        categoryService.editCategory(categoryID, newCategoryData);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @PutMapping("/private/categories/sets/{id}")
	    public ResponseEntity<?> editCategorySet(@PathVariable int id, @RequestBody CreateCategorySetDTO categorySet) {
	        categoryService.editCategorySet(id, categorySet);

	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @DeleteMapping("/private/category/{categoryID}")
	    public ResponseEntity<?> deleteCategory(@PathVariable int categoryID) {

	        categoryService.deleteCategory(categoryID);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/public/category")
	    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
	        return ResponseEntity.ok(categoryService.retrieveCategories());
	    }

	    @GetMapping("/public/category/{categoryID}")
	    public ResponseEntity<CategoryDTO> getCategory(@PathVariable int categoryID){
	        return ResponseEntity.ok().body(categoryService.retrieveCategory(categoryID));
	    }

	    @GetMapping("/public/categories/sets")
	    public ResponseEntity<List<EventCategorySet>> getCategorySets() {
	        return new ResponseEntity<>(categoryService.getCategorySets(), HttpStatus.OK);
	    }

	    @GetMapping("/public/categories/{categorySet}")
	    public ResponseEntity<List<CategoryDTO>> getCategoriesWithSet(@PathVariable String categorySet) {

	        return new ResponseEntity<>(categoryService.getCategoriesBySet(categorySet), HttpStatus.OK);
	    }

	    @DeleteMapping("/private/category/set/{id}")
	    public ResponseEntity<?> deleteCategorySet(@PathVariable int id) {
	        categoryService.deleteCategorySet(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    */
}
