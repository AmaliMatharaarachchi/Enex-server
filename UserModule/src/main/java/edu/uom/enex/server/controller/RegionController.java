package edu.uom.enex.server.controller;


import edu.uom.enex.server.entity.Region;
import edu.uom.enex.server.service.RegionDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/6/2016.
 */
@Controller
@RequestMapping("enex/region")
public class RegionController {

    @Autowired
    private RegionDAOService daoService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Region ob() {
        return new Region();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addRegion(@RequestBody Region region) {
        String res = daoService.addRegion(region);
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Region searchRegion(@RequestBody String id) {
        return daoService.searchRegion(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateRegion(@RequestBody Region region) {
        String res = daoService.updateRegion(region);
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "archive", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public int archiveRegion(@RequestBody Region region) {
        return daoService.archiveRegion(region);
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Region> getAllRegions() {
        return daoService.getAllRegions();
    }


}
