package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CashOrder;
import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.Order;
import edu.uom.enex.server.service.CashOrderDAOService;
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
@RequestMapping("enex/cashOrder")
public class CashOrderController {

    @Autowired
    private OrderDAOService orderDAOService;

    @Autowired
    private CashOrderDAOService cashOrderDAOService;


    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public CashOrder ob() {
        return new CashOrder();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveCreditOrder(@RequestBody CreditOrder creditOrder) {
        String res = orderDAOService.addOrder(creditOrder);
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
    public List<Order> searchUnpaidCreditOrder() {
        return cashOrderDAOService.searchUnpaidCreditOrder();
    }


    @RequestMapping(value = "getCreditOrder", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Order getCreditOrder(@RequestParam("orderId") String orderId) {
        return cashOrderDAOService.getCreditOrderById(orderId);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean isHaveUnsettleOrder(@RequestParam("orderId") String orderId) {
        return  cashOrderDAOService.isHaveUnsettleOrder(orderId);
    }

}
