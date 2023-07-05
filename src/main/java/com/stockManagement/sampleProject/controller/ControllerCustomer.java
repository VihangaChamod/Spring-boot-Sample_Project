package com.stockManagement.sampleProject.controller;

import com.stockManagement.sampleProject.dto.DtoCustomer;
import com.stockManagement.sampleProject.dto.requestDtoCustomer.DtoCustomerSelectAll;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;
import com.stockManagement.sampleProject.service.ServiceCustomer;
import com.stockManagement.sampleProject.utill.StandadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/CustomerController")

public class ControllerCustomer {

    @Autowired
    private ServiceCustomer serviceCustomer;

    @PostMapping(path = "/customerSave")
    public ResponseEntity<StandadResponse> saveCustomer(@RequestBody DtoCustomer dtoCustomer){
        String name = serviceCustomer.saveCustomer(dtoCustomer);
        return new ResponseEntity<StandadResponse>(new StandadResponse(200,name+" Saved Succesful ! ",name), HttpStatus.OK);
    }

    @GetMapping(path = "GetAllCustomers")

    public ResponseEntity<StandadResponse> getItemBYActiveStatus(@RequestParam(value = "activeStatus") boolean activeStatus){
        List<DtoCustomerSelectAll> getAllCustomers = serviceCustomer.GetAllCustomers(activeStatus);
        return new ResponseEntity<StandadResponse>(
                new StandadResponse(200,"succes ! ",getAllCustomers),
                HttpStatus.OK
        );
    }
}
