package com.markos96.security.service;

import com.markos96.security.model.domain.Roles;
import com.markos96.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    private RolRepository rolRepository;

    public Roles getRolByName(String rolName) {
        return this.rolRepository.findByName(rolName).orElse(null);
    }

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
}
