/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.InvoiceFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class InvoiceTest {
    
    @Test
    public void testCreate() throws Exception {
        Order order = new Order();
        Invoice inv = InvoiceFactory
                .createInvoice("Delivered", 2, null, order);
        
        Assert.assertEquals("Delivered", inv.getStatus());
        Assert.assertEquals(2, inv.getItemQty());
        Assert.assertEquals(null, inv.getDateCreated());
        Assert.assertEquals(order, inv.getOrder());
    }

    @Test
    public void testUpdate() throws Exception {
        Order order = new Order();
        Invoice inv = InvoiceFactory
                .createInvoice("Delivered", 2, null, order);
        
        Invoice newInv = new Invoice
                .Builder(order)
                .Status("En Route")
                .ItemQty(5)
                .DateCreated(null)
                .build();
                
        Assert.assertEquals("Delivered", inv.getStatus());
        Assert.assertEquals("En Route", newInv.getStatus());
        Assert.assertEquals(2, inv.getItemQty());
        Assert.assertEquals(5, newInv.getItemQty());
        Assert.assertEquals(null, inv.getDateCreated());
        Assert.assertEquals(null, newInv.getDateCreated());
        Assert.assertEquals(order, inv.getOrder());
        Assert.assertEquals(order, newInv.getOrder());

    }
}
