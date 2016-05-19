package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.CashOrder;

/**
 * Created by Himashi Nethinika on 5/20/2016.
 */
public interface CashOrderDAOController extends DAOController<CashOrder, String> {
    String getLastCashOrderId(String type);
}
