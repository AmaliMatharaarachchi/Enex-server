package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.CreditOrderDAOController;
import edu.uom.enex.server.entity.CreditOrder;
import edu.uom.enex.server.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class CreditOrderDAOService {

    @Autowired
    private CreditOrderDAOController creditOrderDAOController;

    /**
     * @param creditOrder
     * @return
     */
    public String saveCreditOrder(CreditOrder creditOrder) {
        String creditOrderId = new Date().getTime() + "";
        creditOrder.setCustomerId(creditOrderId);
        return creditOrderDAOController.create(creditOrder);

    }

    /**
     * @param creditOrder
     * @return
     */
    public CreditOrder getCreditOrderById(String creditOrder) {
        return creditOrderDAOController.read(creditOrder);
    }

    /**
     * @param custId
     * @return
     */
    public boolean isHaveUnsettleOrder(String custId) {
        return creditOrderDAOController.isHaveUnsettleOrder(custId);
    }

    /**
     * @return
     */
    public ArrayList<Order> searchUnpaidCreditOrder() {
        return creditOrderDAOController.searchUnpaidCreditOrder();
    }

}
