/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.CustomerFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CustomerTest {
    
    @Test
    public void testCreate() throws Exception {
        CustName cname = new CustName();
        CustContact cCont = new CustContact();
        Address addy = new Address();
        List<CreditCard> cc = new ArrayList<CreditCard>();
        List<Order> orderlist = new ArrayList<Order>();
        Customer cust = CustomerFactory
                .createCustomer(1123, cname, cCont, addy, cc, orderlist);
          
        Assert.assertEquals(1123, cust.getCustID());
        Assert.assertEquals(cname, cust.getCustName());
        Assert.assertEquals(cCont, cust.getCustContact());
        Assert.assertEquals(addy, cust.getAddress());
        Assert.assertEquals(cc, cust.getCc());
        Assert.assertEquals(orderlist, cust.getOrder());
        
    }

    @Test
    public void testUpdate() throws Exception {
        CustName cname = new CustName();
        CustContact cCont = new CustContact();
        Address addy = new Address();
        List<CreditCard> cc = new ArrayList<CreditCard>();
        List<Order> orderlist = new ArrayList<Order>();
        Customer cust = CustomerFactory
                .createCustomer(1123, cname, cCont, addy, cc, orderlist);
        
        Customer newCust = new Customer
                .Builder(2345)
                .custName(cname)
                .custContact(cCont)
                .address(addy)
                .cc(cc)
                .orders(orderlist)
                .build();
                
        Assert.assertEquals(1123, cust.getCustID());
        Assert.assertEquals(2345, newCust.getCustID());
        Assert.assertEquals(cname, cust.getCustName());
        Assert.assertEquals(cname, newCust.getCustName());
        Assert.assertEquals(cCont, cust.getCustContact());
        Assert.assertEquals(cCont, newCust.getCustContact());
        Assert.assertEquals(addy, cust.getAddress());
        Assert.assertEquals(addy, newCust.getAddress());
        Assert.assertEquals(cc, cust.getCc());
        Assert.assertEquals(cc, newCust.getCc());
        Assert.assertEquals(orderlist, cust.getOrder());
        Assert.assertEquals(orderlist, newCust.getOrder());
        
        
        
    }
}
