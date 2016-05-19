package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.OrderDetailDAOController;
import edu.uom.enex.server.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class OrderDetailDAOService {

    @Autowired
    private OrderDetailDAOController orderDetailDAOController;

    /**
     * add  new order detail
     *
     * @param orderDetail
     * @return
     */
    public String addOrderDetail(OrderDetail orderDetail) {
        String detailId = new Date().getTime() + "";
        orderDetail.setOrderDetailId(detailId);
        return orderDetailDAOController.create(orderDetail);

    }

    /**
     * get last orderDetailId
     *
     * @return
     */
    public String getLastOrderDetailId() {
        Long allCount = orderDetailDAOController.getAllCount();
        List<OrderDetail> all = orderDetailDAOController.getAll();
        OrderDetail orderDetail = all.get(allCount.intValue());
        return orderDetail.getId();

    }

    public List<OrderDetail> searchOrderDetail(String orderId) {
        return orderDetailDAOController.searchOrderDetail(orderId);
    }

}
