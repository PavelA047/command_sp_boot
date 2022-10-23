package com.example.command_sp_boot.services;

import com.example.command_sp_boot.dto.UserModel;
import com.example.command_sp_boot.entities.Group;
import com.example.command_sp_boot.entities.Role;
import com.example.command_sp_boot.entities.User;
import com.example.command_sp_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final GroupService groupService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, GroupService groupService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.groupService = groupService;
    }

    @Override
    @Transactional
    public void saveUser(UserModel userModel) {
        Group group = groupService.findGroupByName(userModel.getGroup());
        Role role = roleService.findRoleByName(userModel.getRole());
        if (role != null && group != null)
            if (userRepository.findByUserName(userModel.getUserName()) != null) {
                userRepository.updateUser(userModel.getChatId(), role, group, userModel.getUserName());
            } else {
                userRepository.save(new User(userModel.getUserName(), group, role, userModel.getChatId()));
            }
    }

    @Override
    public List<UserModel> getListOfUsersModelsByRoleName(String roleName) {
        Role role = roleService.findRoleByName(roleName);
        if (role != null) {
            List<User> all = userRepository.findAllByRole(role);
            return getUsersModelsList(all);
        }
        return null;
    }

    @Override
    public List<UserModel> getListOfUsersModelsByGroupName(String groupName) {
        Group group = groupService.findGroupByName(groupName);
        if (group != null) {
            List<User> all = userRepository.findAllByGroup(group);
            return getUsersModelsList(all);
        }
        return null;
    }

    @Override
    public List<UserModel> getListOfUsers() {
        List<User> all = userRepository.findAll();
        return getUsersModelsList(all);
    }

    private List<UserModel> getUsersModelsList(List<User> all) {
        List<UserModel> userModelList = new ArrayList<>();
        for (User user : all) {
            userModelList.add(new UserModel(user.getUserName(), user.getGroup().getName(), user.getRole().getName(), user.getChatId()));
        }
        return Optional.of(userModelList).orElse(new ArrayList<>());
    }

    @Override
    @Transactional
    public void deleteUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null)
            userRepository.delete(user);
    }

    @Override
    public UserModel getUserModelByUserName(String name) {
        User user = userRepository.findByUserName(name);
        if (user != null) {
            return new UserModel(user.getUserName(), user.getGroup().getName(), user.getRole().getName(), user.getChatId());
        }
        return null;
    }

    @Override
    public boolean isAnyUsersInSuchGroup(Group group) {
        List<User> users = userRepository.findAllByGroup(group);
        return users.size() > 0;
    }
}
