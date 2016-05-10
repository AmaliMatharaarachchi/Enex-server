package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.IndividualCustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Repository
public class IndividualCustomerDAOControllerImpl extends AbstractDAOController<IndividualCustomer,String> implements IndividualCustomerDAOController{

    public IndividualCustomerDAOControllerImpl() {
        super(IndividualCustomer.class, String.class);
    }

    @Override
    public ArrayList<IndividualCustomer> getSelectedCustomers(String from, String to) {
      return null;
    }



    @Override
    public ArrayList<IndividualCustomer> getCreditCustomerList() {
        return null;
    }
}
