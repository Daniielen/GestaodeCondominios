package com.gestaodecondominios.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaodecondominios.Entities.MaintenanceEntity;

public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {
	
}
