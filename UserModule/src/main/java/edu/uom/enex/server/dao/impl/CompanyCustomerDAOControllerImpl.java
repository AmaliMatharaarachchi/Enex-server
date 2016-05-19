package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.CompanyCustomerDAOController;
import edu.uom.enex.server.entity.CompanyCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Repository
public class CompanyCustomerDAOControllerImpl extends AbstractDAOController<CompanyCustomer,String> implements CompanyCustomerDAOController{

    public CompanyCustomerDAOControllerImpl() {
        super(CompanyCustomer.class, String.class);
    }

    @Override
    public ArrayList<CompanyCustomer> getSelectedCustomers(String from, String to) {
        return null;
    }

    @Override
    public ArrayList<CompanyCustomer> getCreditCustomerList() {
        return null;
    }

}
