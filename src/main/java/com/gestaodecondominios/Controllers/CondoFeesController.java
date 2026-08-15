package com.gestaodecondominios.Controllers;

import com.gestaodecondominios.Entities.CondoFeesEntity;
import com.gestaodecondominios.Entities.User;
import com.gestaodecondominios.Repositories.CondoFeesRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condoFees")
public class CondoFeesController {
	
	private final CondoFeesRepository repository;
	
	public CondoFeesController(CondoFeesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<CondoFeesEntity> findAll(){
		return repository.findAll();
	}
	
	@GetMapping
	public ResponseEntity<CondoFeesEntity> findById(@PathVariable Long id){
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public CondoFeesEntity create(@RequestBody CondoFeesEntity condoFees) {
		return repository.save(condoFees);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<CondoFeesEntity> update(@PathVariable Long id,
            @RequestBody CondoFeesEntity condoFees){
		return repository.findById(id)
				.map(existing ->{
					existing.setAmount(condoFees.getAmount());
					existing.setDueDate(condoFees.getDueDate());
					existing.setPaymentDate(condoFees.getPaymentDate());
					existing.setStatus(condoFees.getStatus());
					existing.setUnit(condoFees.getUnit());
					
					return ResponseEntity.ok(repository.save(existing));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
