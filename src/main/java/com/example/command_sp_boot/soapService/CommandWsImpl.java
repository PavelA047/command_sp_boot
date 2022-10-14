package com.example.command_sp_boot.soapService;

import com.example.command_sp_boot.dto.GroupDto;
import com.example.command_sp_boot.dto.RoleDto;
import com.example.command_sp_boot.dto.UserDto;
import com.example.command_sp_boot.services.GroupService;
import com.example.command_sp_boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(
        serviceName = "CommandWs",
        portName = "CommandWsPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.example.command_sp_boot.soapService.CommandWs"
)
public class CommandWsImpl implements CommandWs {
    private UserService userService;
    private GroupService groupService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public void saveUser(UserDto userDto) {
        userService.saveUser(userDto);
    }

    @Override
    public List<UserDto> getListOfUsersByRole(RoleDto roleDto) {
        return userService.getListOfUsersByRole(roleDto);
    }

    @Override
    public List<UserDto> getListOfUsers() {
        return userService.getListOfUsers();
    }

    @Override
    public void deleteUser(UserDto userDto) {
        userService.deleteUser(userDto);
    }

    @Override
    public void saveGroup(GroupDto groupDto) {
        groupService.saveGroup(groupDto);
    }

    @Override
    public void deleteGroup(GroupDto groupDto) {
        groupService.deleteGroup(groupDto);
    }

    @Override
    public List<GroupDto> getGroups() {
        return groupService.getGroups();
    }

    @Override
    public List<UserDto> getListOfUsersByGroup(GroupDto groupDto) {
        return userService.getListOfUsersByGroup(groupDto);
    }

    @Override
    public UserDto getUserByName(String name) {
        return userService.getUserByName(name);
    }
}
