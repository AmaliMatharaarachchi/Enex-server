package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.OrderDAOContoller;
import edu.uom.enex.server.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Repository
public class OrderDAOContollerImpl extends AbstractDAOController<Order, String> implements OrderDAOContoller {

    public OrderDAOContollerImpl() {
        super(Order.class, String.class);
    }

    public String getLastOrderId() {
        return null;
    }

    public int addOrder(Order order, CreditOrder creditOrder, Payment payment) {
        return 1;
    }

    public int addOrder(Order order, Payment payment){
        return 1;
    }

    public int addOrder(Order order, ArrayList<CustomerReturn> custReturnList, Payment payment){
        return 1;
    }

    public ArrayList<Order> searchOrderByCustName(String custName){
        return null;
    }

   public double productDiscount(double qty, String pproductId){
       return 0.0;
   }

   public int cancelOrder(String orderId, ArrayList<OrderDetail> detailList){
       return 1;
   }

    public ArrayList<Order> searchOrderDate(String date){
        return null;
    }

    public int updateBalance(double balance, String orderId){
        return 1;
    }

    public ArrayList<Order> getSelectedCustomerOrders(Date from, Date to){
        return null;
    }

    public void archiOldRecords(){

    }
}

