/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.ShipperFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class ShipperTest {
    
    @Test
    public void testCreate() throws Exception {
        List<Order> orderlist = new ArrayList<Order>();
        Shipper shipper = ShipperFactory
                .createShipper("DHL", 101, orderlist);
        
        Assert.assertEquals("DHL", shipper.getShipperName());
        Assert.assertEquals(101, shipper.getShipperID());
        Assert.assertEquals(orderlist, shipper.getOrder());
    }

    @Test
    public void testUpdate() throws Exception {
        List<Order> orderlist = new ArrayList<Order>();
        Shipper shipper = ShipperFactory
                .createShipper("DHL", 101, orderlist);
        
        Shipper newShipper = new Shipper
                .Builder(103)
                .ShipperName("FedEx")
                .Order(orderlist)
                .build();
                
        Assert.assertEquals("DHL", shipper.getShipperName());
        Assert.assertEquals("FedEx", newShipper.getShipperName());
        Assert.assertEquals(101, shipper.getShipperID());
        Assert.assertEquals(103, newShipper.getShipperID());
        Assert.assertEquals(orderlist, shipper.getOrder());
        Assert.assertEquals(orderlist, newShipper.getOrder());

    }
}
