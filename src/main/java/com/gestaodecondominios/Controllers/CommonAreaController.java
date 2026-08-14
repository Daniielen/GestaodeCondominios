package com.gestaodecondominios.Controllers;

import com.gestaodecondominios.Entities.CommonArea;
import com.gestaodecondominios.Repositories.CommonAreaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common-areas")
public class CommonAreaController {

    private final CommonAreaRepository repository;

    public CommonAreaController(CommonAreaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CommonArea> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonArea> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CommonArea create(@RequestBody CommonArea commonArea) {
        return repository.save(commonArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonArea> update(
            @PathVariable Long id,
            @RequestBody CommonArea commonArea) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setName(commonArea.getName());
                    existing.setCapacity(commonArea.getCapacity());
                    existing.setActive(commonArea.getActive());

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