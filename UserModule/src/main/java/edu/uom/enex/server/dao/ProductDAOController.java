package edu.uom.enex.server.dao;

import edu.uom.enex.server.entity.Product;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
public interface ProductDAOController extends DAOController<Product, String> {

    ArrayList<Product> getAvailableProducts();

    ArrayList<Product> getSelectedProducts(Date from, Date to);

    int decreaseItemQtyOnHand(String productId, double qty);

    int increaseQtyOnHand(String itemCode, double qty);

    int updateCost(String productId, double price);

    ArrayList<Product> searchLowQtyProduct();

}
