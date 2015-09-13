/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services.Impl;

import byron.motorsportwarehouse.domain.Supplier;
import byron.motorsportwarehouse.repository.SupplierRepository;
import byron.motorsportwarehouse.services.SupplierService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Byron
 */

@Service
public class SupplierImpl implements SupplierService {

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> findAll() {
        List<Supplier> allsupps = new ArrayList<>();
        Iterable<Supplier> supps = repository.findAll();
        for (Supplier supp : supps) {
            allsupps.add(supp);
        }
        return allsupps;
}
}
