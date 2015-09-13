/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import java.util.List;
/**
 *
 * @author Byron
 */
public class CategoryFactory {
    
    public static Category createCategory (String catName, List<CarPart> part){
        Category cat = new Category
                .Builder(catName)
                .CarPart(part)
                .build();
                return cat;
    }
                
}
    

