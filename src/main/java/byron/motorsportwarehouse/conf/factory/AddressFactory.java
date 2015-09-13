/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.Address;
/**
 *
 * @author Byron
 */
public class AddressFactory {
    
    public static Address createAddress (String addNum, String street, 
            String suburb, String city, String country, String postalCode){
        Address address = new Address
                .Builder(street)
                .AddNum(addNum)
                .Suburb(suburb)
                .City(city)
                .Country(country)
                .PostalCode(postalCode)
                .build();
                return address;
    }
                
}
    

