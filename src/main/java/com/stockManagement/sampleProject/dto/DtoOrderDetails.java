package com.stockManagement.sampleProject.dto;

import com.stockManagement.sampleProject.entity.Items;
import com.stockManagement.sampleProject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class DtoOrderDetails {


    private String itemName;
    private double itemQty;
    private double amount;
    private int items;
    private int orders;
}
