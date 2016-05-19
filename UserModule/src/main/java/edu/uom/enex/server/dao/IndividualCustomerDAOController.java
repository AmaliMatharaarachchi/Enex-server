package edu.uom.enex.server.dao;


import edu.uom.enex.server.entity.IndividualCustomer;

import java.util.ArrayList;

/**
 * Created by Himashi Nethinika on 4/2/2016.
 */
public interface IndividualCustomerDAOController extends DAOController<IndividualCustomer, String> {

    ArrayList<IndividualCustomer> getSelectedCustomers(String from, String to);

    ArrayList<IndividualCustomer> getCreditCustomerList();


}
