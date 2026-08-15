package com.gestaodecondominios.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaodecondominios.Entities.NoticesEntity;

public interface NoticesRepository extends JpaRepository<NoticesEntity, Long> {

}
