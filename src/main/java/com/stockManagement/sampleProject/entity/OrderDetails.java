package com.stockManagement.sampleProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {

    @Id
    @Column(name = "orderDetailsId",length = 55)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "itemName",length = 100,nullable = false)
    private String itemName;

    @Column(name = "itemQty",length = 100,nullable = false)
    private double itemQty;

    @Column(name = "amount",length = 100,nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Items items;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order orders;


}
