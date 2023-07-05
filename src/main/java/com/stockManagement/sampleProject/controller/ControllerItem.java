package com.stockManagement.sampleProject.controller;


import com.stockManagement.sampleProject.dto.DtoCustomer;
import com.stockManagement.sampleProject.dto.DtoItems;
import com.stockManagement.sampleProject.dto.requestDtoItem.DtoItemSelectAll;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;
import com.stockManagement.sampleProject.service.ServiceItem;
import com.stockManagement.sampleProject.utill.StandadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/ItemController")

public class ControllerItem {

    @Autowired
    private ServiceItem serviceItem;

    @PostMapping(path = "/itemSave")
    public ResponseEntity<StandadResponse> saveItem(@RequestBody DtoItems dtoItems){
        String name = serviceItem.saveItems(dtoItems);
        return new ResponseEntity<StandadResponse>(new StandadResponse(200,name+" Saved Succesful ! ",name), HttpStatus.OK);
    }
    @GetMapping(path = "/GetAllItem")

    public ResponseEntity<StandadResponse> getItemBYActiveStatus(@RequestParam(value = "activeStatus") boolean activeStatus){
        List<DtoItemSelectAll> dtoItemSelectAlls = serviceItem.GetAllItems(activeStatus);
        return new ResponseEntity<StandadResponse>(
                new StandadResponse(200,"succes ! ",dtoItemSelectAlls),
                HttpStatus.OK);}
    @GetMapping(path = "/GetAllItemById")

    public ResponseEntity<StandadResponse> getItemBYActiveStatusAndId(
            @RequestParam(value = "activeStatus")boolean activeStatus,
            @RequestParam(value = "ItemId")int id)
    {
       DtoItemSelectAll dtoItemSelectAllById = serviceItem.GetAllItemsById(activeStatus,id);
        return new ResponseEntity<StandadResponse>(
                new StandadResponse(200,"succes ! ",dtoItemSelectAllById),
                HttpStatus.OK
        );
    }
}
