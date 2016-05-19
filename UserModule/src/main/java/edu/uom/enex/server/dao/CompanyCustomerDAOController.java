package edu.uom.enex.server.dao;


import edu.uom.enex.server.entity.CompanyCustomer;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface CompanyCustomerDAOController extends DAOController<CompanyCustomer, String> {

    ArrayList<CompanyCustomer> getSelectedCustomers(String from, String to);

    ArrayList<CompanyCustomer> getCreditCustomerList();


}
