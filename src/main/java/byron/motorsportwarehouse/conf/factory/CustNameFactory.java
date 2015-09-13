/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.CustName;
/**
 *
 * @author Byron
 */
public class CustNameFactory {
    
    public static CustName createCustName (String name, String surname){
        CustName custName = new CustName
                .Builder(name)
                .Surname(surname)
                .build();
                return custName;
    }
                
}
    

