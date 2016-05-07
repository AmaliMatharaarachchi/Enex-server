package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.OrderDetailDAOController;
import edu.uom.enex.server.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Repository
public class OrderDetailDAOControllerImpl extends AbstractDAOController<OrderDetail, String> implements OrderDetailDAOController {

    public OrderDetailDAOControllerImpl() {
        super(OrderDetail.class,String.class);
    }

    public String getLastOrderDetailId(){
        return null;
    }

    public ArrayList<OrderDetail> searchOrderDetail(String orderId){
        return null;
    }
}
