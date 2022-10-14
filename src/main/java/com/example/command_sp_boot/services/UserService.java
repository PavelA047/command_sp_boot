package com.example.command_sp_boot.services;

import com.example.command_sp_boot.dto.GroupDto;
import com.example.command_sp_boot.dto.RoleDto;
import com.example.command_sp_boot.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    List<UserDto> getListOfUsersByRole(RoleDto roleDto);

    List<UserDto> getListOfUsersByGroup(GroupDto groupDto);

    List<UserDto> getListOfUsers();

    void deleteUser(UserDto userDto);

    UserDto getUserByName(String name);
}
