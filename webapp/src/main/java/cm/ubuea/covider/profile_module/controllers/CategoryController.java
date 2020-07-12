package cm.ubuea.covider.profile_module.controllers;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cm.ubuea.covider.profile_module.models.Category;
import cm.ubuea.covider.profile_module.repositories.categoryRepository;



@RestController
public class CategoryController {
	
	@Autowired
	private categoryRepository categoryRepo;
	
	@GetMapping("/api/category")
	public List<Category> getAllCategories(Sort categories){
		return categoryRepo.findAll(categories);
	}
	
	@GetMapping("/api/category/{CatId}")
	public Optional<Category> retrieveOne(@PathVariable long CatId){
		return categoryRepo.findById(CatId);
	}
	
	@PostMapping("/api/category")
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryRepo.save(category);
	}
	
	@PutMapping("/api/category/{CatId}")
	public Optional<Category> updateCategory(@PathVariable Long CatId, @Valid @RequestBody Category categoryUpdate) {
		return categoryRepo.findById(CatId).map(category ->{
			category.setName(categoryUpdate.getName());
			return categoryRepo.save(category);
		})/*.orElseThrow(() -> new ResourceNotFoundException("CatId" + CatId + " not found"))*/;
	}
	
	
	@DeleteMapping("/api/category/{CatId}")
	public Optional<Object> deletecategory(@PathVariable Long CatId){
		return categoryRepo.findById(CatId).map(category -> {
			categoryRepo.delete(category);
			return ResponseEntity.ok().build();
		})/*.orElseThrow(() -> ResourceNotFoundException("CatId " + CatId + " not found"))*/;
	}

}
