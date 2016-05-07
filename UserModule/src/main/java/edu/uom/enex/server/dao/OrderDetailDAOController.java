package edu.uom.enex.server.dao;


import edu.uom.enex.server.entity.OrderDetail;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface OrderDetailDAOController extends DAOController<OrderDetail, String> {

    String getLastOrderDetailId();

    ArrayList<OrderDetail> searchOrderDetail(String orderId);
}
