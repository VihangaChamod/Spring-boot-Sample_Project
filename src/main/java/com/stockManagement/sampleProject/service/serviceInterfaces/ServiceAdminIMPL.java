package com.stockManagement.sampleProject.service.serviceInterfaces;

import com.stockManagement.sampleProject.dto.DtoAdmin;
import com.stockManagement.sampleProject.dto.requestDtoAdmin.DtoAdminSingIn;
import com.stockManagement.sampleProject.dto.responseDtoAdmin.DtoAdminSelectAll;

import java.util.List;

public interface ServiceAdminIMPL {
    String saveAdmin(DtoAdmin dtoAdmin);

    int logInAdmin(DtoAdminSingIn dtoAdminSingIn);

    List<DtoAdminSelectAll> GetAllAdmin(boolean status);
}
