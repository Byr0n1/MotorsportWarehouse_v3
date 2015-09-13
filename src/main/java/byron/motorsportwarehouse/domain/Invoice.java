/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


/**
 *
 * @author Byron
 */
@Entity
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String status;
    private int itemQty;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;
    
    @OneToOne
    private Order order;

    public Invoice() {
    }
    
    private Invoice (Builder build){
        this.id = build.id;
        this.status = build.status;
        this.itemQty = build.itemQty;
        this.dateCreated = build.dateCreated;
        this.order = build.order;
    }
    
    public static class Builder{
        private Long id;
        private String status;
        private int itemQty;
        private Date dateCreated;
        private Order order;
    
        public Builder (Order order){
            this.order = order;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder Status (String status){
            this.status = status;
            return this;
        }
    
        public Builder ItemQty (int itemQty){
            this.itemQty = itemQty;
            return this;
        }
        
        public Builder DateCreated (Date dateCreated){
            this.dateCreated = dateCreated;
            return this;
        }
        
        public Builder Order (Order order){
            this.order = order;
            return this;
        }        
    
        public Builder Invoice (Invoice invoice){
            this.id = invoice.getId();
            this.status = invoice.getStatus();
            this.itemQty = invoice.getItemQty();
            this.dateCreated = invoice.getDateCreated();
            this.order = invoice.getOrder();
            return this;
        }
    
        public Invoice build(){
            return new Invoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public int getItemQty() {
        return itemQty;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public byron.motorsportwarehouse.domain.Order getOrder() {
        return order;
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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
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
