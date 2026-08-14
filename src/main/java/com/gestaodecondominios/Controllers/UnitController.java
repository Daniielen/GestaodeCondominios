package com.gestaodecondominios.Controllers;

import com.gestaodecondominios.Entities.Unit;
import com.gestaodecondominios.Repositories.UnitRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitController {

    private final UnitRepository repository;

    public UnitController(UnitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unit> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unit create(@RequestBody Unit unit) {
        return repository.save(unit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unit> update(
            @PathVariable Long id,
            @RequestBody Unit unit) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setBlock(unit.getBlock());
                    existing.setNumber(unit.getNumber());

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