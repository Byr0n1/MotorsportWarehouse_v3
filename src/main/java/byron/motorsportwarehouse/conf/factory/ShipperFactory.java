/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.domain.Shipper;
import java.util.List;
/**
 *
 * @author Byron
 */
public class ShipperFactory {
    
    public static Shipper createShipper (String shipperName, int shipperID,
        List <Order> order){
        Shipper shipper = new Shipper
                .Builder(shipperID)
                .ShipperName(shipperName)
                .Order(order)
                .build();
                return shipper;
    }
                
}
    

