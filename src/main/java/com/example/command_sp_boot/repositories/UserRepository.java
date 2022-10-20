package com.example.command_sp_boot.repositories;

import com.example.command_sp_boot.entities.Group;
import com.example.command_sp_boot.entities.Role;
import com.example.command_sp_boot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRole(Role role);

    List<User> findAllByGroup(Group group);

    User findByUserName(String name);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.chatId = :chatId, u.role = :role, u.group = :group WHERE u.userName = :userName")
    void updateUser(
            @Param("chatId") String chatId,
            @Param("role") Role role,
            @Param("group") Group group,
            @Param("userName") String userName);
}
