package com.stockManagement.sampleProject.service.serviceInterfaces;

import com.stockManagement.sampleProject.dto.DtoCustomer;
import com.stockManagement.sampleProject.dto.requestDtoCustomer.DtoCustomerSelectAll;

import java.util.List;

public interface ServiceCustomerIMPL {
    String saveCustomer(DtoCustomer dtoCustomer);

    List<DtoCustomerSelectAll> GetAllCustomers(boolean activeStatus);
}
