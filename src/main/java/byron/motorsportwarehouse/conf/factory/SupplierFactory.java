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
public class SupplierFactory {
    
    public static Supplier createSupplier (String suppName, int suppID, List <CarPart> Carpart){
        Supplier supplier = new Supplier
                .Builder(suppID)
                .SuppName(suppName)
                .CarPart(Carpart)
                .build();
                return supplier;
    }
                
}
    

