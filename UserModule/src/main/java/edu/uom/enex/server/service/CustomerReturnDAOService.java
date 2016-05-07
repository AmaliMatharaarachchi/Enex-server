package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.CustomerReturnDAOController;
import edu.uom.enex.server.entity.CustomerReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class CustomerReturnDAOService {

    @Autowired
    private CustomerReturnDAOController customerReturnDAOController;

    public String saveCustomerReturn(CustomerReturn customerReturn) {
        String returnId = new Date().getTime() + "";
        customerReturn.setOrderReturnId(returnId);
        return customerReturnDAOController.addCustReturn(customerReturn);

    }

}
