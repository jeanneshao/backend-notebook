package com.demo.thread.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jeanne 2023/9/4
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoVo {
    private Long id;
    private String name;
}
