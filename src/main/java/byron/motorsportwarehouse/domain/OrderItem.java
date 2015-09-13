/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.domain;

import java.io.Serializable;
import java.util.Date;
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
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int qty;
    
    @OneToMany
    @JoinColumn(name = "Order_Item_ID")
    private List <CarPart> carPart;
    
    public OrderItem() {
    }
    
    private OrderItem (Builder build){
        this.id = build.id;
        this.qty = build.qty;
        this.carPart = build.carPart;
    }
    
    public static class Builder{
        private Long id;
        private int qty;
        private List <CarPart> carPart;
    
        public Builder (int qty){
            this.qty = qty;
        }
    
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder CarPart (List<CarPart> carPart){
            this.carPart = carPart;
            return this;
        }     
    
        public Builder OrderItem (OrderItem orderItem){
            this.id = orderItem.getId();
            this.qty = orderItem.getQty();
            this.carPart = orderItem.getCarPart();
            return this;
        }
    
        public OrderItem build(){
            return new OrderItem(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQty() {
        return qty;
    }

    public List<CarPart> getCarPart() {
        return carPart;
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
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
