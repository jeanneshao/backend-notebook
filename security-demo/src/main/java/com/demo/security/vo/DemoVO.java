package com.demo.security.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jeanne 2023/7/18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoVO {
    private Long id;
    private String name;
    private int authority;
}
