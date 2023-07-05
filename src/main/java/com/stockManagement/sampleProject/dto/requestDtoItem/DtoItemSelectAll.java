package com.stockManagement.sampleProject.dto.requestDtoItem;

import com.stockManagement.sampleProject.entity.enums.MesuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoItemSelectAll {

    private int itemId;
    private String itemName;
    private MesuringUnitType mesuringUnitType;
    private String itemBalanceQty;
    private double itemSuppliarPrice;
    private double itemSellingPrice;
    private boolean itemActiveState;
}
