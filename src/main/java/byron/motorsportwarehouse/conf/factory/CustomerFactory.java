/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.Address;
import byron.motorsportwarehouse.domain.CreditCard;
import byron.motorsportwarehouse.domain.CustContact;
import byron.motorsportwarehouse.domain.CustName;
import byron.motorsportwarehouse.domain.Customer;
import byron.motorsportwarehouse.domain.Order;
import java.util.List;


/**
 *
 * @author Byron
 */
public class CustomerFactory {
    
    public static Customer createCustomer (int custID, 
            CustName custName, CustContact custContact, Address address, 
            List <CreditCard> cc, List <Order> orders){
        
        Customer cust = new Customer
                .Builder(custID)
                .custName(custName)
                .custContact(custContact)
                .address(address)
                .cc(cc)
                .orders(orders)
                .build();
                return cust;
    }
                
}
    

