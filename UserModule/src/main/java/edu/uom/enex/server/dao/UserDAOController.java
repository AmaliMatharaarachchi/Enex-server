package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.User;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
public interface UserDAOController extends DAOController<User, String> {


    int getPrivilege(String username, String password);

    String getuserAvailability(String userName, String ep,String privilage);


    List<User> getUserByPrivilege(int privilege);

    String getLastUserId();
}
