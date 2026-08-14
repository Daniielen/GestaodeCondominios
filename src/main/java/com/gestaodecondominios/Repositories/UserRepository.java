package com.gestaodecondominios.Repositories;

import com.gestaodecondominios.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}