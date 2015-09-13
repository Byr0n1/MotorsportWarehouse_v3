/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.OrderItemFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class OrderItemTest {
    
    @Test
    public void testCreate() throws Exception {
        List<CarPart> part = new ArrayList<CarPart>();
        OrderItem ordItem = OrderItemFactory
                .createOrderItem(2, part);

        Assert.assertEquals(2, ordItem.getQty());
        Assert.assertEquals(part, ordItem.getCarPart());
    }

    @Test
    public void testUpdate() throws Exception {
        List<CarPart> part = new ArrayList<CarPart>();
        OrderItem ordItem = OrderItemFactory
                .createOrderItem(2, part);
        
        OrderItem newItem = new OrderItem
                .Builder(3)
                .CarPart(part)
                .build();
                
        Assert.assertEquals(2, ordItem.getQty());
        Assert.assertEquals(3, newItem.getQty());
        Assert.assertEquals(part, ordItem.getCarPart());
        Assert.assertEquals(part, newItem.getCarPart());
        
    }
}
