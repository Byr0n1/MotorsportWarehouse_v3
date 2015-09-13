/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.OrderFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class OrderTest {
    
    @Test
    public void testCreate() throws Exception {
        Invoice inv = new Invoice();
        Customer cust = new Customer();
        List<OrderItem> item = new ArrayList<OrderItem>();
        Order order = OrderFactory
                .createOrder(3214, null, null, "Johnny", 4351, "Shipped", inv, cust, item);
        
        Assert.assertEquals(3214, order.getOrderNum());
        Assert.assertEquals(null, order.getOrderDate());
        Assert.assertEquals(null, order.getDateShipped());
        Assert.assertEquals("Johnny", order.getCustName());
        Assert.assertEquals(4351, order.getCustID());
        Assert.assertEquals("Shipped", order.getStatus());
        Assert.assertEquals(inv, order.getInvoice());
        Assert.assertEquals(cust, order.getCustomer());
        Assert.assertEquals(item, order.getOrderItem());
        
    }

    @Test
    public void testUpdate() throws Exception {
        Invoice inv = new Invoice();
        Customer cust = new Customer();
        List<OrderItem> item = new ArrayList<OrderItem>();
        Order order = OrderFactory
                .createOrder(3214, null, null, "Johnny", 4351, "Shipped", inv, cust, item);
        
        Order newOrder = new Order
                .Builder(4121)
                .OrderNum(4311)
                .OrderDate(null)
                .DateShipped(null)
                .CustName("Bobby")
                .Status("Awaiting Payment")
                .Invoice(inv)
                .Customer(cust)
                .OrderItem(item)
                .build();
                
        Assert.assertEquals(3214, order.getOrderNum());
        Assert.assertEquals(4311, newOrder.getOrderNum());
        Assert.assertEquals(null, order.getOrderDate());
        Assert.assertEquals(null, newOrder.getOrderDate());
        Assert.assertEquals(null, order.getDateShipped());
        Assert.assertEquals(null, newOrder.getDateShipped());
        Assert.assertEquals("Johnny", order.getCustName());
        Assert.assertEquals("Bobby", newOrder.getCustName());
        Assert.assertEquals(4351, order.getCustID());
        Assert.assertEquals(4121, newOrder.getCustID());
        Assert.assertEquals("Shipped", order.getStatus());
        Assert.assertEquals("Awaiting Payment", newOrder.getStatus());
        Assert.assertEquals(inv, order.getInvoice());
        Assert.assertEquals(inv, newOrder.getInvoice());
        Assert.assertEquals(cust, order.getCustomer());
        Assert.assertEquals(cust, newOrder.getCustomer());
        Assert.assertEquals(item, order.getOrderItem());
        Assert.assertEquals(item, newOrder.getOrderItem());

    }
}
