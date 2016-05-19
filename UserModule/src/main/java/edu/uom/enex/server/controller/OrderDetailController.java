package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.OrderDetail;
import edu.uom.enex.server.service.OrderDetailDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Controller
@RequestMapping("enex/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailDAOService orderDetailDAOService;

    /**
     * save new order detail
     *
     * @param orderDetail
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        String res = orderDetailDAOService.addOrderDetail(orderDetail);
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

    @RequestMapping(value = "searchOrderDetailByOrderId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<OrderDetail> searchOrderDetail(@RequestBody String orderId) {
        return orderDetailDAOService.searchOrderDetail(orderId);
    }

    @RequestMapping(value = "getLastOrderDetailId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getLastOrderDetailId() {
        return orderDetailDAOService.getLastOrderDetailId();
    }

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public CreditOrder ob() {
        return new CreditOrder();
    }


}
