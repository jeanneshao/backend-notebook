package com.example.jpademo.vo;


import lombok.Data;

@Data
public class DemoLobDemoQueryVO {
    private Long id;

    private  byte[]  blobDemo;

    private  byte[]  longBlobDemo;

    private String longTextDemo;

}
