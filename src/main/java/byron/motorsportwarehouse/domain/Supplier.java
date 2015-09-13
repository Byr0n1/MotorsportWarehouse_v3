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
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String suppName;
    private int suppID;
    
    @OneToMany
    @JoinColumn(name = "Supplier_ID")
    private List <CarPart> carparts;
    

    public Supplier() {
    }
    
    private Supplier (Builder build){
        this.id = build.id;
        this.suppName = build.suppName;
        this.suppID = build.suppID;
        this.carparts = build.carparts;
    }
    
    public static class Builder{
        private Long id;
        private String suppName;
        private int suppID;
        private List <CarPart> carparts;
    
        public Builder (int suppID){
            this.suppID = suppID;
        }
    
        public Builder Id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder SuppName (String suppName){
            this.suppName = suppName;
            return this;
        }
        
        public Builder CarPart (List<CarPart> carparts){
            this.carparts = carparts;
            return this;
        }
    
        public Builder Supplier (Supplier supplier){
            this.id = supplier.getId();
            this.suppID = supplier.getSuppID();
            this.suppName = supplier.getSuppName();
            this.carparts = supplier.getCarparts();
            return this;
        }
    
        public Supplier build(){
            return new Supplier(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSuppName() {
        return suppName;
    }

    public int getSuppID() {
        return suppID;
    }

    public List<CarPart> getCarparts() {
        return carparts;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
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
