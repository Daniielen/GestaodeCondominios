package com.gestaodecondominios.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaodecondominios.Entities.ReservationsEntity;
import com.gestaodecondominios.Repositories.ReservationsRepository;

@RestController
@RequestMapping("/reservation")
public class ReservationsController {
	
	private final ReservationsRepository repository;
	
	public ReservationsController(ReservationsRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<ReservationsEntity> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReservationsEntity> findById(@PathVariable Long id) {
		return repository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReservationsEntity> update(
			@PathVariable Long id,
			@RequestBody ReservationsEntity reservationsEntity){
		
		return repository.findById(id)
				.map(existing -> {
					existing.setUser(reservationsEntity.getUser());
					existing.setStart_date(reservationsEntity.getStart_date());
					existing.setEnd_time(reservationsEntity.getEnd_time());
					existing.setCommon_area(reservationsEntity.getCommon_area());
					existing.setStatus(reservationsEntity.getStatus());
					
					return ResponseEntity.ok(repository.save(existing));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		if(repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		repository.deleteById(id);
		
		return ResponseEntity.notFound().build();
	}
}
