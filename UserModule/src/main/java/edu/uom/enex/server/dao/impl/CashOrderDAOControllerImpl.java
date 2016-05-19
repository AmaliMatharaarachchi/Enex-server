package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.CashOrderDAOController;
import edu.uom.enex.server.entity.CashOrder;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 5/15/16.
 */
@Repository
public class CashOrderDAOControllerImpl extends AbstractDAOController<CashOrder, String> implements CashOrderDAOController {
    public CashOrderDAOControllerImpl() {
        super(CashOrder.class,String.class);
    }

    @Override
    public String getLastCashOrderId(String type) {
        String id=null;
        Query query = null;
        if (type == "CH-") {
            query = getSession().createQuery("SELECT c.orderId FROM CashOrder c ORDER BY c.orderId DESC");
            query.setMaxResults(1);
            id= (String) query.uniqueResult();
        }
        return id;
    }
}
