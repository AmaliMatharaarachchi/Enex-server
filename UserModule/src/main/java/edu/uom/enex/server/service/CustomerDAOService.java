package edu.uom.enex.server.service;

import edu.uom.enex.server.common.Hashids;
import edu.uom.enex.server.common.IdGenerater;
import edu.uom.enex.server.dao.CustomerDAOController;
import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class CustomerDAOService <T extends Customer>{

    @Autowired
    private CustomerDAOController customerDAOController;

    /**
     * save customer
     *
     * @param customer
     * @return
     */
    public String saveCustomer(T customer , String type) {

        String customerId = new Date().getTime() + "";
        Hashids hashids = new Hashids(customerId);
        String hexaid = hashids.encodeHex(String.format("%040x", new BigInteger(1, customerId.getBytes())));
        String newid = hexaid + "" + randomString(10);
        customer.setCustomerId(newid);
        String lastCustomerId = getLastCustomerId(type);
        customer.setCustomerId(lastCustomerId);


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
    public T getCustomerByCustomerId(String customerId) {
        return (T)customerDAOController.read(customerId);
    }

    public int deleteCustomer(Customer customer) {
        return customerDAOController.archive(customer);
    }

    private String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    private  String getLastCustomerId(String type){
        String id= customerDAOController.getLastCustomerId(type);
        return new IdGenerater().generateId(id,type);
//return "285443654363";
         }

}
