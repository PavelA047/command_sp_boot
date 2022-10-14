package com.example.command_sp_boot.soapService;

import com.example.command_sp_boot.dto.GroupDto;
import com.example.command_sp_boot.dto.RoleDto;
import com.example.command_sp_boot.dto.UserDto;

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
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:saveUser")
    void saveUser(@WebParam(name = "user", targetNamespace = "") UserDto userDto);

    @WebResult(name = "getListOfUsersByRole", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsersByRole",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:getListOfUsersByRole")
    @ResponseWrapper(
            localName = "listOfUsersByRole",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.listOfUsersByRole"
    )
    List<UserDto> getListOfUsersByRole(@WebParam(name = "roleDto", targetNamespace = "") RoleDto roleDto);

    @WebResult(name = "getListOfUsers", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsers",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:getListOfUsers")
    @ResponseWrapper(
            localName = "listOfUsers",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.listOfUsers"
    )
    List<UserDto> getListOfUsers();

    @WebResult(name = "deleteUser", targetNamespace = "")
    @RequestWrapper(
            localName = "deleteUser",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:deleteUser")
    void deleteUser(@WebParam(name = "userDto", targetNamespace = "") UserDto userDto);

    @WebResult(name = "saveGroup", targetNamespace = "")
    @RequestWrapper(
            localName = "saveGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:saveGroup")
    void saveGroup(@WebParam(name = "groupDto", targetNamespace = "") GroupDto groupDto);

    @WebResult(name = "deleteGroup", targetNamespace = "")
    @RequestWrapper(
            localName = "deleteGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:deleteGroup")
    void deleteGroup(@WebParam(name = "groupDto", targetNamespace = "") GroupDto groupDto);

    @WebResult(name = "getGroups", targetNamespace = "")
    @RequestWrapper(
            localName = "getGroups",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:getGroups")
    @ResponseWrapper(
            localName = "groups",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.groups"
    )
    List<GroupDto> getGroups();

    @WebResult(name = "getListOfUsersByGroup", targetNamespace = "")
    @RequestWrapper(
            localName = "getListOfUsersByGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:getListOfUsersByGroup")
    @ResponseWrapper(
            localName = "listOfUsersByGroup",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.listOfUsersByGroup"
    )
    List<UserDto> getListOfUsersByGroup(@WebParam(name = "groupDto", targetNamespace = "") GroupDto groupDto);

    @WebResult(name = "getUserByName", targetNamespace = "")
    @RequestWrapper(
            localName = "getUserByName",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.soapService.CommandWs"
    )
    @WebMethod(action = "urn:getUserByName")
    @ResponseWrapper(
            localName = "userByName",
            targetNamespace = "http://service.ws.sample/",
            className = "com.example.command_sp_boot.userByName"
    )
    UserDto getUserByName(@WebParam(name = "name", targetNamespace = "") String name);
}
