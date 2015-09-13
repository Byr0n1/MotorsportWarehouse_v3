/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.CarPartFactory;
import byron.motorsportwarehouse.conf.factory.CategoryFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Category;
import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.repository.CarPartRepository;
import byron.motorsportwarehouse.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Byron
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CarPartServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private CarPartService service;

    private Long id;

    @Autowired
    private CategoryRepository repository;
    private List<CarPart> carparts;
    
    @BeforeMethod
    public void setUp() throws Exception {
        carparts = new ArrayList<CarPart>();
    }
    
    @Test
    public void create() throws Exception {

        List<Supplier> supp = new ArrayList<Supplier>();
        
        CarPart diffuser = CarPartFactory
                .createCarPart("3433", "In Stock", 2500, supp);
                
        CarPart wheels = CarPartFactory
                .createCarPart("3467", "On Order", 8000, supp);
                
        carparts.add(diffuser);
        carparts.add(wheels);

        Category cat = CategoryFactory
                .createCategory("Exterior", carparts);

        repository.save(cat);
        id=cat.getId();
        Assert.assertNotNull(cat.getId());
    }


    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<CarPart> carparts= service.getCarParts(id);
        Assert.assertTrue(carparts.size() == 2);

    }
}
