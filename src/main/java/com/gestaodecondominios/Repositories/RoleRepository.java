package com.gestaodecondominios.Repositories;

import com.gestaodecondominios.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}