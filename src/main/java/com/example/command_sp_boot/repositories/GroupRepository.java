package com.example.command_sp_boot.repositories;

import com.example.command_sp_boot.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupByName(String name);
}
