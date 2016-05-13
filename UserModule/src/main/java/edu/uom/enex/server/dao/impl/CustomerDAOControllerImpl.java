package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.CustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import org.hibernate.Query;
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
    public ArrayList<Customer> getCreditCustomerList() {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerList(String name) {
        Query query = null;

        query = getSession().createQuery("SELECT * FROM companyCustomer WHERE name=" + name);
        ArrayList<Customer> customerList = (ArrayList<Customer>) query.list();

        return customerList;
    }

    @Override
    public String getLastCustomerId(String type) {
        Query query = null;
        if (type == "IC-") {
            query = getSession().createQuery("SELECT c.custId FROM IndividualCustomer c ORDER BY c.custId DESC");
            query.setMaxResults(1);
            return (String) query.uniqueResult();
        }

        if (type == "CC-") {
            query = getSession().createQuery("SELECT c.custId FROM CompanyCustomer c ORDER BY c.custId DESC");
            query.setMaxResults(1);
            return (String) query.uniqueResult();
        }
        return null;
    }
        @Override
        public ArrayList<Customer> getSelectedCustomers(String From, String Too) {
            Query query = null;

            query = getSession().createQuery("SELECT * FROM IndividualCustomer WHERE registeredDate BETWEEN" + From + "AND" + Too);
            ArrayList<Customer> customerList = (ArrayList<Customer>) query.list();

            return customerList;

        }
}
