/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.SupplierFactory;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.repository.SupplierRepository;
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
public class SupplierTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private SupplierService service;

    private Long id;

    @Autowired
    private SupplierRepository repository;
    
    @BeforeMethod
    public void setUp() throws Exception {
    }
    
    @Test
    public void create() throws Exception {

        List<CarPart> part = new ArrayList<CarPart>();
        Supplier supp = SupplierFactory
                .createSupplier("Global Couriers", 3321, part);
    
        repository.save(supp);
        id=supp.getId();
        Assert.assertNotNull(supp.getId());
    }


    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<Supplier> suppliers = service.findAll();
        Assert.assertTrue(suppliers.size() == 1);

    }
}
