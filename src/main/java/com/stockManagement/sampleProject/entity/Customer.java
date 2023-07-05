package com.stockManagement.sampleProject.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")

@NoArgsConstructor
@AllArgsConstructor
@Data

@TypeDefs({@TypeDef(name = "json",typeClass = JsonType.class)})

public class Customer {

    @Id
    @Column(name = "customerId",length = 55)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customerName",length = 100)
    private String customerName;

    @Column(name = "customerNic",length = 100)
    private String customerNic;

    @Column(name = "customerAddres",length = 100)
    private String customerAddres;

    @Type(type = "json")
    @Column(name = "customerMobiles",columnDefinition = "json")
    private ArrayList customer_Mobiles;

    @Column(name = "customerStatus",columnDefinition = "TINYINT default 1")
    private boolean customerStatus;

    @OneToMany(mappedBy="customer")
    private Set<Order> ordersSet;
}
