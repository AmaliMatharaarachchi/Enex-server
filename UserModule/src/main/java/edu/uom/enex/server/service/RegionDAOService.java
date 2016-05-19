package edu.uom.enex.server.service;


import edu.uom.enex.server.common.IdGenerater;
import edu.uom.enex.server.dao.RegionDAOController;
import edu.uom.enex.server.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */
@Service
public class RegionDAOService {

    @Autowired
    private RegionDAOController regionDAOController;

    public String addRegion(Region region,String type) {
        String lastRegionId = getLastRegionId(type);
        region.setRegId(lastRegionId);
        return regionDAOController.create(region);
    }

    public Region searchRegion(String id) {
        return regionDAOController.read(id);
    }

    public String updateRegion(Region region) {
        return regionDAOController.update(region);
    }

    public int archiveRegion(Region Region) {
        return regionDAOController.archive(Region);

    }

    public List<Region> getAllRegions() {
        return regionDAOController.getAll();
    }

    private String getLastRegionId(String type) {
        String id = regionDAOController.getLastRegionId(type);
        return new IdGenerater().generateId(id, type);
    }


}
