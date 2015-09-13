/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CustContact;
/**
 *
 * @author Byron
 */
public class CustContactFactory {
    
    public static CustContact createCustContact (String phoneNumber){
        CustContact custContact = new CustContact
                .Builder(phoneNumber)
                .build();
                return custContact;
    }
                
}
    

