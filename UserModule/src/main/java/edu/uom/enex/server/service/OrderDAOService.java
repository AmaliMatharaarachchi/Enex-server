package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.OrderDAOContoller;
import edu.uom.enex.server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class OrderDAOService {

    @Autowired
    private OrderDAOContoller orderDAOContoller;

    public Order getOrderById(String orderId) {
        return orderDAOContoller.read(orderId);
    }

    public List<Order> getAllOrders() {
        return orderDAOContoller.getAll();
    }

    public String getLastOrderId() {
        return orderDAOContoller.getLastOrderId();
    }

    public int addOrder(Order order, CreditOrder creditOrder, Payment payment) {
        return orderDAOContoller.addOrder(order, creditOrder, payment);
    }

    public int addOrder(Order order, Payment payment) {
        return orderDAOContoller.addOrder(order, payment);
    }

    public int addOrder(Order order, ArrayList<CustomerReturn> custReturnList, Payment payment) {
        return orderDAOContoller.addOrder(order, custReturnList, payment);
    }

    public ArrayList<Order> searchOrderByCustName(String custName) {
        return orderDAOContoller.searchOrderByCustName(custName);
    }

    public double productDiscount(double qty, String productId) {
        return orderDAOContoller.productDiscount(qty, productId);
    }

    public int cancelOrder(String orderId, ArrayList<OrderDetail> detailList) {
        return orderDAOContoller.cancelOrder(orderId, detailList);
    }

    public ArrayList<Order> searchOrderDate(String date) {
        return orderDAOContoller.searchOrderDate(date);
    }

    public int updateBalance(double balance, String orderId) {
        return orderDAOContoller.updateBalance(balance, orderId);
    }

    public ArrayList<Order> getSelectedCustomerOrders(Date from, Date to) {
        return orderDAOContoller.getSelectedCustomerOrders(from, to);
    }

    public void archiOldRecords() {
    }


}
