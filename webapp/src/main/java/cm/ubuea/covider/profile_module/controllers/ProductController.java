package cm.ubuea.covider.profile_module.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cm.ubuea.covider.profile_module.models.Product;
import cm.ubuea.covider.profile_module.repositories.productRepository;



@RestController
public class ProductController {
	
	@Autowired
	private productRepository productRepo;
	
	@GetMapping("/api/products")
	public List<Product> getAllProducts(Sort product){
		return productRepo.findAll(product);
	}
	
	@GetMapping("/api/products/{ProdId}")
	public Optional<Product> retrieveOne(@PathVariable long ProdId){
		return productRepo.findById(ProdId);
	}
	
	@PostMapping("/api/products/category/{CatId}")
	public Product createProduct(@PathVariable long CatId, @Valid @RequestBody Product product) {		
		
		product.setCategory(new Category(CatId));
		return productRepo.save(product);
	}
	
	@PutMapping("/api/products/{ProdId}/category/{CatId}")
	public Optional<Product> updateProduct(@PathVariable("ProdId") Long ProdId, @PathVariable("CatId") Long CatId ,@Valid @RequestBody Product productUpdate) {
		return productRepo.findById(ProdId).map(product ->{
			product.setName(productUpdate.getName());
			product.setDetails(productUpdate.getDetails());
			product.setPrice(productUpdate.getPrice());
			product.setQuantity(productUpdate.getQuantity());
			
			product.setCategory(new Category(CatId));
			return productRepo.save(product);
		})/*.orElseThrow(() -> new ResourceNotFoundException("CatId" + CatId + " not found"))*/;
	}
	
	
	@DeleteMapping("/api/products/{ProdId}")
	public Optional<Object> deleteproduct(@PathVariable Long ProdId){
		return productRepo.findById(ProdId).map(product -> {
			productRepo.delete(product);
			return ResponseEntity.ok().build();
		})/*.orElseThrow(() -> ResourceNotFoundException("CatId " + CatId + " not found"))*/;
	}

}