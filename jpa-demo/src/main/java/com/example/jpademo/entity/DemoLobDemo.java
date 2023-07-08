package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.lob_demo")
public class DemoLobDemo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blob_demo")
    private byte[] blobDemo;

    @Column(name = "long_blob_demo")
    private byte[] longBlobDemo;

    @Column(name = "long_text_demo")
    private String longTextDemo;

}
