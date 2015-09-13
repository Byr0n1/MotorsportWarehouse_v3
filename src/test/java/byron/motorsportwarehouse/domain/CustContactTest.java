/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.CustContactFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CustContactTest {
    
    @Test
    public void testCreate() throws Exception {
        CustContact cont  =CustContactFactory
                .createCustContact("0722112233");
        
        Assert.assertEquals("0722112233", cont.getPhoneNumber());
    }

    @Test
    public void testUpdate() throws Exception {
        CustContact cont  =CustContactFactory
                .createCustContact("0722112233");
        
        CustContact newCont = new CustContact
                .Builder("0821234321")
                .build();
                
        Assert.assertEquals("0722112233", cont.getPhoneNumber());
        Assert.assertEquals("0821234321", newCont.getPhoneNumber());
    }
}
