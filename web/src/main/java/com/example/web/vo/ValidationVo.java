package com.example.web.vo;

import com.example.web.validations.small.Small;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Jeanne 2023/6/21
 **/
@Data
public class ValidationVo {

    private String defaultMessage;

    @Small(30)
    private long id;

    @NotBlank(message = "赛事不能为空")
    private String matchEventName; // 赛事名称

//    @NotBlank(message = "发枪时间不能为空")
//    @Pattern(regexp = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$", message = "发枪格式错误")
    private String gunTime; // 发枪时间

    @NotNull(message = "国家ID不能为空")
    @Min(value = 0,message = "国家ID数据格式错误")
    private int dicCountryId; // 国家ID

    @NotBlank(message = "国家名称不能为空")
    private String countryName; // 国家名称

    @NotNull(message = "省份ID不能为空")
    @Min(value = 0,message = "省份ID数据格式错误")
    private int dicProvinceId; // 省份ID
    @NotBlank(message = "省份名称不能为空")
    private String provinceName; // 省份名称

    @NotNull(message = "城市ID不能为空")
    @Min(value = 0,message = "城市ID数据格式错误")
    private int dicCityId; // 城市ID
    @NotBlank(message = "城市名称不能为空")
    private String cityName; // 城市名称

}
