package com.gestaodecondominios.Repositories;

import com.gestaodecondominios.Entities.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<TicketsEntity, Long>{
}
