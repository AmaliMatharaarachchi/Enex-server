package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface OrderDAOContoller extends DAOController<Order, String> {

    String getLastOrderId();

    int addOrder(Order order, CreditOrder creditOrder, Payment payment);

    int addOrder(Order order, Payment payment);

    int addOrder(Order order, ArrayList<CustomerReturn> custReturnList, Payment payment);

    ArrayList<Order> searchOrderByCustName(String custName);

    double productDiscount(double qty, String productId);

    int cancelOrder(String orderId, ArrayList<OrderDetail> detailList);

    ArrayList<Order> searchOrderDate(String date);

    int updateBalance(double balance, String orderId);

    ArrayList<Order> getSelectedCustomerOrders(Date from, Date to);

    void archiOldRecords();

    String addOrder(Order order);
}

