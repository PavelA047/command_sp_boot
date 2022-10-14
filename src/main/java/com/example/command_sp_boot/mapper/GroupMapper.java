package com.example.command_sp_boot.mapper;

import com.example.command_sp_boot.dto.GroupDto;
import com.example.command_sp_boot.entities.Group;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupMapper {
    GroupMapper MAPPER = Mappers.getMapper(GroupMapper.class);

    Group toGroup(GroupDto groupDto);

    @InheritInverseConfiguration
    GroupDto fromGroup(Group group);

    List<Group> toGroupList(List<GroupDto> groupDtos);

    List<GroupDto> fromGroupList(List<Group> groups);
}
