package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.CreditOrderDAOController;
import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
@Repository
public class CreditOrderDAOControllerImpl extends AbstractDAOController<CreditOrder,String> implements CreditOrderDAOController {


    public CreditOrderDAOControllerImpl() {
        super(CreditOrder.class, String.class);
    }

    public boolean isHaveUnsettleOrder(String custId) {
        return false;
    }

    @Override
    public ArrayList<Order> searchUnpaidCreditOrder() {
        return null;
    }
}
