package edu.uom.enex.server.controller;
import edu.uom.enex.server.entity.CompanyCustomer;
import edu.uom.enex.server.service.CustomerDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kavindya on 5/12/2016.
 */

@Controller
@RequestMapping("enex/companyCustomer")
public class CompanyCustomerController {

    @Autowired
    private CustomerDAOService customerDAOService;

    // must edit the constructor..
//    @RequestMapping(value = "ob", method = RequestMethod.GET, headers = "Accept=application/json")
//    @ResponseBody
//    public CompanyCustomer ob() {
//        return new CompanyCustomer();
//    }

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
        String res = customerDAOService.saveCustomer(customer, "IC");
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
}