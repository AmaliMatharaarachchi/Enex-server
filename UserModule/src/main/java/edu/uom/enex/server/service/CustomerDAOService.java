package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.CustomerDAOController;
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
public class CustomerDAOService {

    @Autowired
    private CustomerDAOController customerDAOController;

    /**
     * save customer
     *
     * @param customer
     * @return
     */
    public String saveCustomer(Customer customer) {
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
    public String updateCustomer(Customer customer) {
        return customerDAOController.update(customer);
    }

    /**
     * getAll customers
     *
     * @return
     */
    public List<Customer> getAllCustomers() {
        return customerDAOController.getAll();
    }

    /**
     * get customer by id
     *
     * @param customerId
     * @return
     */
    public Customer getCustomerByCustomerId(String customerId) {
        return customerDAOController.read(customerId);
    }

    public int deleteCustomer(Customer customer) {
        return customerDAOController.archive(customer);
    }
}
