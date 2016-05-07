package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.RegionDAOController;
import edu.uom.enex.server.entity.Region;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */
@Repository
public class RegionDAOControllerImpl extends AbstractDAOController<Region, String> implements RegionDAOController {

    public RegionDAOControllerImpl() {
        super(Region.class, String.class);
    }

}
