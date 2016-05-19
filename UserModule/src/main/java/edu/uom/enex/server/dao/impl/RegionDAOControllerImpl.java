package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.RegionDAOController;
import edu.uom.enex.server.entity.Region;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */
@Repository
public class RegionDAOControllerImpl extends AbstractDAOController<Region, String> implements RegionDAOController {

    public RegionDAOControllerImpl() {
        super(Region.class, String.class);
    }

    @Override
    public String getLastRegionId(String type) {
        Query query = getSession().createQuery("SELECT r.regId FROM Region r ORDER BY r.regId DESC");
        query.setMaxResults(1);
        return (String) query.uniqueResult();
    }
}
