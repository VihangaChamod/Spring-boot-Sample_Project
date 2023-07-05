package com.stockManagement.sampleProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "admin")

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {

    @Id
    @Column(name = "adminId",length = 55)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    @Column(name = "adminNic",length = 150)
    private String adminNic;

    @Column(name = "adminName",length = 150)
    private String adminName;

    @Column(name = "adminAddres",length = 150)
    private String adminAddres;

    @Column(name = "adminUserName",length = 150)
    private String adminUserName;

    @Column(name = "adminPassword",length = 150)
    private String adminPassword;

    @Column(name = "adminStatus",columnDefinition = "TINYINT default 1")
    private boolean adminActiveState;

    @OneToMany(mappedBy="admin")
    private Set<Order> ordersSet;
}
