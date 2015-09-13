/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Byron
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int custID;
    
    @Embedded
    private CustName custName;
    
    @Embedded
    private CustContact custContact;
    
    @Embedded
    private Address address;
    
    @OneToMany
    @JoinColumn(name = "Customer_ID")
    private List <CreditCard> cc;
    
    @OneToMany
    @JoinColumn(name = "Customer_ID")
    private List <Order> orders;
    
    public Customer() {
    }
    
    private Customer (Builder build){
        this.id = build.id;
        this.custID = build.custID;
        this.custName = build.custName;
        this.custContact = build.custContact;
        this.address = build.address;
        this.cc = build.cc;
        this.orders = build.orders;   
    }
    
    public static class Builder{
        private Long id;
        private int custID;
        private CustName custName;
        private CustContact custContact;
        private Address address;
        private List <CreditCard> cc;
        private List <Order> orders;
    
        public Builder (int custID){
            this.custID = custID;
        }
    
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
    
        public Builder custName (CustName custName){
            this.custName = custName;
            return this;
        }
    
        public Builder custContact (CustContact custContact){
            this.custContact = custContact;
            return this;
        }
    
        public Builder address (Address address){
            this.address = address;
            return this;
        }
    
        public Builder cc (List<CreditCard> cc){
            this.cc = cc;
            return this;
        }
    
        public Builder orders (List<Order> orders){
            this.orders = orders;
            return this;
        }
    
        public Builder Customer (Customer customer){
            this.id = customer.getId();
            this.custID = customer.getCustID();
            this.custName = customer.getCustName();
            this.custContact = customer.getCustContact();
            this.address = customer.getAddress();
            this.cc = customer.getCc();
            this.orders = customer.getOrder();
            return this;
        }
    
        public Customer build(){
            return new Customer(this);
        }
    }

    public int getCustID() {
        return custID;
    }

    public Long getId() {
        return id;
    }

    public CustName getCustName() {
        return custName;
    }

    public CustContact getCustContact() {
        return custContact;
    }

    public Address getAddress() {
        return address;
    }

    public List<CreditCard> getCc() {
        return cc;
    }

    public List<Order> getOrder() {
        return orders;
    }
    
    

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "byron.motorsportwarehouse.domain.Customer[ id=" + id + " ]";
    }
    
}
