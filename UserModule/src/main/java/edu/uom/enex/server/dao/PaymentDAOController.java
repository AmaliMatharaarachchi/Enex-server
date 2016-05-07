package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.Payment;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
public interface PaymentDAOController extends DAOController<Payment, String> {

    int addCustomerPayment(Payment payment, double balance);

}
