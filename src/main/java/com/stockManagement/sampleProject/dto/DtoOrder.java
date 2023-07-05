package com.stockManagement.sampleProject.dto;

import com.stockManagement.sampleProject.entity.Admin;
import com.stockManagement.sampleProject.entity.Customer;
import com.stockManagement.sampleProject.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoOrder {

    private int admin;
    private int customer;
    private boolean orderActiveState;
    private Date orderDate;
    private double orderTotal;
    private List<DtoOrderDetails> orderDetails;
}
