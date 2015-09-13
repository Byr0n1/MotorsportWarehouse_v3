/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;


import byron.motorsportwarehouse.conf.factory.CustNameFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CustNameTest {
    
    @Test
    public void testCreate() throws Exception {
        CustName name = CustNameFactory
                .createCustName("Robin", "Hood");
        
        Assert.assertEquals("Robin", name.getName());
        Assert.assertEquals("Hood", name.getSurname());
    }

    @Test
    public void testUpdate() throws Exception {
        CustName name = CustNameFactory
                .createCustName("Robin", "Hood");
        
        CustName newName = new CustName
                .Builder("Peter")
                .Surname("Pan")
                .build();
                
        Assert.assertEquals("Robin", name.getName());
        Assert.assertEquals("Peter", newName.getName());
        Assert.assertEquals("Hood", name.getSurname());
        Assert.assertEquals("Pan", newName.getSurname());        

    }
}
