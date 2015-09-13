/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.OrderFactory;
import byron.motorsportwarehouse.domain.Customer;
import byron.motorsportwarehouse.domain.Invoice;
import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Byron
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrderCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private OrderRepository repository;
    
    @Test
    public void create() throws Exception{
        Invoice inv = new Invoice();
        Customer cust = new Customer();
        List<Order> orderlist = new ArrayList<Order>();
        
        Order order = OrderFactory
                .createOrder(1001, null, null, "Memphis", 2001, "Delivered", inv, cust, null);
        
        repository.save(order);
        id = order.getId();
        Assert.assertNotNull(order);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Order order = repository.findOne(id);
        Assert.assertNotNull(order);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Order order = repository.findOne(id);
        
        Order updatedOrder = new Order
                .Builder(2111)
                .OrderNum(3216)
                .OrderDate(null)
                .DateShipped(null)
                .CustName("Yaya")
                .Status("Purchased")
                .Invoice(null)
                .Customer(null)
                .OrderItem(null)                
                .Order(order)
                .build();
        
        repository.save(updatedOrder);
        Order newOrder = repository.findOne(id);
        Assert.assertEquals("Yaya", newOrder.getCustName());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Order order = repository.findOne(id);
        repository.delete(order);
        Order deletedOrder = repository.findOne(id);
        Assert.assertNull(deletedOrder);
    }
    
}
