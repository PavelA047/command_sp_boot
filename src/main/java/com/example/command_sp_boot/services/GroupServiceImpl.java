package com.example.command_sp_boot.services;

import com.example.command_sp_boot.entities.Group;
import com.example.command_sp_boot.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserService userService;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, @Lazy UserService userService) {
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    @Override
    public void saveGroup(String groupName) {
        groupRepository.save(new Group(groupName));
    }

    @Override
    public void deleteGroup(String groupName) {
        Group group = groupRepository.findGroupByName(groupName);
        if (group != null && !userService.isAnyUsersInSuchGroup(group))
            groupRepository.delete(group);
    }

    @Override
    public List<String> getGroupsNames() {
        List<Group> all = groupRepository.findAll();
        List<String> groupsList = new ArrayList<>();
        for (Group group : all) {
            groupsList.add(group.getName());
        }
        return Optional.of(groupsList).orElse(new ArrayList<>());
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findGroupByName(name);
    }
}
