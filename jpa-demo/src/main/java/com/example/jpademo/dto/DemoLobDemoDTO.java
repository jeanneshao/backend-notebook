package com.example.jpademo.dto;


import lombok.Data;

@Data
public class DemoLobDemoDTO {
    private Long id;

    private byte[] blobDemo;

    private byte[] longBlobDemo;

    private String longTextDemo;

}
