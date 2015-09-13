/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import byron.motorsportwarehouse.conf.factory.AddressFactory;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author Byron
 */
public class AddressTest {
    
    @Test
    public void testCreate() throws Exception {
        Address address = AddressFactory
                .createAddress("30", "Long", "Heathfield", "Cape Town", 
                        "South Africa", "7945");
        Assert.assertEquals("30", address.getAddNum());
        Assert.assertEquals("Long", address.getStreet());
        Assert.assertEquals("Heathfield", address.getSuburb());
        Assert.assertEquals("Cape Town", address.getCity());
        Assert.assertEquals("South Africa", address.getCountry());
        Assert.assertEquals("7945", address.getPostalCode());
    }

    @Test
    public void testUpdate() throws Exception {
        
        Address address = AddressFactory
                .createAddress("30", "Long", "Heathfield", "Cape Town", 
                        "South Africa", "7945");
               
        Address newAddress = new Address
                .Builder(address.getStreet())
                .AddNum("56")
                .Suburb("Newlands")
                .City("Durban")
                .Country(address.getCountry())
                .PostalCode(address.getPostalCode())
                .build();
                
        Assert.assertEquals("30", address.getAddNum());
        Assert.assertEquals("Cape Town", address.getCity());
        Assert.assertEquals("56", newAddress.getAddNum());
        Assert.assertEquals("Durban", newAddress.getCity());

    }
}
