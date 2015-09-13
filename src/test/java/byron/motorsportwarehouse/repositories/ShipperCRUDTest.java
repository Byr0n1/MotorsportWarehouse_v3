/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.ShipperFactory;
import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.domain.Shipper;
import byron.motorsportwarehouse.repository.ShipperRepository;
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
public class ShipperCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private ShipperRepository repository;
    
    @Test
    public void create() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        
        Shipper shipper = ShipperFactory
                .createShipper("UPS", 2110, orders);
                
        repository.save(shipper);
        id = shipper.getId();
        Assert.assertNotNull(shipper);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Shipper shipper = repository.findOne(id);
        Assert.assertNotNull(shipper);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Shipper shipper = repository.findOne(id);
        
        Shipper updatedShipper = new Shipper
                .Builder(5511)
                .ShipperName("Speedy")
                .Order(null)
                .Shipper(shipper)
                .build();
        
        repository.save(updatedShipper);
        Shipper newShipper = repository.findOne(id);
        Assert.assertEquals("Speedy", newShipper.getShipperName());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Shipper shipper = repository.findOne(id);
        repository.delete(shipper);
        Shipper deletedShipper = repository.findOne(id);
        Assert.assertNull(deletedShipper);
    }
    
}
