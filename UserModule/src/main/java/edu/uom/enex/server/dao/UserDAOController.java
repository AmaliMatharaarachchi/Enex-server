package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.User;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
public interface UserDAOController extends DAOController<User, String> {

    boolean isHaveUser(User user);

    int getPrivilege(String username, String password);

    int updatePassword(User user);

}
