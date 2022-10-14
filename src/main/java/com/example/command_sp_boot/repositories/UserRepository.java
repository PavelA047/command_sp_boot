package com.example.command_sp_boot.repositories;

import com.example.command_sp_boot.entities.Group;
import com.example.command_sp_boot.entities.Role;
import com.example.command_sp_boot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);

    List<User> findAllByGroup(Group group);

    User findByUserName(String name);
}
