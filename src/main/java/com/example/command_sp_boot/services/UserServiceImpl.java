package com.example.command_sp_boot.services;

import com.example.command_sp_boot.mapper.GroupMapper;
import com.example.command_sp_boot.mapper.RoleMapper;
import com.example.command_sp_boot.mapper.UserMapper;
import com.example.command_sp_boot.repositories.UserRepository;
import com.example.command_sp_boot.dto.GroupDto;
import com.example.command_sp_boot.dto.RoleDto;
import com.example.command_sp_boot.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(UserMapper.MAPPER.toUser(userDto));
    }

    @Override
    public List<UserDto> getListOfUsersByRole(RoleDto roleDto) {
        return UserMapper.MAPPER.fromUserList(userRepository.findAllByRole(RoleMapper.MAPPER.toRole(roleDto)));
    }

    @Override
    public List<UserDto> getListOfUsersByGroup(GroupDto groupDto) {
        return UserMapper.MAPPER.fromUserList(userRepository.findAllByGroup(GroupMapper.MAPPER.toGroup(groupDto)));
    }

    @Override
    public List<UserDto> getListOfUsers() {
        return UserMapper.MAPPER.fromUserList(userRepository.findAll());
    }


    @Override
    public void deleteUser(UserDto userDto) {
        userRepository.delete(UserMapper.MAPPER.toUser(userDto));
    }

    @Override
    public UserDto getUserByName(String name) {
        return UserMapper.MAPPER.fromUser(userRepository.findByUserName(name));
    }
}
