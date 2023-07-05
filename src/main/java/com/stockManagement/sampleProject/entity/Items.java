package com.stockManagement.sampleProject.entity;

import com.stockManagement.sampleProject.entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Items {

    @Id
    @Column(name = "itemId",length = 55 ,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "itemName",length = 55 ,nullable = false)
    private String itemName;

    @Column(name = "itemType",length = 55 ,nullable = false)
    private MesuringUnitType MesuringUnitType;

    @Column(name = "itemBalanceQty",length = 55 ,nullable = false)
    private String itemBalanceQty;

    @Column(name = "itemSuppliar_price",length = 100,nullable = false)
    private double itemSuppliarPrice;

    @Column(name = "itemSelling_price",length = 100,nullable = true)
    private double itemSellingPrice;

    @Column(name = "itemStatus",columnDefinition = "TINYINT default 1")
    private boolean itemActiveState;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;
}
