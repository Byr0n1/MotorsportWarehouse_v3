/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Byron
 */
@Embeddable
public class Address {
    
    private String addNum;
    private String street;
    private String suburb;
    private String city;
    private String country;
    private String postalCode;

    public Address() {
    }
    
    private Address (Builder build){
        
        this.addNum = build.addNum;
        this.street = build.street;
        this.suburb = build.suburb;
        this.city = build.city;
        this.country = build.country;
        this.postalCode = build.postalCode;
    }
    
    public static class Builder{
        private Long id;
        private String addNum;
        private String street;
        private String suburb;
        private String city;
        private String country;
        private String postalCode;
    
        public Builder (String street){
            this.street = street;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder AddNum (String addNum){
            this.addNum = addNum;
            return this;
        }
    
        public Builder Suburb (String suburb){
            this.suburb = suburb;
            return this;
        }
    
        public Builder City (String city){
            this.city = city;
            return this;
        }
    
        public Builder Country (String country){
            this.country = country;
            return this;
        }
    
        public Builder PostalCode (String postalCode){
            this.postalCode = postalCode;
            return this;
        }
    
        public Builder Address (Address address){
            this.addNum = address.getAddNum();
            this.street = address.getStreet();
            this.suburb = address.getSuburb();
            this.city = address.getCity();
            this.country = address.getCountry();
            this.postalCode = address.getPostalCode();
            return this;
        }
    
        public Address build(){
            return new Address(this);
        }
    }

    

    public String getAddNum() {
        return addNum;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }
    
}
