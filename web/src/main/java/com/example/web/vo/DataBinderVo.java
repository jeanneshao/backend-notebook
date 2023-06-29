package com.example.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Jeanne 2023/6/22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataBinderVo {
    private Long id;
    private String name;
    private Date creationDate;
}
