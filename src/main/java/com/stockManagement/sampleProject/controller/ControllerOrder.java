package com.stockManagement.sampleProject.controller;

import com.stockManagement.sampleProject.dto.DtoOrder;
import com.stockManagement.sampleProject.service.ServiceOrder;
import com.stockManagement.sampleProject.utill.StandadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/OrderController")

public class ControllerOrder {

    @Autowired
    private ServiceOrder serviceOrder;

    @PostMapping(path = "/orderSave")
    public ResponseEntity<StandadResponse> saveItem(@RequestBody DtoOrder dtoOrder){

        String id =serviceOrder.addOrder(dtoOrder);

        return new ResponseEntity<StandadResponse>(
                new StandadResponse(201,id+"saved order !",id),
                HttpStatus.CREATED  );

    }
}
