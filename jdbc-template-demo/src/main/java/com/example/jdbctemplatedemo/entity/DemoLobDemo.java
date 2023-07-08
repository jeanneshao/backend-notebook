package com.example.jdbctemplatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DemoLobDemo {


    private Long id;

    private byte[] blobDemo;

    private byte[] longBlobDemo;

    private String longTextDemo;

}
