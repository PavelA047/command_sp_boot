package com.example.command_sp_boot.services;

import com.example.command_sp_boot.entities.Role;

public interface RoleService {
    Role findRoleByName(String name);
}
