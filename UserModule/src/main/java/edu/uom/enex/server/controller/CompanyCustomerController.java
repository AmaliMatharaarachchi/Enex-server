package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.CompanyCustomer;
import edu.uom.enex.server.entity.IndividualCustomer;
import edu.uom.enex.server.service.CustomerDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Himashi Nethinika on 5/12/2016.
 */

@Controller
@RequestMapping("enex/companyCustomer")
public class CompanyCustomerController {

    @Autowired
    private CustomerDAOService customerDAOService;

    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public CompanyCustomer ob() {
        return new CompanyCustomer();
    }

    /**
     * save Customer
     *
     * @param customer
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addCustomer(@RequestBody CompanyCustomer customer) {
        ResponseMessage responseMessage;
        String res = customerDAOService.saveCustomer(customer,"CC-");
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
    public ResponseMessage updateCustomer(@RequestBody CompanyCustomer customer) {
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
    public List<CompanyCustomer> getAllCustomers() {
        return customerDAOService.getAllCustomers();
    }


    @RequestMapping(value = "getCustomerByCustomerId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public CompanyCustomer getCustomerByCustomerId(@RequestParam("customerId") String customerId) {
        CompanyCustomer customer = (CompanyCustomer) customerDAOService.getCustomerByCustomerId(customerId);
        return customer;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage deleteCustomer(@RequestParam("customerId") CompanyCustomer customer) {
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

    @RequestMapping( value = "getCustomerListByDate", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<CompanyCustomer> getCustomerListByDate(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
        ArrayList<CompanyCustomer> CompanyCustomerList =  customerDAOService.getCustomerListByDate(dateFrom, dateTo);
        return CompanyCustomerList;
    }


    @RequestMapping( value = "getCustomerByName", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<CompanyCustomer> getCustomerByName(@RequestParam("customerName") String customerName) {

        ArrayList<CompanyCustomer> CompanyCustomerList =  customerDAOService.getCustomerByName(customerName);
        return CompanyCustomerList;
    }



}
