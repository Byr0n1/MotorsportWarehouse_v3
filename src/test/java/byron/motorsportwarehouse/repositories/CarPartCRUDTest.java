/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.CarPartFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.repository.CarPartRepository;
import byron.motorsportwarehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CarPartCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private CarPartRepository repository;
    
    @Autowired
    SupplierRepository repositorySup;
    
    
    @Test
    public void create() throws Exception {
        
        Supplier supplier1 = new Supplier.Builder(123)
                .SuppName("John")
                .build();
        
        repositorySup.save(supplier1);
        
        Supplier supplier2 = new Supplier.Builder(123345)
                .SuppName("AT Parts")
                .build();
        
         repositorySup.save(supplier2);
        
        List<Supplier> supp = new ArrayList<>();
        
        supp.add(supplier1);
        supp.add(supplier2);
        
        
        CarPart part = CarPartFactory
                .createCarPart("3212", "In Stock", 5000, supp);
        
        repository.save(part);
        id = part.getId();
        Assert.assertNotNull(part);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        CarPart part = repository.findOne(id);
        Assert.assertNotNull(part);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        CarPart part = repository.findOne(id);
        
        CarPart updatedPart = new CarPart
                .Builder("1121")
                .Status("Available")
                .Price(2000)
                .Supplier(null)
                .CarPart(part)
                .build();
        
        repository.save(updatedPart);
        CarPart newPart = repository.findOne(id);
        Assert.assertEquals("Available", newPart.getStatus());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        CarPart part = repository.findOne(id);
        repository.delete(part);
        CarPart deletedPart = repository.findOne(id);
        Assert.assertNull(deletedPart);
    }
    
}
