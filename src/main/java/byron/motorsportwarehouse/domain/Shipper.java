/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



/**
 *
 * @author Byron
 */
@Entity
public class Shipper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String shipperName;
    private int shipperID;
    
    @OneToMany
    @JoinColumn(name = "Shipper_ID")
    private List <Order> order;

    public Shipper() {
    }
    
    private Shipper (Builder build){
        this.id = build.id;
        this.shipperName = build.shipperName;
        this.shipperID = build.shipperID;
        this.order = build.order;
    }
    
    public static class Builder{
        private Long id;
        private String shipperName;
        private int shipperID;
        private List <Order> order;
    
        public Builder (int shipperID){
            this.shipperID = shipperID;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder ShipperName (String shipperName){
            this.shipperName = shipperName;
            return this;
        }
        
        public Builder Order (List <Order> order){
            this.order = order;
            return this;
        }
    
        public Builder Shipper (Shipper shipper){
            this.id = shipper.getId();
            this.shipperName = shipper.getShipperName();
            this.shipperID = shipper.getShipperID();
            this.order = shipper.getOrder();
            return this;
        }
    
        public Shipper build(){
            return new Shipper(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getShipperName() {
        return shipperName;
    }

    public int getShipperID() {
        return shipperID;
    }

    public List<byron.motorsportwarehouse.domain.Order> getOrder() {
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
        if (!(object instanceof Shipper)) {
            return false;
        }
        Shipper other = (Shipper) object;
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
