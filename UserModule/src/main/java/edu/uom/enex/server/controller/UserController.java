package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.User;
import edu.uom.enex.server.modle.UserModel;
import edu.uom.enex.server.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Controller
@RequestMapping("enex/user")
public class UserController {

    @Autowired
    private UserDAOService daoService;


    @RequestMapping(value = "checkUser", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public UserModel isHaveUser(@RequestParam("userName") String userName,@RequestParam("ep") String ep,@RequestParam("privilege") String privilege) {
        String res=daoService.userAvailability(userName,ep,privilege);
        UserModel userModel=new UserModel();
        if(res!= null){
            userModel.setUserId(res);
        }
        return userModel;
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
    public List<UserModel> getAllUsers() {
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
        String res = daoService.updatePassword(user);
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

    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public User getUserOb() {
        return new User();
    }


}
