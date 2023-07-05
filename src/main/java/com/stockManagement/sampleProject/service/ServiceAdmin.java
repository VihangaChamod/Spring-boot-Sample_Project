package com.stockManagement.sampleProject.service;

import com.stockManagement.sampleProject.dto.DtoAdmin;
import com.stockManagement.sampleProject.dto.requestDtoAdmin.DtoAdminSingIn;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;
import com.stockManagement.sampleProject.entity.Admin;
import com.stockManagement.sampleProject.repository.RepoAdmin;
import com.stockManagement.sampleProject.service.serviceInterfaces.ServiceAdminIMPL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAdmin implements ServiceAdminIMPL {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RepoAdmin repoAdmin;



    @Override
    public String saveAdmin(DtoAdmin dtoAdmin) {

       Admin admin = modelMapper.map(dtoAdmin, Admin.class);

       if (!repoAdmin.existsById(admin.getAdminId())){
           repoAdmin.save(admin);
       }else {
           throw new DuplicateKeyException("Id Already Defined!");
       }
        return admin.getAdminName();
    }

    @Override
    public int logInAdmin(DtoAdminSingIn dtoAdminSingIn) {

        Admin admin = modelMapper.map(dtoAdminSingIn,Admin.class);
//        DtoAdmin dtoAdmin = modelMapper.map(adminDetails,DtoAdmin.class);

        if (repoAdmin.findAllByAdminUserNameAndAdminPasswordEquals(admin.getAdminUserName(),admin.getAdminPassword())!=null){
            Admin adminDetails = repoAdmin.findAllByAdminUserNameAndAdminPasswordEquals(admin.getAdminUserName(),admin.getAdminPassword());
            return adminDetails.getAdminId();
        }
        return 0;
  }

    @Override
    public List<DtoAdminSelectAll> GetAllAdmin(boolean status) {

        List<Admin> adminAll= repoAdmin.findAllByAdminActiveStateEquals(status);
        List<DtoAdminSelectAll> dtoAdminAll= modelMapper.map(adminAll,new TypeToken<List<DtoAdminSelectAll>>(){}.getType());
        return dtoAdminAll;
    }
}
