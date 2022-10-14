package com.example.command_sp_boot.services;

import com.example.command_sp_boot.mapper.GroupMapper;
import com.example.command_sp_boot.repositories.GroupRepository;
import com.example.command_sp_boot.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void saveGroup(GroupDto groupDto) {
        groupRepository.save(GroupMapper.MAPPER.toGroup(groupDto));
    }

    @Override
    public void deleteGroup(GroupDto groupDto) {
        groupRepository.delete(GroupMapper.MAPPER.toGroup(groupDto));
    }

    @Override
    public List<GroupDto> getGroups() {
        return GroupMapper.MAPPER.fromGroupList(groupRepository.findAll());
    }
}
