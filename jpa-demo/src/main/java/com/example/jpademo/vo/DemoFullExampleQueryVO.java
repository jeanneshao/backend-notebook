package com.example.jpademo.vo;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class DemoFullExampleQueryVO {

    /**
     * 自增主键
     */
    private Long id;


    /**
     * 关联实体
     */
    private Long oneToOneResource;


    /**
     * 时分
     */
    private LocalTime timeExample;


    /**
     * 时分秒
     */
    private LocalTime timeSecondExample;


    /**
     * 时间段-起始-时分秒
     */
    private LocalTime timeRangeBegin;


    /**
     * 时间段-结束-时分秒
     */
    private LocalTime timeRangeEnd;


    /**
     * 日期段-起始-年月
     */
    private LocalDate monthRangeBegin;


    /**
     * 日期段-结束-年月
     */
    private LocalDate monthRangeEnd;


    /**
     * 日期段-起始-年月日
     */
    private LocalDate dateRangeBegin;


    /**
     * 日期段-结束-年月日
     */
    private LocalDate dateRangeEnd;


    /**
     * 日期段-起始-年月日时分秒
     */
    private LocalDateTime datetimeRangeBegin;


    /**
     * 日期段-结束-年月日时分秒
     */
    private LocalDateTime datetimeRangeEnd;


    /**
     * 年
     */
    private LocalDateTime dateYearExample;


    /**
     * 年月
     */
    private LocalDateTime dateMonthExample;


    /**
     * 年月日
     */
    private LocalDateTime dateExample;


    /**
     * 年月日时分秒
     */
    private LocalDateTime dateTimeExample;


    /**
     * 数字
     */
    private Long numberExample;


    /**
     * 小数
     */
    private BigDecimal doubleExample;


    /**
     * 横向多选框
     */
    private String checkboxOptionGroup;


    /**
     * 横向多选框
     */
    private String cogWithEnumOptions;


    /**
     * 横向多选框
     */
    private String cogWithBackendOptions;


    /**
     * 横向单选框
     */
    private Long radioOptionGroup;


    /**
     * 横向单选框
     */
    private Long rogWithEnumOptions;


    /**
     * 横向单选框
     */
    private Long rogWithBackendOptions;


    /**
     * 输入框
     */
    private String inputExample;


    /**
     * 邮箱
     */
    private String emailExample;


    /**
     * 输入框
     */
    private String name;


    /**
     * 下拉框-固定选项
     */
    private Long selectWithFixedOptions;


    /**
     * 下拉框-查枚举选项
     */
    private Long selectWithEnumOptions;


    /**
     * 下拉框-查接口选项
     */
    private Long selectWithBackendOptions;


    /**
     * 级联下拉框-固定选项
     */
    private String cascadeWithFixedOptions;


    /**
     * 级联下拉框-查枚举选项
     */
    private String cascadeWithBackendOptions;


    /**
     * 级联下拉框-查接口选项
     */
    private String cascadeWithEnumOptions;


    /**
     * 级联下拉框-多选-固定选项
     */
    private String cascademultiWithFixedOptions;


    /**
     * 级联下拉框-多选-查枚举选项
     */
    private String cascademultiWithBackendOptions;


    /**
     * 级联下拉框-多选-查接口选项
     */
    private String cascademultiWithEnumOptions;


    /**
     * 图片上传
     */
    private String imageUploadExample;


    /**
     * 文件上传
     */
    private String fileUploadExample;


    /**
     * 多个文件上传
     */
    private String multiFileExample;


    /**
     * 勾选框
     */
    private Integer checkboxExample;


    /**
     * 多行输入
     */
    private String textAreaExample;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
