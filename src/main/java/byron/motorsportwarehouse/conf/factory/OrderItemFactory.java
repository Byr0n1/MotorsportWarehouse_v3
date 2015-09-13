/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.OrderItem;
import java.util.List;
/**
 *
 * @author Byron
 */
public class OrderItemFactory {
    
    public static OrderItem createOrderItem (int qty, List <CarPart> carPart){
        OrderItem orderItem = new OrderItem
                .Builder(qty)
                .CarPart(carPart)
                .build();
                return orderItem;
    }
                
}
    

