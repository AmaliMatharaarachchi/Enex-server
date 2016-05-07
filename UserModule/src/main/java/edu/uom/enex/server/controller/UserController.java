package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.User;
import edu.uom.enex.server.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Controller
@RequestMapping("enex/user")
public class UserController {

    @Autowired
    private UserDAOService daoService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public User ob() {
        return new User();
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean isHaveUser(@RequestBody User user) {
        return daoService.isHaveUser(user);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addUser(@RequestBody User user) {
        String res = daoService.addUser(user);
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

    @RequestMapping(value = "getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<User> getAllUsers() {
        return daoService.getAllUsers();
    }

    @RequestMapping(value = "getPrivilege", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public int getPrivilege(@RequestBody String username, @RequestBody String password) {
        return daoService.getPrivilege(username, password);
    }

    @RequestMapping(value = "updatePassword", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updatePassword(@RequestBody User user) {
        int res = daoService.updatePassword(user);
        ResponseMessage responseMessage;
        if (res != 1) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

}
