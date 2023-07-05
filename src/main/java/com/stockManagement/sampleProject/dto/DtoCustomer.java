package com.stockManagement.sampleProject.dto;

import com.stockManagement.sampleProject.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoCustomer {
    private String customerName;
    private String customerNic;
    private String customerAddres;
    private ArrayList customer_Mobiles;
    private boolean customerStatus;

}
