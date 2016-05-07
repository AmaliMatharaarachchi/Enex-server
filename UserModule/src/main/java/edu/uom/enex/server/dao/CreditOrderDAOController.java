package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.Order;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface CreditOrderDAOController extends DAOController<CreditOrder, String> {

    boolean isHaveUnsettleOrder(String custId);

    ArrayList<Order> searchUnpaidCreditOrder();

}
