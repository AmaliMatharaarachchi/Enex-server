package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.CustomerDAOController;
import edu.uom.enex.server.dao.IndividualCustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class IndividualCustomerDAOService {

    @Autowired
    private IndividualCustomerDAOController customerDAOController;

    /**
     * save customer
     *
     * @param customer
     * @return
     */
    public String saveCustomer(IndividualCustomer customer) {
        String customerId = new Date().getTime() + "";
        customer.setCustomerId(customerId);
        return customerDAOController.create(customer);
    }


    /**
     * update customer
     *
     * @param customer
     * @return
     */
    public String updateCustomer(IndividualCustomer customer) {
        return customerDAOController.update(customer);
    }

    /**
     * getAll customers
     *
     * @return
     */
    public List<IndividualCustomer> getAllCustomers() {
        return customerDAOController.getAll();
    }

    /**
     * get customer by id
     *
     * @param customerId
     * @return
     */
    public IndividualCustomer getCustomerByCustomerId(String customerId) {
        return customerDAOController.read(customerId);
    }

    public int deleteCustomer(IndividualCustomer customer) {
        return customerDAOController.archive(customer);
    }
}
