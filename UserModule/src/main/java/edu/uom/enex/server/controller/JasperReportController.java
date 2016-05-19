package edu.uom.enex.server.controller;

import edu.uom.enex.server.entity.*;
import edu.uom.enex.server.service.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Himashi Nethinika on 4/7/16.
 */


@Controller
@RequestMapping("enex/order/v1/jasperReport")
public class JasperReportController {


    @Autowired
    private OrderDAOService orderDAOService;

    @Autowired
    private CreditOrderDAOService creditOrderDAOService;

    @Autowired
    private CustomerDAOService customerDAOService;

    @Autowired
    private OrderDetailDAOService orderDetailDAOService;

    @Autowired
    private ProductDAOService productDAOService;


    /**
     * get Customer Invoice
     *
     * @param session
     * @param response
     * @param orderId
     * @param receivedCash
     */
    @RequestMapping(value = "getCustomerInvoice", method = RequestMethod.GET)
    public void getCustomerInvoice(HttpSession session, HttpServletResponse response,
                                   @RequestParam("orderId") String orderId,
                                   @RequestParam("receivedCash") double receivedCash
    ) {


        JRTableModelDataSource ds = null;
        Map<String, Object> map = null;
        map = new HashMap<String, Object>();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        String oId=orderId;
        String[] split = oId.split("-");
        String prefix = split[0];

        model.addColumn("Item Code");
        model.addColumn("Description");
        model.addColumn("Unit Price");
        model.addColumn("Qty");
        model.addColumn("Amount");
        model.addColumn("Amount");

        double total=0.0;

        if(prefix=="CH"){
            Order order=orderDAOService.getOrderById(orderId);
            String issueDate = order.getIssueDate();
            Customer customerByCustomerId = customerDAOService.getCustomerByCustomerId(order.getCustomerId());
            List<OrderDetail> orderDetails = orderDetailDAOService.searchOrderDetail(orderId);
            map.put("ISSUE_DATE",issueDate+"");
            map.put("DUE_DATE","");
            map.put("CUST_NAME",customerByCustomerId.getName()+"");
            map.put("ORDER_ID",orderId+"");

            for (OrderDetail orderDetail : orderDetails) {
                Product product = productDAOService.searchProductById(orderDetail.getProductId());
                model.addRow(new Object[]{product.getpId(), orderDetail.getDescription(), orderDetail.getUnitPrice()+"", orderDetail.getQuantity()+"",orderDetail.getUnitPrice()*orderDetail.getQuantity()+""});
                total+=orderDetail.getUnitPrice()*orderDetail.getQuantity();
            }
            map.put("TOTAL",total+"");
            map.put("RECEIVED_LABEL","Received");
            map.put("RECEIVED",receivedCash+"");
            if(total-receivedCash==0.0 | total-receivedCash>0.0){
                map.put("BALANCE_LABEL","Balance");
                map.put("BALANCE_TEXT",total-receivedCash+"");
            }

        }
        if(prefix=="CR"){
            Order order=orderDAOService.getOrderById(orderId);
            String issueDate = order.getIssueDate();
            CreditOrder creditOrderById = creditOrderDAOService.getCreditOrderById(orderId);
            String dueDate = creditOrderById.getDueDate();
            Customer customerByCustomerId = customerDAOService.getCustomerByCustomerId(order.getCustomerId());
            List<OrderDetail> orderDetails = orderDetailDAOService.searchOrderDetail(orderId);
            map.put("ISSUE_DATE",issueDate+"");
            map.put("DUE_DATE",dueDate+"");

            map.put("CUST_NAME",customerByCustomerId.getName()+"");
            map.put("ORDER_ID",orderId+"");

            for (OrderDetail orderDetail : orderDetails) {
                Product product = productDAOService.searchProductById(orderDetail.getProductId());
                model.addRow(new Object[]{product.getpId(), orderDetail.getDescription(), orderDetail.getUnitPrice()+"", orderDetail.getQuantity()+"",orderDetail.getUnitPrice()*orderDetail.getQuantity()+""});
                total+=orderDetail.getUnitPrice()*orderDetail.getQuantity();
            }
            map.put("TOTAL",total+"");
            map.put("RECEIVED_LABEL","");
            map.put("RECEIVED","");
            if(total-receivedCash==0.0 | total-receivedCash>0.0){
                map.put("BALANCE_LABEL","Credit");
                map.put("BALANCE_TEXT",total+"");
            }
        }

        ds = new JRTableModelDataSource(model);
        try {
            InputStream systemResourceAsStream = this.getClass().getClassLoader().getResourceAsStream("CustomerBill.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(systemResourceAsStream);
            JasperPrint jp = JasperFillManager.fillReport(jr, map, ds);
            // JasperViewer.viewReport(jp, false);
            File pdf = File.createTempFile("output.", ".pdf");
            JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
            try {
                InputStream inputStream = new FileInputStream(pdf);
                response.setContentType("application/pdf");
                SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy");
                response.setHeader("Content-Disposition", "attachment; filename=Invoice.pdf");
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @RequestMapping(value = "getCustomerList", method = RequestMethod.GET)
    public void getCustomerList(HttpSession session, HttpServletResponse response
    ) {

        JRTableModelDataSource ds = null;
        Map<String, Object> map = null;
        map = new HashMap<String, Object>();

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Customer Id");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Region");
        model.addColumn("Contact No");
        model.addColumn("Credit Period");
        model.addColumn("Sales Rep");

        List<IndividualCustomer> allIndividualCustomers = customerDAOService.getAllIndividualCustomers();
        for (IndividualCustomer individualCustomer : allIndividualCustomers) {
            model.addRow(new Object[]{individualCustomer.getCustId(), individualCustomer.getName(), individualCustomer.getAddress(), individualCustomer.getRegion(),individualCustomer.getContactNo(),individualCustomer.getCreditPeriod()+"",individualCustomer.getSalesRepresentative()});
        }

        ds = new JRTableModelDataSource(model);
        try {
            InputStream systemResourceAsStream = this.getClass().getClassLoader().getResourceAsStream("CustomerList.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(systemResourceAsStream);
            JasperPrint jp = JasperFillManager.fillReport(jr, map, ds);
            // JasperViewer.viewReport(jp, false);
            File pdf = File.createTempFile("output.", ".pdf");
            JasperExportManager.exportReportToPdfStream(jp, new FileOutputStream(pdf));
            try {
                InputStream inputStream = new FileInputStream(pdf);
                response.setContentType("application/pdf");
                SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy");
                response.setHeader("Content-Disposition", "attachment; filename=Customer.pdf");
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }




}
