package com.stockManagement.sampleProject.controller;

import com.stockManagement.sampleProject.dto.DtoAdmin;
import com.stockManagement.sampleProject.dto.requestDtoAdmin.DtoAdminSingIn;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;
import com.stockManagement.sampleProject.service.ServiceAdmin;
import com.stockManagement.sampleProject.utill.StandadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/AdminController")

public class ControllerAdmin {

    @Autowired
    private ServiceAdmin serviceAdmin;

    @PostMapping(path = "/adminSave")
    public ResponseEntity<StandadResponse> saveAdmin(@RequestBody DtoAdmin dtoAdmin){
        String name = serviceAdmin.saveAdmin(dtoAdmin);
        return new ResponseEntity<StandadResponse>(new StandadResponse(200,name+" Saved Succesful ! ",name), HttpStatus.OK);
    }

    @PostMapping(path = "/adminLogin")
    public ResponseEntity<StandadResponse> logInAdmin(@RequestBody DtoAdminSingIn dtoAdminSingIn){
       int id = serviceAdmin.logInAdmin(dtoAdminSingIn);
        return new ResponseEntity<StandadResponse>(new StandadResponse(200,"Welcome To Inventry System !",id), HttpStatus.OK);
    }

    @GetMapping(path = "GetAllAdmin")

    public ResponseEntity<StandadResponse> getItemBYActiveStatus(@RequestParam(value = "activeStatus") boolean activeStatus){
        List<DtoAdminSelectAll> adminDtos = serviceAdmin.GetAllAdmin(activeStatus);
        return new ResponseEntity<StandadResponse>(
                new StandadResponse(200,"succes ! ",adminDtos),
                HttpStatus.OK
        );
    }


}
