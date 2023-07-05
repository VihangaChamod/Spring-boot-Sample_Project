package com.stockManagement.sampleProject.service.serviceInterfaces;

import com.stockManagement.sampleProject.dto.DtoItems;
import com.stockManagement.sampleProject.dto.requestDtoItem.DtoItemSelectAll;

import java.util.List;

public interface ServiceItemIMPL {
    String saveItems(DtoItems dtoItems);

    List<DtoItemSelectAll> GetAllItems(boolean activeStatus);

    DtoItemSelectAll GetAllItemsById(boolean activeStatus, int id);
}
