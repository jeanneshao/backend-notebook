package com.example.jpademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * entry resource
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "low_code_demo.full_example")
public class DemoFullExample {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 关联实体
     */
    @Column(name = "one_to_one_resource")
    private Long oneToOneResource;

    /**
     * 时分
     */
    @Column(name = "time_example")
    private LocalTime timeExample;

    /**
     * 时分秒
     */
    @Column(name = "time_second_example")
    private LocalTime timeSecondExample;

    /**
     * 时间段-起始-时分秒
     */
    @Column(name = "time_range_begin")
    private LocalTime timeRangeBegin;

    /**
     * 时间段-结束-时分秒
     */
    @Column(name = "time_range_end")
    private LocalTime timeRangeEnd;

    /**
     * 日期段-起始-年月
     */
    @Column(name = "month_range_begin")
    private LocalDate monthRangeBegin;

    /**
     * 日期段-结束-年月
     */
    @Column(name = "month_range_end")
    private LocalDate monthRangeEnd;

    /**
     * 日期段-起始-年月日
     */
    @Column(name = "date_range_begin")
    private LocalDate dateRangeBegin;

    /**
     * 日期段-结束-年月日
     */
    @Column(name = "date_range_end")
    private LocalDate dateRangeEnd;

    /**
     * 日期段-起始-年月日时分秒
     */
    @Column(name = "datetime_range_begin")
    private LocalDateTime datetimeRangeBegin;

    /**
     * 日期段-结束-年月日时分秒
     */
    @Column(name = "datetime_range_end")
    private LocalDateTime datetimeRangeEnd;

    /**
     * 年
     */
    @Column(name = "date_year_example")
    private LocalDateTime dateYearExample;

    /**
     * 年月
     */
    @Column(name = "date_month_example")
    private LocalDateTime dateMonthExample;

    /**
     * 年月日
     */
    @Column(name = "date_example")
    private LocalDateTime dateExample;

    /**
     * 年月日时分秒
     */
    @Column(name = "date_time_example")
    private LocalDateTime dateTimeExample;

    /**
     * 数字
     */
    @Column(name = "number_example")
    private Long numberExample;

    /**
     * 小数
     */
    @Column(name = "double_example")
    private BigDecimal doubleExample;

    /**
     * 横向多选框
     */
    @Column(name = "checkbox_option_group")
    private String checkboxOptionGroup;

    /**
     * 横向多选框
     */
    @Column(name = "cog_with_enum_options")
    private String cogWithEnumOptions;

    /**
     * 横向多选框
     */
    @Column(name = "cog_with_backend_options")
    private String cogWithBackendOptions;

    /**
     * 横向单选框
     */
    @Column(name = "radio_option_group")
    private Long radioOptionGroup;

    /**
     * 横向单选框
     */
    @Column(name = "rog_with_enum_options")
    private Long rogWithEnumOptions;

    /**
     * 横向单选框
     */
    @Column(name = "rog_with_backend_options")
    private Long rogWithBackendOptions;

    /**
     * 输入框
     */
    @Column(name = "input_example")
    private String inputExample;

    /**
     * 邮箱
     */
    @Column(name = "email_example")
    private String emailExample;

    /**
     * 输入框
     */
    @Column(name = "name")
    private String name;

    /**
     * 下拉框-固定选项
     */
    @Column(name = "select_with_fixed_options")
    private Long selectWithFixedOptions;

    /**
     * 下拉框-查枚举选项
     */
    @Column(name = "select_with_enum_options")
    private Long selectWithEnumOptions;

    /**
     * 下拉框-查接口选项
     */
    @Column(name = "select_with_backend_options")
    private Long selectWithBackendOptions;

    /**
     * 级联下拉框-固定选项
     */
    @Column(name = "cascade_with_fixed_options")
    private String cascadeWithFixedOptions;

    /**
     * 级联下拉框-查枚举选项
     */
    @Column(name = "cascade_with_backend_options")
    private String cascadeWithBackendOptions;

    /**
     * 级联下拉框-查接口选项
     */
    @Column(name = "cascade_with_enum_options")
    private String cascadeWithEnumOptions;

    /**
     * 级联下拉框-多选-固定选项
     */
    @Column(name = "cascadeMulti_with_fixed_options")
    private String cascademultiWithFixedOptions;

    /**
     * 级联下拉框-多选-查枚举选项
     */
    @Column(name = "cascadeMulti_with_backend_options")
    private String cascademultiWithBackendOptions;

    /**
     * 级联下拉框-多选-查接口选项
     */
    @Column(name = "cascadeMulti_with_enum_options")
    private String cascademultiWithEnumOptions;

    /**
     * 图片上传
     */
    @Column(name = "image_upload_example")
    private String imageUploadExample;

    /**
     * 文件上传
     */
    @Column(name = "file_upload_example")
    private String fileUploadExample;

    /**
     * 多个文件上传
     */
    @Column(name = "multi_file_example")
    private String multiFileExample;

    /**
     * 勾选框
     */
    @Column(name = "checkbox_example")
    private Integer checkboxExample = 0;

    /**
     * 多行输入
     */
    @Column(name = "text_area_example")
    private String textAreaExample;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

}
