package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.Order;
import edu.uom.enex.server.service.CreditOrderDAOService;
import edu.uom.enex.server.service.OrderDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Controller
@RequestMapping("enex/creditOrder")
public class CreditOrderController {

    @Autowired
    private CreditOrderDAOService creditOrderDAOService;


    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveCreditOrder(@RequestBody CreditOrder creditOrder) {
        String res = creditOrderDAOService.addCreditOrder(creditOrder,"CR-");
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

    @RequestMapping(value = "getUnpaidOrders", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<CreditOrder> searchUnpaidCreditOrder() {
        return creditOrderDAOService.searchUnpaidCreditOrder();
    }


    @RequestMapping(value = "getCreditOrder", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Order getCreditOrder(@RequestParam("orderId") String orderId) {
        return creditOrderDAOService.getCreditOrderById(orderId);
    }

    @RequestMapping(value = "unsettleOrder", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean isHaveUnsettleOrder(@RequestParam("orderId") String orderId) {
        return  creditOrderDAOService.isHaveUnsettleOrder(orderId);
    }

}
