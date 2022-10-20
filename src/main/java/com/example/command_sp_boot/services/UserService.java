package com.example.command_sp_boot.services;

import com.example.command_sp_boot.dto.UserModel;
import com.example.command_sp_boot.entities.Group;

import java.util.List;

public interface UserService {
    void saveUser(UserModel userModel);

    List<UserModel> getListOfUsersModelsByRoleName(String roleName);

    List<UserModel> getListOfUsersModelsByGroupName(String groupName);

    List<UserModel> getListOfUsers();

    void deleteUser(String userName);

    UserModel getUserModelByUserName(String name);

    boolean isAnyUsersInSuchGroup(Group group);
}
