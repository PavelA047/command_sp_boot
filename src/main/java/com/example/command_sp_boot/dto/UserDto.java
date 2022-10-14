package com.example.command_sp_boot.dto;

import lombok.*;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private GroupDto group;
    private RoleDto role;
    private String chatId;
}
