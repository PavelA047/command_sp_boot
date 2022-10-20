package com.example.command_sp_boot.soapService;

import com.example.command_sp_boot.dto.UserModel;
import com.example.command_sp_boot.services.GroupService;
import com.example.command_sp_boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

@Service
@WebService(
        serviceName = "Command",
        portName = "CommandPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.example.command_sp_boot.soapService.CommandWs"
)
public class CommandWsImpl implements CommandWs {

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    @Override
    public void saveUser(UserModel userModel) {
        userService.saveUser(userModel);
    }

    @Override
    public List<UserModel> getListOfUsersModelsByRoleName(String roleName) {
        return userService.getListOfUsersModelsByRoleName(roleName);
    }

    @Override
    public List<UserModel> getListOfUsers() {
        return userService.getListOfUsers();
    }

    @Override
    public void deleteUser(String userName) {
        userService.deleteUser(userName);
    }

    @Override
    public void saveGroup(String groupName) {
        groupService.saveGroup(groupName);
    }

    @Override
    public void deleteGroup(String groupName) {
        groupService.deleteGroup(groupName);
    }

    @Override
    public List<String> getGroupsNames() {
        return groupService.getGroupsNames();
    }

    @Override
    public List<UserModel> getListOfUsersModelsByGroupName(String groupName) {
        return userService.getListOfUsersModelsByGroupName(groupName);
    }

    @Override
    public UserModel getUserModelByUserName(String userName) {
        return userService.getUserModelByUserName(userName);
    }
}
