/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.model;

import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Byron
 */
public class SupplierResource extends ResourceSupport{

    private Long resid;
    private String name;
    
    //private ContactAddress address;

    private List<Supplier> suppliers;
    private List<CarPart> carparts;

    public SupplierResource() {
    }

    public Long getResid() {
        return resid;
    }

    public String getName() {
        return name;
    }

    public List<CarPart> getCarparts() {
        return carparts;
    }
    
    public SupplierResource(Builder builder) {
        this.suppliers =builder.suppliers;
        this.resid=builder.resid;
        this.name=builder.name;
    }
    
    public static class Builder{
        private Long resid;
        private String name;
        private List<Supplier> suppliers;
        private List<CarPart> carparts;

        public Builder(String name) {
            this.name = name;
        }

        public Builder resid(Long value){
            this.resid=value;
            return this;
        }

        public Builder carpart(List<CarPart> value){
            this.carparts=value;
            return this;
        }

        public Builder copy(SupplierResource value){
            this.suppliers = value.suppliers;
            this.carparts = value.carparts;
            this.resid=value.resid;
            this.name=value.name;
            return this;
        }

        public SupplierResource build(){
            return new SupplierResource(this);
        }
    }
}
