package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoLobDemoVO {
    @NotNull(message = "id can not null")
    private Long id;

    private  byte[] blobDemo;

    private  byte[] longBlobDemo;

    private String longTextDemo;

}
