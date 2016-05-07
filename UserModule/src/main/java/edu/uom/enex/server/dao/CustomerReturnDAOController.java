package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.CustomerReturn;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
public interface CustomerReturnDAOController extends DAOController<CustomerReturn, String> {

    String addCustReturn(CustomerReturn customerReturn) ;

}
