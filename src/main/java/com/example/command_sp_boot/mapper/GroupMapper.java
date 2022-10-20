package com.example.command_sp_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper MAPPER = Mappers.getMapper(GroupMapper.class);

}
