/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Byron
 */
@Embeddable
public class CustContact implements Serializable {
    
    private String phoneNumber;

    public CustContact() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustContact (Builder builder)
    {
        this.phoneNumber = builder.phoneNumber;
    }
    
    public static class Builder{
        
        private String phoneNumber;
        
        public Builder(String phoneNumber){ 
            this.phoneNumber = phoneNumber;
        }
        
        public Builder CustName (CustContact value){
            this.phoneNumber = value.getPhoneNumber();
            return this;
        }
        
        public CustContact build(){
            return new CustContact(this);
        }
    }
  
}
