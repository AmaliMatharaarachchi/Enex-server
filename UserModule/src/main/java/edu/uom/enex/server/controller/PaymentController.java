package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.Payment;
import edu.uom.enex.server.service.PaymentDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Controller
@RequestMapping("enex/payment")
public class PaymentController {

    @Autowired
    private PaymentDAOService paymentDAOService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Payment ob() {
        return new Payment();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage savePayment(@RequestBody Payment payment) {
        String res = paymentDAOService.savePayment(payment);
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

    @RequestMapping(value = "save2", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage savePayment(@RequestBody Payment payment, @RequestBody double balance) {
        int res = paymentDAOService.savePayment(payment, balance);
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
