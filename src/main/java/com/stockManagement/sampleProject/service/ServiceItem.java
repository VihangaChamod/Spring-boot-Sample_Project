package com.stockManagement.sampleProject.service;

import com.stockManagement.sampleProject.dto.DtoItems;
import com.stockManagement.sampleProject.dto.requestDtoCustomer.DtoCustomerSelectAll;
import com.stockManagement.sampleProject.dto.requestDtoItem.DtoItemSelectAll;
import com.stockManagement.sampleProject.entity.Customer;
import com.stockManagement.sampleProject.entity.Items;
import com.stockManagement.sampleProject.repository.RepoItem;
import com.stockManagement.sampleProject.service.serviceInterfaces.ServiceCustomerIMPL;
import com.stockManagement.sampleProject.service.serviceInterfaces.ServiceItemIMPL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceItem implements ServiceItemIMPL {

    @Autowired
    private RepoItem repoItem;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItems(DtoItems dtoItems) {

        Items items = modelMapper.map(dtoItems, Items.class);

        if (!repoItem.existsById(items.getItemId())){
            repoItem.save(items);
        }else {
            throw new DuplicateKeyException("Id Already Defined!");
        }
        return items.getItemName();


    }

    @Override
    public List<DtoItemSelectAll> GetAllItems(boolean activeStatus) {
        List<Items> itemsList =repoItem.findAllByItemActiveStateEquals(activeStatus);
        List<DtoItemSelectAll> dtoItemSelectAlls= modelMapper.map(itemsList,new TypeToken<List<DtoItemSelectAll>>(){}.getType());
        return dtoItemSelectAlls;
    }

    @Override
    public DtoItemSelectAll GetAllItemsById(boolean activeStatus, int id) {
        Items items =repoItem.findAllByItemActiveStateEqualsAndAndItemIdEquals(activeStatus,id);
        DtoItemSelectAll dtoItemSelectAllsById= modelMapper.map(items,DtoItemSelectAll.class);
        return dtoItemSelectAllsById;
    }
}
