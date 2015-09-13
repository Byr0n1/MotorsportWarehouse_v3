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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Byron
 */
@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int orderNum;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateShipped;
    private String custName;
    private int custID;
    private String status;
    
    @OneToOne
    private Invoice invoice;
    
    @OneToOne
    private Customer customer;
    
    @OneToMany
    @JoinColumn(name = "Order_ID")
    private List <OrderItem> orderItem;
    
    public Order() {
    }
    
    private Order (Builder build){
        this.id = build.id;
        this.orderNum = build.orderNum;
        this.orderDate = build.orderDate;
        this.dateShipped = build.dateShipped;
        this.custName = build.custName;
        this.custID = build.custID;
        this.status = build.status;
        this.invoice = build.invoice;
        this.customer = build.customer;
        this.orderItem = build.orderItem;
    }
    
    public static class Builder{
        private Long id;
        private int orderNum;
        private Date orderDate;
        private Date dateShipped;
        private String custName;
        private int custID;
        private String status;
        private Invoice invoice;
        private Customer customer;
        private List <OrderItem> orderItem;
    
        public Builder (int custID){
            this.custID = custID;
        }
    
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        public Builder OrderNum (int orderNum){
            this.orderNum = orderNum;
            return this;
        }
    
        public Builder OrderDate (Date orderDate){
            this.orderDate = orderDate;
            return this;
        }
    
        public Builder DateShipped (Date dateShipped){
            this.dateShipped = dateShipped;
            return this;
        }
    
        public Builder CustName (String custName){
            this.custName = custName;
            return this;
        }
    
        public Builder Status (String status){
            this.status = status;
            return this;
        }
    
        public Builder Invoice (Invoice invoice){
            this.invoice = invoice;
            return this;
        }
        
        public Builder Customer (Customer customer){
            this.customer = customer;
            return this;
        }        
        
        public Builder OrderItem (List<OrderItem> orderItem){
            this.orderItem = orderItem;
            return this;
        }        
    
        public Builder Order (Order order){
            this.id = order.getId();
            this.orderNum = order.getOrderNum();
            this.orderDate = order.getOrderDate();
            this.custID = order.getCustID();
            this.custName = order.getCustName();
            this.customer = order.getCustomer();
            this.dateShipped = order.getDateShipped();
            this.status = order.getStatus();
            this.invoice = order.getInvoice();
            this.orderItem = order.getOrderItem();

            return this;
        }
    
        public Order build(){
            return new Order(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public String getCustName() {
        return custName;
    }

    public int getCustID() {
        return custID;
    }

    public String getStatus() {
        return status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public byron.motorsportwarehouse.domain.Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
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
