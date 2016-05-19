package edu.uom.enex.server.service;

import edu.uom.enex.server.common.IdGenerater;
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
     * add new credit order
     *
     * @param creditOrder
     * @return
     */
    public String addCreditOrder(CreditOrder creditOrder,String type) {
        String newCreditOrderId = getNewCreditOrderId(type);
        creditOrder.setOrderId(newCreditOrderId);
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
    public ArrayList<CreditOrder> searchUnpaidCreditOrder() {
        return creditOrderDAOController.searchUnpaidCreditOrder();
    }

    /**get new credit orderId
     *
     * @param type
     * @return
     */
    private  String getNewCreditOrderId(String type){
        String id= creditOrderDAOController.getLastCreditOrderId(type);
        return new IdGenerater().generateId(id,type);
    }

}
