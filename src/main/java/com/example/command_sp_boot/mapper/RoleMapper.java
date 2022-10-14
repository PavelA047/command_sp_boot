package com.example.command_sp_boot.mapper;

import com.example.command_sp_boot.dto.RoleDto;
import com.example.command_sp_boot.entities.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    @InheritInverseConfiguration
    RoleDto fromRole(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);

    List<RoleDto> fromRoleList(List<Role> roles);
}
