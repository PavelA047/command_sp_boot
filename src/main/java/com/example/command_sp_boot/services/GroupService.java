package com.example.command_sp_boot.services;

import com.example.command_sp_boot.dto.GroupDto;

import java.util.List;

public interface GroupService {

    void saveGroup(GroupDto groupDto);

    void deleteGroup(GroupDto groupDto);

    List<GroupDto> getGroups();
}
