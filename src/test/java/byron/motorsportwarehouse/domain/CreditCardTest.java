/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;



import byron.motorsportwarehouse.conf.factory.CreditCardFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class CreditCardTest {
    
    @Test
    public void testCreate() throws Exception {
        CreditCard cc = CreditCardFactory
                .createCreditCard("0012", "Valid", "R15000");
        
        Assert.assertEquals("0012", cc.getAccNum());
        Assert.assertEquals("Valid", cc.getStatus());
        Assert.assertEquals("R15000", cc.getBalance());
    }

    @Test
    public void testUpdate() throws Exception {
        CreditCard cc = CreditCardFactory
                .createCreditCard("0012", "Valid", "R15000");
        
        CreditCard newCC = new CreditCard
                .Builder("0123")
                .Status("Suspended")
                .Balance("-10000")
                .build();
                
        Assert.assertEquals("0012", cc.getAccNum());
        Assert.assertEquals("0123", newCC.getAccNum());
        Assert.assertEquals("Valid", cc.getStatus());
        Assert.assertEquals("Suspended", newCC.getStatus());

    }
}
