package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.Customer;
import edu.uom.enex.server.entity.IndividualCustomer;
import edu.uom.enex.server.service.CustomerDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Controller
@RequestMapping("enex/individualCustomer")
public class IndividualCustomerController {
    @Autowired
    private CustomerDAOService customerDAOService;

    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public IndividualCustomer ob() {
        return new IndividualCustomer();
    }

    /**
     * save Customer
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addCustomer(@RequestBody IndividualCustomer customer) {
        ResponseMessage responseMessage;
        String res = customerDAOService.saveCustomer(customer, "IC-");
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }

        return responseMessage;
    }

    /**
     * update Customer
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateCustomer(@RequestBody IndividualCustomer customer) {
        String res = customerDAOService.updateCustomer(customer);
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    /**
     * get all Customers
     *
     * @return
     */
    @RequestMapping(value = "getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerDAOService.getAllCustomers();
    }

    /**
     * get all Customers
     *
     * @return
     */
    @RequestMapping(value = "getAllIndividualCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<IndividualCustomer> getAllIndividualCustomers() {
        return customerDAOService.getAllIndividualCustomers();
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage deleteCustomer(@RequestBody Customer customer) {
        int res = customerDAOService.deleteCustomer(customer);
        ResponseMessage responseMessage;
        if (res != 0) {
            responseMessage = ResponseMessage.SUCCESS;
            responseMessage.setData(res);
        } else {
            responseMessage = ResponseMessage.DANGER;
            responseMessage.setData(res);
        }
        return responseMessage;
    }

    @RequestMapping(value = "getCustomerByCustomerId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public IndividualCustomer getCustomerByCustomerId(@RequestParam("customerId") String customerId) {
        IndividualCustomer customer = (IndividualCustomer) customerDAOService.getCustomerByCustomerId(customerId);
        return customer;
    }

    @RequestMapping(value = "getCustomerByName", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Customer> getCustomerByName(@RequestParam("name") String name) {
        List<Customer> customerList = customerDAOService.getCustomerByName(name);
        return customerList;
    }

    @RequestMapping(value = "getCustomerListByDate", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<IndividualCustomer> getCustomerListByDate(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
        ArrayList<IndividualCustomer> individualCustomerList = customerDAOService.getCustomerListByDate(dateFrom, dateTo);
        return individualCustomerList;
    }


}