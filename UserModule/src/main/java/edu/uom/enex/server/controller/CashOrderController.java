package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CashOrder;
import edu.uom.enex.server.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Controller
@RequestMapping("enex/cashOrder")
public class CashOrderController {

    @Autowired
    private CashOrderDAOService cashOrderDAOService;

    /**
     * save cash order
     *
     * @param cashOrder
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveCashOrder(@RequestBody CashOrder cashOrder) {
        String res = cashOrderDAOService.addCashOrder(cashOrder,"CH-");
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

    /**
     * update cash order
     *
     * @param cashOrder
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateCashOrder(@RequestBody CashOrder cashOrder) {
        String res = cashOrderDAOService.updateCashOrder(cashOrder);
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


    /**
     * get cash order by orderId
     *
     * @param orderId
     * @return
     */
    @RequestMapping(value = "getCashOrderById", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Order getCreditOrder(@RequestParam("orderId") String orderId) {
        return cashOrderDAOService.getCashOrderById(orderId);
    }

}
