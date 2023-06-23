package com.jeanne.lowcode.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jeanne 2023/6/22
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelAttributeDemoVo {
    private long id;
    private String name;
    private String type;



}
