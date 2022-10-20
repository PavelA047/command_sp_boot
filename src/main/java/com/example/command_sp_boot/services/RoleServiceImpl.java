package com.example.command_sp_boot.services;

import com.example.command_sp_boot.entities.Role;
import com.example.command_sp_boot.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String role) {
        return roleRepository.findRoleByName(role);
    }
}
