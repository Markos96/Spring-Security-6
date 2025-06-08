package com.markos96.security.repository;

import com.markos96.security.model.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByName(String name);
}
