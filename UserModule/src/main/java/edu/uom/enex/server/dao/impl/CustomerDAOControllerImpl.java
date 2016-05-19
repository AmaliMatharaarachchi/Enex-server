package edu.uom.enex.server.dao.impl;


import edu.uom.enex.server.dao.CustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import edu.uom.enex.server.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Repository
public class CustomerDAOControllerImpl extends AbstractDAOController<Customer, String> implements CustomerDAOController {

    public CustomerDAOControllerImpl() {
        super(Customer.class, String.class);
    }


    @Override
    public ArrayList<Customer> getCreditCustomerList() {
        return null;
    }

    @Override
    public String getLastCustomerId(String type) {
        String id = null;
        Query query = null;
        if (type == "IC-") {
            query = getSession().createQuery("SELECT c.custId FROM IndividualCustomer c ORDER BY c.custId DESC");
            query.setMaxResults(1);
            id = (String) query.uniqueResult();
        }

        if (type == "CC-") {
            query = getSession().createQuery("SELECT c.custId FROM CompanyCustomer c ORDER BY c.custId DESC");
            query.setMaxResults(1);
            id = (String) query.uniqueResult();
        }
        return id;
    }

    @Override
    public List<Customer> getAllCustomerByName(String name) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.like("name", name, MatchMode.START));
        return criteria.list();
    }

    @Override
    public ArrayList<Customer> getSelectedCustomers(String From, String To) {
        Query query = null;

        query = getSession().createQuery("SELECT * FROM IndividualCustomer WHERE registeredDate BETWEEN" + From + "AND" + To);
        ArrayList<Customer> customerList = (ArrayList<Customer>) query.list();

        return customerList;

    }
}
