/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Byron
 */
@Entity
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String accNum;
    private String status;
    private String balance;

    public CreditCard() {
    }
    
    private CreditCard (Builder build){
        this.id = build.id;
        this.accNum = build.accNum;
        this.status = build.status;
        this.balance = build.balance;
    }
    
    public static class Builder{
        private Long id;
        private String accNum;
        private String status;
        private String balance;
    
        public Builder (String accNum){
            this.accNum = accNum;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder Status (String status){
            this.status = status;
            return this;
        }
    
        public Builder Balance (String balance){
            this.balance = balance;
            return this;
        }
    
        public Builder CreditCard (CreditCard creditCard){
            this.id = creditCard.getId();
            this.accNum = creditCard.getAccNum();
            this.status = creditCard.getStatus();
            this.balance = creditCard.getBalance();
            return this;
        }
    
        public CreditCard build(){
            return new CreditCard(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getStatus() {
        return status;
    }

    public String getBalance() {
        return balance;
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
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
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
