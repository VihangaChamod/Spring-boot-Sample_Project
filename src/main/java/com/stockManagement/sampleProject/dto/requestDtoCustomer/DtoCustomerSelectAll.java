package com.stockManagement.sampleProject.dto.requestDtoCustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoCustomerSelectAll {
        private int customerId;
        private String customerName;
        private String customerNic;
        private String customerAddres;
        private ArrayList customer_Mobiles;
        private boolean customerStatus;
}
