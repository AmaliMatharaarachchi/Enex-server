package edu.uom.enex.server.service;

import edu.uom.enex.server.common.Hashids;
import edu.uom.enex.server.common.IdGenerater;
import edu.uom.enex.server.common.RandomString;
import edu.uom.enex.server.dao.ProductDAOController;
import edu.uom.enex.server.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Service
public class ProductDAOService {

    @Autowired
    private ProductDAOController productDAOController;


    public String addProduct(Product product) {
        String productId = new Date().getTime() + "";
        Hashids hashids = new Hashids(productId);
        String hexaid = hashids.encodeHex(String.format("%040x", new BigInteger(1, productId.getBytes())));
        String newid = hexaid + "" + new RandomString().randomString(10);
        product.setProductId(newid);
        String lastPId = getLastPId();
        product.setpId(lastPId);


        return productDAOController.create(product);
    }

    public Product searchProductById(String productId) {
        return productDAOController.read(productId);
    }

    public Product searchProductByName(String productId) {
        return productDAOController.searchProductByName(productId);
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


    private String getLastPId() {
        String id = productDAOController.getLastPId();
        return new IdGenerater().generateId(id, "PI-");
    }

}
