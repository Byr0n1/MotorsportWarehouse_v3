/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.SupplierFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.repository.SupplierRepository;
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
public class SupplierCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private SupplierRepository repository;
    
    @Test
    public void create() throws Exception{
        List<CarPart> part = new ArrayList<CarPart>();
        
        Supplier supp = SupplierFactory
                .createSupplier("Mods R Us", 9811, part);
        repository.save(supp);
        id = supp.getId();
        Assert.assertNotNull(supp);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Supplier supp = repository.findOne(id);
        Assert.assertNotNull(supp);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Supplier supp = repository.findOne(id);
        
        Supplier updatedSupp = new Supplier
                .Builder(7833)
                .SuppName("Parts4U")
                .CarPart(null)
                .Supplier(supp)
                .build();
        
        repository.save(updatedSupp);
        Supplier newdSupp = repository.findOne(id);
        Assert.assertEquals("Parts4U", newdSupp.getSuppName());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Supplier supp = repository.findOne(id);
        repository.delete(supp);
        Supplier deletedSupp = repository.findOne(id);
        Assert.assertNull(deletedSupp);
    }
}
