package com.stockManagement.sampleProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoAdmin {

    private String adminNic;
    private String adminName;
    private String adminAddres;
    private String adminUserName;
    private String adminPassword;
    private boolean adminActiveState;

}
