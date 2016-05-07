package edu.uom.enex.server.dao.impl;

import edu.uom.enex.server.dao.ProductDAOController;
import edu.uom.enex.server.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Repository
public class ProductDAOControllerImpl extends AbstractDAOController<Product, String> implements ProductDAOController {

    public ProductDAOControllerImpl() {
        super(Product.class, String.class);
    }

    public ArrayList<Product> getAvailableProducts() {
        return null;
    }

    public ArrayList<Product> getSelectedProducts(Date from, Date to) {
        return null;
    }

    public int decreaseItemQtyOnHand(String productId, double qty) {
        return 1;
    }

    public int increaseQtyOnHand(String itemCode, double qty) {
        return 1;
    }

    public int updateCost(String productId, double price) {
        return 1;
    }

    public ArrayList<Product> searchLowQtyProduct() {
        return null;
    }

}
