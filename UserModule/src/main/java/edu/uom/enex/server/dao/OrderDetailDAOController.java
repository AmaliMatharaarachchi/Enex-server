package edu.uom.enex.server.dao;


import edu.uom.enex.server.entity.OrderDetail;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface OrderDetailDAOController extends DAOController<OrderDetail, String> {

    List<OrderDetail> searchOrderDetail(String orderId);
}
