package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.CustomerReturnDAOController;
import edu.uom.enex.server.entity.CustomerReturn;
import org.springframework.stereotype.Repository;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Repository
public class CustomerReturnDAOControllerImpl extends AbstractDAOController<CustomerReturn, String> implements CustomerReturnDAOController {

    public CustomerReturnDAOControllerImpl() {
        super(CustomerReturn.class, String.class);
    }

    public String addCustReturn(CustomerReturn customerReturn) {
        return null;
    }

}
