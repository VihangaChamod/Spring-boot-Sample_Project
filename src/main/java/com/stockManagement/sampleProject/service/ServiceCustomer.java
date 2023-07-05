package com.stockManagement.sampleProject.service;

import com.stockManagement.sampleProject.dto.DtoCustomer;
import com.stockManagement.sampleProject.dto.requestDtoCustomer.DtoCustomerSelectAll;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;
import com.stockManagement.sampleProject.entity.Admin;
import com.stockManagement.sampleProject.entity.Customer;
import com.stockManagement.sampleProject.repository.RepoAdmin;
import com.stockManagement.sampleProject.repository.RepoCustomer;
import com.stockManagement.sampleProject.service.serviceInterfaces.ServiceCustomerIMPL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCustomer implements ServiceCustomerIMPL {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RepoCustomer repoCustomer;

    @Override
    public String saveCustomer(DtoCustomer dtoCustomer) {

        Customer customer = modelMapper.map(dtoCustomer, Customer.class);

        if (!repoCustomer.existsById(customer.getCustomerId())){
            repoCustomer.save(customer);
        }else {
            throw new DuplicateKeyException("Id Already Defined!");
        }
        return customer.getCustomerName();
    }

    @Override
    public List<DtoCustomerSelectAll> GetAllCustomers(boolean activeStatus) {
        List<Customer> customerList =repoCustomer.findAllByCustomerStatusEquals(activeStatus);
        List<DtoCustomerSelectAll> dtoCustomerSelectAlls= modelMapper.map(customerList,new TypeToken<List<DtoCustomerSelectAll>>(){}.getType());
        return dtoCustomerSelectAlls;
    }
}
