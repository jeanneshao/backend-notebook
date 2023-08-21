package com.demo.redis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jeanne 2023/8/20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemoVo implements Serializable, Comparable<DemoVo> {
    private String name;
    private Long id;

    @Override
    public int compareTo(DemoVo o) {
        return this.getId().compareTo(o.getId());
    }
}
