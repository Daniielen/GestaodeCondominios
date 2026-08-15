package com.gestaodecondominios.Controllers;

import com.gestaodecondominios.Entities.DeliveriesEntity;
import com.gestaodecondominios.Repositories.DeliveriesRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveriesController {
	private final DeliveriesRepository repository;
	
	public DeliveriesController(DeliveriesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<DeliveriesEntity> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DeliveriesEntity> findById(@PathVariable Long id){
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public DeliveriesEntity create(@RequestBody DeliveriesEntity deliveries) {
		return repository.save(deliveries);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<DeliveriesEntity> update(@PathVariable Long id,
            @RequestBody DeliveriesEntity deliveries){
		return repository.findById(id)
				.map(existing ->{
					existing.setDescription(deliveries.getDescription());
					existing.setDeliveredAt(deliveries.getReceivedAt());
					existing.setDeliveredBy(deliveries.getDeliveredBy());
					existing.setReceivedAt(deliveries.getReceivedAt());
					existing.setReceivedBy(deliveries.getReceivedBy());
					existing.setRecipientName(deliveries.getRecipientName());
					existing.setStatus(deliveries.getStatus());
					existing.setTrackingCode(deliveries.getTrackingCode());
					existing.setUnit(deliveries.getUnit());
					
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