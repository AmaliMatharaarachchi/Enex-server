package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.*;
import edu.uom.enex.server.service.OrderDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Controller
@RequestMapping("enex/order")
public class OrderController {

    @Autowired
    private OrderDAOService daoService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Order ob() {
        return new Order();
    }

    @RequestMapping(value = "getId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String getLastOrderId() {
        return daoService.getLastOrderId();
    }

    @RequestMapping(value = "saveOrder1", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addOrder(@RequestBody Order order, @RequestBody CreditOrder creditOrder, @RequestBody Payment payment) {
        int res = daoService.addOrder(order, creditOrder, payment);
        ResponseMessage responseMessage;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "saveOrder2", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addOrder(@RequestBody Order order, @RequestBody Payment payment) {
        int res = daoService.addOrder(order, payment);
        ResponseMessage responseMessage;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "saveOrder3", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addOrder(Order order, ArrayList<CustomerReturn> custReturnList, Payment payment) {
        int res = daoService.addOrder(order, custReturnList, payment);
        ResponseMessage responseMessage;
        if (res != 0) {
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
    public List<Order> getAllOrders() {
        return daoService.getAllOrders();
    }

    @RequestMapping(value = "searchOrderById", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Order searchOrderById(@RequestBody String orderId) {
        return daoService.getOrderById(orderId);
    }

    @RequestMapping(value = "searchOrderByCustName", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<Order> searchOrderByCustName(@RequestBody String custName) {
        return daoService.searchOrderByCustName(custName);
    }

    @RequestMapping(value = "productDiscount", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public double productDiscount(@RequestBody double qty, @RequestBody String pproductId) {
        return daoService.productDiscount(qty, pproductId);
    }

    @RequestMapping(value = "cancelOrder", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage cancelOrder(@RequestBody String orderId, @RequestBody ArrayList<OrderDetail> detailList) {
        int res = daoService.cancelOrder(orderId, detailList);
        ResponseMessage responseMessage;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "searchOrderDate", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<Order> searchOrderDate(@RequestBody String date) {
        return daoService.searchOrderDate(date);
    }

    @RequestMapping(value = "updateBalance", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateBalance(@RequestBody double balance, @RequestBody String orderId) {
        int res = daoService.updateBalance(balance, orderId);
        ResponseMessage responseMessage;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "getSelectedCustomerOrders", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<Order> getSelectedCustomerOrders(@RequestBody Date from, @RequestBody Date to) {
        return getSelectedCustomerOrders(from, to);
    }

    @RequestMapping(value = "archiOldRecords", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void archiOldRecords() {
    }


}
