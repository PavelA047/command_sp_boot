//package com.example.command_sp_boot;
//
//import com.example.command_sp_boot.dto.UserModel;
//import com.example.command_sp_boot.entities.Group;
//import com.example.command_sp_boot.services.GroupService;
//import com.example.command_sp_boot.services.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.jdbc.Sql;
//
//import java.util.List;
//
//@SpringBootTest
//@TestPropertySource("/application-test.properties")
//@Sql(value = {"/after_test.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//class CommandSpBootApplicationTests {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    GroupService groupService;
//
//    @Test
//    void saveUser() {
//        userService.saveUser(new UserModel("den", "winners", "lector", "bla-bla"));
//        UserModel den = userService.getUserModelByUserName("den");
//
//        Assertions.assertEquals("bla-bla", den.getChatId());
//    }
//
//    @Test
//    void getListOfUsersModelsByRoleName() {
//        insertAndGetListOfUsersModels();
//        List<UserModel> lead = userService.getListOfUsersModelsByRoleName("lead");
//
//        Assertions.assertEquals(2, lead.size());
//    }
//
//    @Test
//    void getListOfUsersModelsByGroupName() {
//        insertAndGetListOfUsersModels();
//        List<UserModel> losers = userService.getListOfUsersModelsByGroupName("losers");
//
//        Assertions.assertNotEquals(2, losers.size());
//    }
//
//    @Test
//    void getListOfUsers() {
//        List<UserModel> listOfUsers = insertAndGetListOfUsersModels();
//
//        Assertions.assertEquals("mike", listOfUsers.get(2).getUserName());
//    }
//
//    @Test
//    void deleteUser() {
//        insertAndGetListOfUsersModels();
//        userService.deleteUser("mike");
//        List<UserModel> list = userService.getListOfUsers();
//
//        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
//    }
//
//    @Test
//    void getUserModelByUserName() {
//        insertAndGetListOfUsersModels();
//        UserModel ivan = userService.getUserModelByUserName("ivan");
//
//        Assertions.assertEquals("BBB", ivan.getChatId());
//    }
//
//    @Test
//    void isAnyUsersInSuchGroup() {
//        insertAndGetListOfUsersModels();
//
//        Assertions.assertFalse(userService.isAnyUsersInSuchGroup(new Group(3L, "NEW_GROUP")));
//    }
//
//    @Test
//    void saveGroup() {
//        groupService.saveGroup("NEW_GROUP");
//        Group new_group = groupService.findGroupByName("NEW_GROUP");
//
//        Assertions.assertNotNull(new_group);
//        groupService.deleteGroup("NEW_GROUP");
//    }
//
//    @Test
//    void deleteGroupWithUsers() {
//        insertAndGetListOfUsersModels();
//        groupService.deleteGroup("winners");
//        Group winners = groupService.findGroupByName("winners");
//
//        Assertions.assertNotNull(winners);
//    }
//
//    @Test
//    void deleteGroupWithoutUsers() {
//        groupService.saveGroup("GROUP_WITHOUT_USERS");
//        groupService.deleteGroup("GROUP_WITHOUT_USERS");
//        Group newGroup = groupService.findGroupByName("GROUP_WITHOUT_USERS");
//
//        Assertions.assertNull(newGroup);
//    }
//
//    @Test
//    void deleteNotExistingGroup() {
//        groupService.deleteGroup("NOT_EXISTING");
//        Group notExisting = groupService.findGroupByName("NOT_EXISTING");
//
//        Assertions.assertNull(notExisting);
//    }
//
//    @Test
//    void getGroupsNames() {
//        List<String> groupsNames = groupService.getGroupsNames();
//
//        Assertions.assertEquals("winners", groupsNames.get(0));
//    }
//
//    @Test
//    void findGroupByName() {
//        Group losers = groupService.findGroupByName("losers");
//
//        Assertions.assertNotNull(losers);
//    }
//
//    private List<UserModel> insertAndGetListOfUsersModels() {
//        userService.saveUser(new UserModel("ivan", "winners", "lead", "BBB"));
//        userService.saveUser(new UserModel("den", "winners", "lector", "bla-bla"));
//        userService.saveUser(new UserModel("mike", "losers", "lead", "bla-bla"));
//        return userService.getListOfUsers();
//    }
//}
