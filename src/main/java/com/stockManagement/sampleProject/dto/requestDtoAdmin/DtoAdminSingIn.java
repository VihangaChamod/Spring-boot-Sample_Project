package com.stockManagement.sampleProject.dto.requestDtoAdmin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoAdminSingIn {

    private String adminUserName;
    private String adminPassword;

}
