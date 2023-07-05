package com.stockManagement.sampleProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    public Order(Admin admin, Customer customer, boolean orderActiveState, Date orderDate, double orderTotal) {
        this.admin = admin;
        this.customer = customer;
        this.orderActiveState = orderActiveState;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    @Id
    @Column(name = "orderId",length = 55)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "adminId", nullable = false)
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @Column(name = "orderstatus",columnDefinition = "TINYINT default 0")
    private boolean orderActiveState;

    @Column(name = "orderDate",columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "orderTotal",nullable = false)
    private double orderTotal;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;
}
