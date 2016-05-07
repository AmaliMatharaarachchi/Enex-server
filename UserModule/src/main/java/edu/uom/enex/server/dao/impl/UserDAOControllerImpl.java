package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.UserDAOController;
import edu.uom.enex.server.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Repository
public class UserDAOControllerImpl extends AbstractDAOController<User, String> implements UserDAOController {

    public UserDAOControllerImpl() {
        super(User.class, String.class);
    }

    public boolean isHaveUser(User user) {
        return false;
    }

    public int getPrivilege(String username, String password) {
        return 0;
    }

    public int updatePassword(User user) {
        return 0;
    }

}
