package com.gestaodecondominios.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaodecondominios.Entities.ReservationsEntity;

public interface ReservationsRepository extends JpaRepository<ReservationsEntity, Long>{

}
