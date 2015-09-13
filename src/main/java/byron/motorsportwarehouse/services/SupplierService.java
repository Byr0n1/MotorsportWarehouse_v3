/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.services;

import byron.motorsportwarehouse.domain.Supplier;
import java.util.List;

/**
 *
 * @author Byron
 */
public interface SupplierService {
    List<Supplier> findAll();    
}
