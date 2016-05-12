package edu.uom.enex.server.controller;
<<<<<<< HEAD

=======
>>>>>>> 85ff9d12bdb52f1138c51f8e3ba05d1f36c822f7
import edu.uom.enex.server.entity.CompanyCustomer;
import edu.uom.enex.server.service.CustomerDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Himashi Nethinika on 5/12/2016.
=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kavindya on 5/12/2016.
>>>>>>> 85ff9d12bdb52f1138c51f8e3ba05d1f36c822f7
 */

@Controller
@RequestMapping("enex/companyCustomer")
public class CompanyCustomerController {

    @Autowired
    private CustomerDAOService customerDAOService;

<<<<<<< HEAD
    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public CompanyCustomer ob() {
        return new CompanyCustomer();
    }
=======
    // must edit the constructor..
//    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public CompanyCustomer ob() {
//        return new CompanyCustomer();
//    }
>>>>>>> 85ff9d12bdb52f1138c51f8e3ba05d1f36c822f7

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
<<<<<<< HEAD
        String res = customerDAOService.saveCustomer(customer,"CC-");
=======
        String res = customerDAOService.saveCustomer(customer, "IC");
>>>>>>> 85ff9d12bdb52f1138c51f8e3ba05d1f36c822f7
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
<<<<<<< HEAD

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


}
=======
}
>>>>>>> 85ff9d12bdb52f1138c51f8e3ba05d1f36c822f7
