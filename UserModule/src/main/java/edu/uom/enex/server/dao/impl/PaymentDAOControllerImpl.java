package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.PaymentDAOController;
import edu.uom.enex.server.entity.Payment;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Repository
public class PaymentDAOControllerImpl extends AbstractDAOController<Payment, String> implements PaymentDAOController {

    public PaymentDAOControllerImpl() {
        super(Payment.class, String.class);
    }

    public int addCustomerPayment(Payment payment, double balance) {
        return 1;
    }

}
