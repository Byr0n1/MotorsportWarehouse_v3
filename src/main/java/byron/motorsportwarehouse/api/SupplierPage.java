/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.api;

import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.model.SupplierResource;
import byron.motorsportwarehouse.services.SupplierService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Byron
 */

@RestController
@RequestMapping(value="/supplier/**")
public class SupplierPage {
    
    @Autowired
    private SupplierService service;
    
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public List<Supplier> getSuppliers(@PathVariable Long id) {

        return service.findAll();
    }

    @RequestMapping(value="/supplier", method=RequestMethod.GET)

    public List<SupplierResource> getSuppliers() {
        
        List<SupplierResource> hateos = new ArrayList<>();
        List<Supplier> supps = service.findAll();
        for (Supplier supp : supps) {
            SupplierResource res = new SupplierResource
                    .Builder(supp.getSuppName())
                    .carpart(supp.getCarparts())
                    .build();
            
            Link carparts = new
                    Link("http://localhost:8080/supplier/"+res.getResid().toString())
                    .withRel("parts_ID");
            res.add(carparts);
            hateos.add(res);
        }
        return hateos;
    }
    
}
