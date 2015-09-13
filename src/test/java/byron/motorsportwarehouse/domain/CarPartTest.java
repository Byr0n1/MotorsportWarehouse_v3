/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.CarPartFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CarPartTest {
    
    @Test
    public void testCreate() throws Exception {
        List <Supplier> supplier = new ArrayList<Supplier>();
                
        CarPart carPart = CarPartFactory
                .createCarPart("6DIF1", "In Stock", 3000, supplier);
        
        Assert.assertEquals("6DIF1", carPart.getPartNum());
    }

    @Test
    public void testUpdate() throws Exception {
        List <Supplier> supplier = new ArrayList<Supplier>();
        
        CarPart carPart = CarPartFactory
                .createCarPart("6DIF1", "In Stock", 3000, supplier);
        
        CarPart newPart = new CarPart
                .Builder("7SPO1")
                .Status("Out of Stock")
                .Price(2500)
                .build();
                
        Assert.assertEquals("6DIF1", carPart.getPartNum());
        Assert.assertEquals("7SPO1", newPart.getPartNum());
        Assert.assertEquals(3000, carPart.getPrice(),0);
        Assert.assertEquals(2500, newPart.getPrice(),0);

    }
}
