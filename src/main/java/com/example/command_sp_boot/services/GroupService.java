package com.example.command_sp_boot.services;

import com.example.command_sp_boot.entities.Group;

import java.util.List;

public interface GroupService {

    void saveGroup(String groupName);

    void deleteGroup(String groupName);

    List<String> getGroupsNames();

    Group findGroupByName(String name);
}
