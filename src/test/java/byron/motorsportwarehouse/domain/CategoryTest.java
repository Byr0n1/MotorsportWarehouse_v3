/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import byron.motorsportwarehouse.conf.factory.CategoryFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CategoryTest {
    
    @Test
    public void testCreate() throws Exception {
        List <CarPart> carPart = new ArrayList<CarPart>();
        Category cat = CategoryFactory
                .createCategory("Diffusers", carPart);
        
        Assert.assertEquals("Diffusers", cat.getCatName());
    }

    @Test
    public void testUpdate() throws Exception {
        List <CarPart> carPart = new ArrayList<CarPart>();
        
        Category cat = CategoryFactory
                .createCategory("Diffusers", carPart);
        
        Category newCategory = new Category
                .Builder("Bumpers")
                .CarPart(carPart)
                .build();
        
        Assert.assertEquals("Diffusers", cat.getCatName());
        Assert.assertEquals(carPart, cat.getCarPart());
        Assert.assertEquals("Bumpers", newCategory.getCatName());
        Assert.assertEquals(carPart, newCategory.getCarPart());
                


    }
}
