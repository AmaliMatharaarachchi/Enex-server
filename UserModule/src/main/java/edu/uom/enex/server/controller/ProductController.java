package edu.uom.enex.server.controller;


import edu.uom.enex.server.entity.Product;
import edu.uom.enex.server.service.ProductDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Himashi Nethinika on 4/3/2016.
 */
@Controller
@RequestMapping("enex/product")
public class ProductController {

    @Autowired
    private ProductDAOService productDAOService;

    @RequestMapping(value = "ob", method = RequestMethod.GET)
    @ResponseBody
    public Product ob() {
        return new Product();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage addProduct(@RequestBody Product product) {
        String res = productDAOService.addProduct(product);
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;
        } else {
            responseMessage = ResponseMessage.DANGER;
        }
        responseMessage.setData(res);
        return responseMessage;
    }

    @RequestMapping(value = "search", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Product searchProduct(@RequestBody String productId) {
        return productDAOService.searchProductById(productId);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateProduct(@RequestBody Product product) {
        String res = productDAOService.updateProduct(product);
        ResponseMessage responseMessage;
        if (res != null) {
            responseMessage = ResponseMessage.SUCCESS;

        } else {
            responseMessage = ResponseMessage.DANGER;

        }
        responseMessage.setData(res);
        return responseMessage;

    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage deleteProduct(@RequestBody Product product) {
        int res = productDAOService.deleteProduct(product);
        ResponseMessage responseMessage;
        if (res != 1) {
            responseMessage = ResponseMessage.SUCCESS;

        } else {
            responseMessage = ResponseMessage.DANGER;

        }
        responseMessage.setData(res);
        return responseMessage;
    }

    @RequestMapping(value = "getAvailable", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<Product> getAvailableProducts() {
        return productDAOService.getAvailableProducts();
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productDAOService.getAllProducts();
    }

    @RequestMapping(value = "getSelected", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public List<Product> getSelectedProducts(@RequestBody Date from, @RequestBody Date to) {
        return productDAOService.getSelectedProducts(from, to);
    }

    @RequestMapping(value = "decreaseQOH", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage decreaseItemQtyOnHand(@RequestBody String productId, double qty) {
        int res = productDAOService.decreaseItemQtyOnHand(productId, qty);
        ResponseMessage responseMessage;
        if (res != 1) {
            responseMessage = ResponseMessage.SUCCESS;

        } else {
            responseMessage = ResponseMessage.DANGER;

        }
        responseMessage.setData(res);
        return responseMessage;
    }

    @RequestMapping(value = "increaseQtyOnHand", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage increaseQtyOnHand(@RequestBody String itemCode, @RequestBody double qty) {
        int res = productDAOService.decreaseItemQtyOnHand(itemCode, qty);
        ResponseMessage responseMessage;
        if (res != 1) {
            responseMessage = ResponseMessage.SUCCESS;

        } else {
            responseMessage = ResponseMessage.DANGER;
        }
        responseMessage.setData(res);
        return responseMessage;
    }

    @RequestMapping(value = "updateCost", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ResponseMessage updateCost(String productId, double price) {
        int res = productDAOService.updateCost(productId, price);
        ResponseMessage responseMessage;
        if (res != 1) {
            responseMessage = ResponseMessage.SUCCESS;

        } else {
            responseMessage = ResponseMessage.DANGER;

        }
        responseMessage.setData(res);
        return responseMessage;
    }

    @RequestMapping(value = "searchLowQtyProduct", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ArrayList<Product> searchLowQtyProduct() {
        return productDAOService.searchLowQtyProduct();
    }

}
