/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.OrderItemFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.OrderItem;
import byron.motorsportwarehouse.repository.OrderItemRepository;
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
public class OrderItemCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private OrderItemRepository repository;
    
    @Test
    public void create() throws Exception{
        List<CarPart> part = new ArrayList<CarPart>();
        
        OrderItem ordItem = OrderItemFactory
                .createOrderItem(6, part);
        repository.save(ordItem);
        id = ordItem.getId();
        Assert.assertNotNull(ordItem);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        OrderItem ordItem = repository.findOne(id);
        Assert.assertNotNull(ordItem);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        OrderItem ordItem = repository.findOne(id);
        
        OrderItem updatedOrdItem = new OrderItem
                .Builder(8)
                .CarPart(null)
                .OrderItem(ordItem)
                .build();
        
        repository.save(updatedOrdItem);
        OrderItem newOrdItem = repository.findOne(id);
        Assert.assertEquals("8", newOrdItem.getQty());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        OrderItem ordItem = repository.findOne(id);
        repository.delete(ordItem);
        OrderItem deletedItem = repository.findOne(id);
        Assert.assertNull(deletedItem);
    }
}
