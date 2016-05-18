package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.UserDAOController;
import edu.uom.enex.server.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Repository
public class UserDAOControllerImpl extends AbstractDAOController<User, String> implements UserDAOController {

    public UserDAOControllerImpl() {
        super(User.class, String.class);
    }

    public int getPrivilege(String username, String password) {
        return 0;
    }

    @Override
    public String getuserAvailability(String userName, String ep,String privilage) {
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("username", userName));
        criteria.add(Restrictions.eq("password", ep));
        criteria.add(Restrictions.eq("privilege", privilage));
        if ( criteria.list().size()>0) {
            User o = (User) criteria.list().get(0);
            if (o != null) {
                return o.getId();
            } else {
                return null;
            }
        }else {
            return null;
        }
    }
}
