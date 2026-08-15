package com.gestaodecondominios.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaodecondominios.Entities.MaintenanceEntity;
import com.gestaodecondominios.Repositories.MaintenanceRepository;


@RestController
@RequestMapping("/maintenance")
public class MaintenanceControllers {
	
	private final MaintenanceRepository repository;
	
	public MaintenanceControllers(MaintenanceRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<MaintenanceEntity> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MaintenanceEntity> findById(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public MaintenanceEntity create(@RequestBody MaintenanceEntity maintenanceEntity) {
		return repository.save(maintenanceEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MaintenanceEntity> update(
			@PathVariable Long id,
			@RequestBody MaintenanceEntity maintenanceEntity){
			
		return repository.findById(id)
				.map(existing -> {
					existing.setTitle(maintenanceEntity.getTitle());
					existing.setDescription(maintenanceEntity.getDescription());
					existing.setStatus(maintenanceEntity.getStatus());
					existing.setCompleted_date(maintenanceEntity.getCompleted_date());
					
					return ResponseEntity.ok(repository.save(existing));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
