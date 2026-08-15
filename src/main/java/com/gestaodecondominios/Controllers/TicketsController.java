package com.gestaodecondominios.Controllers;

import com.gestaodecondominios.Entities.TicketsEntity;
import com.gestaodecondominios.Repositories.TicketsRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tickets")
public class TicketsController {
	
	private final TicketsRepository repository;
	
	public TicketsController(TicketsRepository repository) {
		this.repository = repository;
	}
	
	
    @GetMapping
    public List<TicketsEntity> findAll() {
        return repository.findAll();
    }
    

    

    @GetMapping("/{id}")
    public ResponseEntity<TicketsEntity> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TicketsEntity create(@RequestBody TicketsEntity ticket) {
        return repository.save(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketsEntity> update(
            @PathVariable Long id,
            @RequestBody TicketsEntity ticket) {

        return repository.findById(id)
                .map(existing -> {
                	existing.setTitle(ticket.getTitle());
                	existing.setAuthor(ticket.getAuthor());
                	existing.setCreatedAt(ticket.getCreatedAt());
                	existing.setDescription(ticket.getDescription());
                	existing.setStatus(ticket.getStatus());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();	
    }
    
}