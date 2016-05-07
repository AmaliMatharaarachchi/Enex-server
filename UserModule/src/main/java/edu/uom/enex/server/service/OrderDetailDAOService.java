package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.OrderDetailDAOController;
import edu.uom.enex.server.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class OrderDetailDAOService {

    @Autowired
    private OrderDetailDAOController orderDetailDAOController;

    public String saveOrderDetail(OrderDetail orderDetail) {
        String detailId = new Date().getTime() + "";
        orderDetail.setOrderDetailId(detailId);
        return orderDetailDAOController.create(orderDetail);

    }

    public String getLastOrderDetailId() {
        return orderDetailDAOController.getLastOrderDetailId();
    }

    public ArrayList<OrderDetail> searchOrderDetail(String orderId) {
        return orderDetailDAOController.searchOrderDetail(orderId);
    }

}
