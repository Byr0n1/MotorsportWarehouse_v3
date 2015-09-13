/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CreditCard;
/**
 *
 * @author Byron
 */
public class CreditCardFactory {
    
    public static CreditCard createCreditCard (String accNum, String status, 
            String balance){
        CreditCard cc = new CreditCard
                .Builder(accNum)
                .Status(status)
                .Balance(balance)
                .build();
                return cc;
    }
                
}
    

