package edu.uom.enex.server.service;

import edu.uom.enex.server.dao.ProductDAOController;
import edu.uom.enex.server.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Service
public class ProductDAOService {

    @Autowired
    private ProductDAOController productDAOController;


    public String addProduct(Product product) {
        String proId = new Date().getTime() + "";
        product.setProductId(proId);
        return productDAOController.create(product);
    }

    public Product searchProduct(String productId) {
        return productDAOController.read(productId);
    }

    public String updateProduct(Product product) {
        return productDAOController.update(product);
    }

    public int deleteProduct(Product product) {
        return productDAOController.archive(product);
    }

    public ArrayList<Product> getAvailableProducts() {
        return productDAOController.getAvailableProducts();
    }

    public List<Product> getAllProducts() {
        return productDAOController.getAll();
    }

    public List<Product> getSelectedProducts(Date from, Date to) {
        return productDAOController.getSelectedProducts(from, to);
    }

    public int decreaseItemQtyOnHand(String productId, double qty) {
        return productDAOController.decreaseItemQtyOnHand(productId, qty);
    }

    public int increaseQtyOnHand(String itemCode, double qty) {
        return productDAOController.decreaseItemQtyOnHand(itemCode, qty);
    }

    public int updateCost(String productId, double price) {
        return productDAOController.updateCost(productId, price);
    }

    public ArrayList<Product> searchLowQtyProduct() {
        return productDAOController.searchLowQtyProduct();
    }

}
