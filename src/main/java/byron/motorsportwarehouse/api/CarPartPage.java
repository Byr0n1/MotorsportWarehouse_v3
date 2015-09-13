/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.api;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import byron.motorsportwarehouse.model.CategoryResource;
import byron.motorsportwarehouse.services.CarPartService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Byron
 */

@RestController
@RequestMapping(value="/category/**")
public class CarPartPage {
    @Autowired
    private CarPartService service;
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<CarPart> getFacultyDepartments(@PathVariable Long id) {

        
        return service.getCarParts(id);
    }

    @RequestMapping(value="/categories", method=RequestMethod.GET)

    public List<CategoryResource> getCategories() {
        List<CategoryResource> hateos = new ArrayList<>();
        List<Category> categories = service.getAllCategories();
        for (Category cat : categories) {
            CategoryResource res = new CategoryResource
                    .Builder(cat.getCatName())
                    .carpart(cat.getCarPart())
                    .resid(cat.getId())
                    .build();
            
            Link carparts = new
                    Link("http://localhost:8080/category/"+res.getResid().toString())
                    .withRel("parts");
            res.add(carparts);
            hateos.add(res);
        }
        return hateos;
    }
    
}
