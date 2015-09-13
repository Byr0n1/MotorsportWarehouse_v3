/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.SupplierFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class SupplierTest {
    
    @Test
    public void testCreate() throws Exception {
        List<CarPart> parts = new ArrayList<CarPart>();
        Supplier supp = SupplierFactory
                .createSupplier("Seibon", 201, parts);
        
        Assert.assertEquals("Seibon", supp.getSuppName());
        Assert.assertEquals(201, supp.getSuppID());
        Assert.assertEquals(parts, supp.getCarparts());
    }

    @Test
    public void testUpdate() throws Exception {
        List<CarPart> parts = new ArrayList<CarPart>();
        Supplier supp = SupplierFactory
                .createSupplier("Seibon", 201, parts);
        
        Supplier newSupp = new Supplier
                .Builder(204)
                .SuppName("Racers Supplies")
                .CarPart(parts)
                .build();
                
        Assert.assertEquals("Seibon", supp.getSuppName());
        Assert.assertEquals("Racers Supplies", newSupp.getSuppName());
        Assert.assertEquals(201, supp.getSuppID());
        Assert.assertEquals(204, newSupp.getSuppID());
        Assert.assertEquals(parts, supp.getCarparts());
        Assert.assertEquals(parts, newSupp.getCarparts());

    }
}
