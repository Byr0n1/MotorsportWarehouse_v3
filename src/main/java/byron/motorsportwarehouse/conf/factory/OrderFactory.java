/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.conf.factory;

import byron.motorsportwarehouse.domain.Customer;
import byron.motorsportwarehouse.domain.Invoice;
import byron.motorsportwarehouse.domain.Order;
import byron.motorsportwarehouse.domain.OrderItem;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Byron
 */
public class OrderFactory {
    
    public static Order createOrder (int orderNum, Date orderDate, Date dateShipped,
         String custName, int custID, String status, Invoice invoice, Customer customer,
         List <OrderItem> orderItem){
        Order order = new Order
                .Builder(custID)
                .OrderNum(orderNum)
                .OrderDate(orderDate)
                .DateShipped(dateShipped)
                .CustName(custName)
                .Status(status)
                .Invoice(invoice)
                .Customer(customer)
                .OrderItem(orderItem)
                .build();
                return order;
    }
                
}
    

