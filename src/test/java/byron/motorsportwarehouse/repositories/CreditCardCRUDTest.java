/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.CreditCardFactory;
import byron.motorsportwarehouse.domain.CreditCard;
import byron.motorsportwarehouse.repository.CreditCardRepository;
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
public class CreditCardCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private CreditCardRepository repository;
    
    @Test
    public void create() throws Exception{
        CreditCard cc = CreditCardFactory
                .createCreditCard("543122", "Available", "20000");
        repository.save(cc);
        id = cc.getId();
        Assert.assertNotNull(cc);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        CreditCard cc = repository.findOne(id);
        Assert.assertNotNull(cc);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        CreditCard cc = repository.findOne(id);
        
        CreditCard updatedCC = new CreditCard
                .Builder("321431")
                .Status("Suspended")
                .Balance("-2800")
                .build();
        
        repository.save(updatedCC);
        CreditCard newCC = repository.findOne(id);
        Assert.assertEquals("321431", newCC.getAccNum());
    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        CreditCard cc = repository.findOne(id);
        repository.delete(cc);
        CreditCard deletedCC = repository.findOne(id);
        Assert.assertNull(deletedCC);
    }
}
