package com.jeanne.lowcode.websocket.sockjs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeanne 2023/6/25
 **/
@Data
@Slf4j
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DemoVo {
    private Long id;
    private String name;
    private String remarks;
}
