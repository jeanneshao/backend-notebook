package com.example.jpademo.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class DemoLobDemoVO {
    @NotNull(message = "id can not null")
    private Long id;

    private [
    B blobDemo;

    private [
    B longBlobDemo;

    private String longTextDemo;

}
