package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CustomerReturn;
import edu.uom.enex.server.service.CustomerReturnDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Controller
@RequestMapping("enex/customerReturn")
public class CustomerReturnController {

    @Autowired
    private CustomerReturnDAOService customerReturnDAOService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public CustomerReturn ob() {
        return new CustomerReturn();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveCustomer(@RequestBody CustomerReturn customerReturn) {
        String res = customerReturnDAOService.saveCustomerReturn(customerReturn);
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

}
