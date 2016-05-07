package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.UserDAOController;
import edu.uom.enex.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Service
public class UserDAOService {

    @Autowired
    UserDAOController userDAOController;

    public boolean isHaveUser(User user) {
        return userDAOController.isHaveUser(user);
    }

    public String addUser(User user) {
        return userDAOController.create(user);
    }

    public List<User> getAllUsers() {
        return userDAOController.getAll();
    }

    public int getPrivilege(String username, String password) {
        return userDAOController.getPrivilege(username, password);
    }

    public int updatePassword(User user) {
        return userDAOController.updatePassword(user);
    }

}
