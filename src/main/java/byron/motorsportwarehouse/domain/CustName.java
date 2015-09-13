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
public class CustName implements Serializable {
    
    private String name;
    private String surname;

    public CustName() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public CustName (Builder builder)
    {
        this.name = builder.name;
        this.surname = builder.surname;
    }
    
    public static class Builder{
        
        private String name;
        private String surname;
        
        public Builder(String name){ 
            this.name = name;
        }
        
        public Builder Surname (String value){ 
            this.surname = value;
            return this;
        }
        
        public Builder CustName (CustName value){
            this.name = value.getName();
            this.surname = value.getSurname();
            return this;
        }
        
        public CustName build(){
            return new CustName(this);
        }
    }
  
}
