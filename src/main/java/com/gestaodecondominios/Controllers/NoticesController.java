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

import com.gestaodecondominios.Repositories.NoticesRepository;
import com.gestaodecondominios.Entities.NoticesEntity;

@RestController
@RequestMapping("/notices")
public class NoticesController {
	
	private final NoticesRepository repository;
	
	public NoticesController(NoticesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<NoticesEntity> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoticesEntity> findById(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public NoticesEntity create(@RequestBody NoticesEntity noticesEntity) {
		return repository.save(noticesEntity);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NoticesEntity> update(
			@PathVariable Long id,
			@RequestBody NoticesEntity noticesEntity) {
		
		return repository.findById(id)
				.map(existing -> {
					existing.setTitle(noticesEntity.getTitle());
					existing.setContent(noticesEntity.getContent());
					existing.setCreated_at(noticesEntity.getCreated_at());
					existing.setAuthor_id(noticesEntity.getAuthor_id());
				
					return ResponseEntity.ok(repository.save(existing));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping
	public ResponseEntity<NoticesEntity> delete(@PathVariable Long id) {
		
		if(!repository.existsById(id))  {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
