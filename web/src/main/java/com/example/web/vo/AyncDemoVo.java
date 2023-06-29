package com.example.web.vo;

import lombok.Data;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Jeanne 2023/6/23
 **/
@Data
public class AyncDemoVo {

    DeferredResult<String> deferredResult = new DeferredResult<>();
}
