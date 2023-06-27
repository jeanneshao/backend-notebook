package com.jeanne.lowcode.websocket.stomp.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Jeanne 2023/6/27
 **/
@Data
@Builder
public class DemoException {
    private String message;
}
