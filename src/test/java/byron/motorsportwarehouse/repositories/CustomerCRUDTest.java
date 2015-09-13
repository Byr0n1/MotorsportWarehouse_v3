/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repositories;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.conf.factory.CustomerFactory;
import byron.motorsportwarehouse.domain.Address;
import byron.motorsportwarehouse.domain.CreditCard;
import byron.motorsportwarehouse.domain.CustContact;
import byron.motorsportwarehouse.domain.CustName;
import byron.motorsportwarehouse.domain.Customer;
import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.repository.CustomerRepository;
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
public class CustomerCRUDTest extends AbstractTestNGSpringContextTests{
    
    private long id;
    @Autowired
    private CustomerRepository repository;
    
    @Test
    public void create() throws Exception{
        CustName name = new CustName();
        CustContact cont = new CustContact();
        Address addy = new Address();
        List<CreditCard> cc = new ArrayList<CreditCard>();
        List<Order> order = new ArrayList<Order>();
        Customer cust = CustomerFactory
                .createCustomer(1023, name, cont, addy, cc, order);
                
        repository.save(cust);
        id = cust.getId();
        Assert.assertNotNull(cust);
    }
    
    @Test (dependsOnMethods = "create")
    public void read() throws Exception{
        Customer cust = repository.findOne(id);
        Assert.assertNotNull(cust);
    }
    
    @Test (dependsOnMethods = "read")
    public void update() throws Exception{
        Customer cust = repository.findOne(id);
        
        Customer updatedCust = new Customer
                .Builder(3411)
                .custName(null)
                .custContact(null)
                .address(null)
                .cc(null)
                .orders(null)
                .build();
        
        repository.save(updatedCust);
        Customer newCust = repository.findOne(id);
        Assert.assertEquals(3411, newCust.getCustID());

    }    
    
    @Test (dependsOnMethods = "update")
    public void delete() throws Exception{
        Customer cust = repository.findOne(id);
        repository.delete(cust);
        Customer deletedCust = repository.findOne(id);
        Assert.assertNull(deletedCust);
    }
}
