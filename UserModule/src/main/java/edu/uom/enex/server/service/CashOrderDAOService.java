package edu.uom.enex.server.service;

import edu.uom.enex.server.common.IdGenerater;
import edu.uom.enex.server.dao.CashOrderDAOController;
import edu.uom.enex.server.entity.CashOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class CashOrderDAOService {

    @Autowired
    private CashOrderDAOController cashOrderDAOController;

    /**
     * add cash order
     *
     * @param cashOrder
     * @return
     */
    public String addCashOrder(CashOrder cashOrder, String type) {
        String newCashOrderId = getNewCashOrderId(type);
        cashOrder.setOrderId(newCashOrderId);
        return cashOrderDAOController.create(cashOrder);
    }

    /**
     * get Cash Order By cashOrderId (please note that read() is a hibenate method)
     *
     * @param cashOrderId
     * @return
     */
    public CashOrder getCashOrderById(String cashOrderId) {
        return cashOrderDAOController.read(cashOrderId);
    }

    /**
     * create new cashOrderId
     *
     * @param type
     * @return
     */
    private String getNewCashOrderId(String type) {
        String id = cashOrderDAOController.getLastCashOrderId(type);
        return new IdGenerater().generateId(id, type);
    }


    public String updateCashOrder(CashOrder cashOrder) {
        return cashOrderDAOController.update(cashOrder);
    }
}
