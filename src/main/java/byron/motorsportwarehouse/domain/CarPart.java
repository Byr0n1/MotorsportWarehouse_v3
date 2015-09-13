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
public class CarPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String partNum;
    private String status;
    private double price;
    
    @OneToMany
    @JoinColumn(name = "Car_Part_ID")
    private List <Supplier> supplier;

    public CarPart() {
    }
    
    private CarPart (Builder build){
        this.id = build.id;
        this.partNum = build.partNum;
        this.status = build.status;
        this.price = build.price;
        this.supplier = build.supplier;
    }
    
    public static class Builder{
        private Long id;
        private String partNum;
        private String status;
        private double price;
        private List <Supplier> supplier;
        
    
        public Builder (String partNum){
            this.partNum = partNum;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder Status (String status){
            this.status = status;
            return this;
        }
    
        public Builder Price (double price){
            this.price = price;
            return this;
        }
        
        public Builder Supplier (List<Supplier> supp){
            this.supplier = supp;
            return this;
        }        
        
        public Builder CarPart (CarPart carPart){
            this.id = carPart.getId();
            this.partNum = carPart.getPartNum();
            this.status = carPart.getStatus();
            this.price = carPart.getPrice();
            this.supplier = carPart.getSupplier();
            return this;
        }
    
        public CarPart build(){
            return new CarPart(this);
        }

        /*public Object Supplier(List<Supplier> supplier) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }*/
    }

    public Long getId() {
        return id;
    }

    public String getPartNum() {
        return partNum;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public List<Supplier> getSupplier() {
        return supplier;
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
        if (!(object instanceof CarPart)) {
            return false;
        }
        CarPart other = (CarPart) object;
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
