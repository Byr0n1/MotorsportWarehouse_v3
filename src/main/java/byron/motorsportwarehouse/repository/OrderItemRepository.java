/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.repository;

import byron.motorsportwarehouse.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Byron
 */
public interface OrderItemRepository extends CrudRepository <OrderItem, Long>{
    
}
