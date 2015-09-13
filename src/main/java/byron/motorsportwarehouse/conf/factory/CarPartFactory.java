/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import java.util.List;
/**
 *
 * @author Byron
 */
public class CarPartFactory {
    
    public static CarPart createCarPart (String partNum, String status, 
            double price, List <Supplier> supplier){
        CarPart carPart = new CarPart
                .Builder(partNum)
                .Status(status)
                .Price(price)
                .Supplier(supplier)
                .build();
                return carPart;
    }
                
}
    

