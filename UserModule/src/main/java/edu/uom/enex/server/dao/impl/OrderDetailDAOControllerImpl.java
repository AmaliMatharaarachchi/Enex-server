package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.OrderDetailDAOController;
import edu.uom.enex.server.entity.OrderDetail;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Repository
public class OrderDetailDAOControllerImpl extends AbstractDAOController<OrderDetail, String> implements OrderDetailDAOController {

    public OrderDetailDAOControllerImpl() {
        super(OrderDetail.class,String.class);
    }

    /**
     * search all order details by orderId from DB & return result
     *
     * @param orderId
     * @return
     */
    public List<OrderDetail> searchOrderDetail(String orderId){
        //hibernate criteria working and search orderId with database orderId column & return result
        Criteria criteria = getSession().createCriteria(entityType);
        criteria.add(Restrictions.eq("orderId", orderId));
        return criteria.list();

    }
}
