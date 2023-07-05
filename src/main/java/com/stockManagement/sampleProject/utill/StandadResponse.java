package com.stockManagement.sampleProject.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandadResponse {

    private int code;
    private String message;
    private Object data;
}
