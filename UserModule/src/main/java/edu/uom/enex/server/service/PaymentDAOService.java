package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.PaymentDAOController;
import edu.uom.enex.server.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/7/16.
 */
@Service
public class PaymentDAOService {

    @Autowired
    private PaymentDAOController paymentDAOController;

    public String savePayment(Payment payment) {
        String payId = new Date().getTime() + "";
        payment.setPaymentId(payId);
        return paymentDAOController.create(payment);

    }

    public int savePayment(Payment payment, double balance) {
        String payId = new Date().getTime() + "";
        payment.setPaymentId(payId);
        return paymentDAOController.addCustomerPayment(payment, balance);

    }

}
