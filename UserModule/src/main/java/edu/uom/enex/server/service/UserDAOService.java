package edu.uom.enex.server.service;

import edu.uom.enex.server.common.IdGenerater;
import edu.uom.enex.server.dao.UserDAOController;
import edu.uom.enex.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Service
public class UserDAOService {

    @Autowired
    private UserDAOController userDAOController;


    public String addUser(User user, String type) {
        String id = getLastUserId(type);
        user.setUserId(id);
        return userDAOController.create(user);
    }

    private String getLastUserId(String type) {
        String id = userDAOController.getLastUserId();
        return new IdGenerater().generateId(id, type);
    }

    public List<UserModel> getAllUsers() {
        List<User> userList = userDAOController.getAll();
        List<UserModel> userModels = new ArrayList<UserModel>();
        UserModel userModel = new UserModel();
        for (User user : userList) {
            userModel.setUserId(user.getUserId());
            userModel.setName(user.getName());
            userModel.setAddress(user.getAddress());
            userModel.setContactNo(user.getContactNo());
            userModel.setPrivilege(user.getPrivilege());
            userModel.setUserName(user.getUserName());
            userModels.add(userModel);
        }

        return userModels;
    }

    public int getPrivilege(String username, String password) {
        return userDAOController.getPrivilege(username, password);
    }

    public String updatePassword(User user) {
        return userDAOController.update(user);
    }

    public String userAvailability(String userName, String ep, String privilege) {
        return userDAOController.getuserAvailability(userName, ep, privilege);
    }

    public List<User> getAllUsers(int privilege) {
        return userDAOController.getUserByPrivilege(privilege);
    }
}
