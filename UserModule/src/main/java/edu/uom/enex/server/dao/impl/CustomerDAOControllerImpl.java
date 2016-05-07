package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.CustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Repository
public class CustomerDAOControllerImpl extends AbstractDAOController<Customer,String> implements CustomerDAOController {

    public CustomerDAOControllerImpl() {
        super(Customer.class, String.class);
    }

    @Override
    public ArrayList<Customer> getSelectedCustomers(String from, String to) {
      return null;
    }



    @Override
    public ArrayList<Customer> getCreditCustomerList() {
        return null;
    }
}
