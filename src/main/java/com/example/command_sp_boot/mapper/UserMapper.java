package com.example.command_sp_boot.mapper;

import com.example.command_sp_boot.dto.UserDto;
import com.example.command_sp_boot.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    @InheritInverseConfiguration
    UserDto fromUser(User user);

    List<User> toUserList(List<UserDto> userDtos);

    List<UserDto> fromUserList(List<User> users);
}
