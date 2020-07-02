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
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO newUserDTO, @PathVariable int locationId) {
		UserDTO userDTO = userService.createUser(newUserDTO, locationId);

		return new ResponseEntity<> (userDTO,HttpStatus.CREATED);
		
	}
/*	
	 @PostMapping("/private/category/set/{categorySetString}")
	    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CreateCategoryDTO newCategory, @PathVariable String categorySetString) {
	        CategoryDTO categoryDTO = categoryService.saveCategory(newCategory, categorySetString);

	        return new ResponseEntity<> (categoryDTO,HttpStatus.CREATED);
	    }
*/	
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
