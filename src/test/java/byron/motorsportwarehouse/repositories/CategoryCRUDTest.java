/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.CategoryFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import byron.motorsportwarehouse.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Byron
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CategoryCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private CategoryRepository repository;
    
    @Test
    public void create() throws Exception{
        List<CarPart> part = new ArrayList<CarPart>();
        Category cat = CategoryFactory
                .createCategory("Interior", part);
        repository.save(cat);
        id = cat.getId();
        Assert.assertNotNull(cat);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Category cat = repository.findOne(id);
        Assert.assertNotNull(cat);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Category cat = repository.findOne(id);
        
        Category updatedCat = new Category
                .Builder("Exterior")
                .CarPart(null)
                .Category(cat)
                .build();
        
        repository.save(updatedCat);
        Category newCat = repository.findOne(id);
        Assert.assertEquals("Exterior", newCat.getCatName());
    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Category cat = repository.findOne(id);
        repository.delete(cat);
        Category deletedCat = repository.findOne(id);
        Assert.assertNull(deletedCat);
    }        
}
