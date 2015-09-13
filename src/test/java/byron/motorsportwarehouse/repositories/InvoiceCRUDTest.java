/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.InvoiceFactory;
import byron.motorsportwarehouse.domain.Invoice;
import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.repository.InvoiceRepository;
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
public class InvoiceCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private InvoiceRepository repository;
    
    @Test
    public void create() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        Invoice inv = InvoiceFactory
                .createInvoice("Approved", 4, null, null);
        repository.save(inv);
        id = inv.getId();
        Assert.assertNotNull(inv);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Invoice inv = repository.findOne(id);
        Assert.assertNotNull(inv);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Invoice inv = repository.findOne(id);
        
        Invoice updatedInv = new Invoice
                .Builder(null)
                .Status("Sent")
                .ItemQty(6)
                .DateCreated(null)
                .Invoice(inv)
                .build();
        
        repository.save(updatedInv);
        Invoice newInv = repository.findOne(id);
        Assert.assertEquals("Sent", newInv.getStatus());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Invoice inv = repository.findOne(id);
        repository.delete(inv);
        Invoice deletedInv = repository.findOne(id);
        Assert.assertNull(deletedInv);
    }
    
}
