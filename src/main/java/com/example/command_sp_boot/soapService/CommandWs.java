package com.example.command_sp_boot.soapService;

import com.example.command_sp_boot.dto.UserModel;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(targetNamespace = "http://service.ws.sample/", name = "CommandWs")
public interface CommandWs {

    @WebResult(name = "saveUser", targetNamespace = "")
    @RequestWrapper(
            localName = "saveUser",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestSaveUser"
    )
    @WebMethod(action = "urn:SaveUser")
    @ResponseWrapper(
            localName = "saveUserResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.SaveUserResponse")
    void saveUser(@WebParam(name = "user", targetNamespace = "") UserModel userModel);

    @WebResult(name = "getListOfUsersByRole", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsersByRole",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestGetListOfUsersByRole"
    )
    @WebMethod(action = "urn:GetListOfUsersByRole")
    @ResponseWrapper(
            localName = "getListOfUsersByRoleResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.GetListOfUsersByRoleResponse"
    )
    List<UserModel> getListOfUsersModelsByRoleName(@WebParam(name = "roleName", targetNamespace = "") String roleName);

    @WebResult(name = "getListOfUsers", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsers",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestGetListOfUsers"
    )
    @WebMethod(action = "urn:GetListOfUsers")
    @ResponseWrapper(
            localName = "getListOfUsersResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.GetListOfUsersResponse"
    )
    List<UserModel> getListOfUsers();

    @WebResult(name = "deleteUser", targetNamespace = "")
    @RequestWrapper(
            localName = "deleteUser",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestDeleteUser"
    )
    @WebMethod(action = "urn:DeleteUser")
    @ResponseWrapper(
            localName = "deleteUserResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.DeleteUserResponse")
    void deleteUser(@WebParam(name = "userName", targetNamespace = "") String userName);

    @WebResult(name = "saveGroup", targetNamespace = "")
    @RequestWrapper(
            localName = "saveGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestSaveGroup"
    )
    @WebMethod(action = "urn:SaveGroup")
    @ResponseWrapper(
            localName = "saveGroupResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.SaveGroupResponse")
    void saveGroup(@WebParam(name = "groupName", targetNamespace = "") String groupName);

    @WebResult(name = "deleteGroup", targetNamespace = "")
    @RequestWrapper(
            localName = "deleteGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestDeleteGroup"
    )
    @WebMethod(action = "urn:DeleteGroup")
    @ResponseWrapper(
            localName = "deleteGroupResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.DeleteGroupResponse")
    void deleteGroup(@WebParam(name = "groupName", targetNamespace = "") String groupName);

    @WebResult(name = "getGroupsNames", targetNamespace = "")
    @RequestWrapper(
            localName = "getGroupsNames",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestGetGroupsNames"
    )
    @WebMethod(action = "urn:GetGroupsNames")
    @ResponseWrapper(
            localName = "getGroupsNamesResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.GetGroupsNamesResponse"
    )
    List<String> getGroupsNames();

    @WebResult(name = "getListOfUsersByGroupName", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsersByGroupName",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestGetListOfUsersByGroupName"
    )
    @WebMethod(action = "urn:GetListOfUsersByGroupName")
    @ResponseWrapper(
            localName = "getListOfUsersByGroupNameResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.GetListOfUsersByGroupNameResponse"
    )
    List<UserModel> getListOfUsersModelsByGroupName(@WebParam(name = "groupName", targetNamespace = "") String groupName);

    @WebResult(name = "getUserModelByUserName", targetNamespace = "")
    @RequestWrapper(
            localName = "getUserModelByUserName",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestGetUserModelByUserName"
    )
    @WebMethod(action = "urn:GetUserModelByUserName")
    @ResponseWrapper(
            localName = "getUserModelByUserNameResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.GetUserModelByUserNameResponse"
    )
    UserModel getUserModelByUserName(@WebParam(name = "userName", targetNamespace = "") String userName);
}
