/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.Invoice;
import byron.motorsportwarehouse.domain.Order;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Byron
 */
public class InvoiceFactory {
    
    public static Invoice createInvoice (String status, int itemQty, 
            Date dateCreated, Order order){
        Invoice invoice = new Invoice
                .Builder(order)
                .Status(status)
                .ItemQty(itemQty)
                .DateCreated(dateCreated)
                .build();
                return invoice;
    }
                
}
    

