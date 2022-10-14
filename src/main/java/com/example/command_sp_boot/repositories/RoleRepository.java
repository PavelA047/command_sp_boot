package com.example.command_sp_boot.repositories;

import com.example.command_sp_boot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
