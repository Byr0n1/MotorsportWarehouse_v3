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
import javax.persistence.OneToOne;


/**
 *
 * @author Byron
 */
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String catName;
    
    @OneToMany
    @JoinColumn(name="Cat_id")
    private List <CarPart> carPart;
    
    public Category() {
    }
    
    private Category (Builder build){
        this.id = build.id;
        this.catName = build.catName;
        this.carPart = build.carPart;
    }
    
    public static class Builder{
        private Long id;
        private String catName;
        private List <CarPart> carPart;
    
        public Builder (String catName){
            this.catName = catName;
        }
    
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder CarPart (List<CarPart> carPart){
            this.carPart = carPart;
            return this;
        }     
    
        public Builder Category (Category category){
            this.id = category.getId();
            this.catName = category.getCatName();
            this.carPart = category.getCarPart();
            return this;
        }
    
        public Category build(){
            return new Category(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getCatName() {
        return catName;
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
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
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
