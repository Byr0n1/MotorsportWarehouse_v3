/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import java.util.List;

/**
 *
 * @author Byron
 */
public interface CarPartService {
     List<Category> getAllCategories();
     List<CarPart> getCarParts(Long id);
    
}
