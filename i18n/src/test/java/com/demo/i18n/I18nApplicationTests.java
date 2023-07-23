package com.demo.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Date;
import java.util.Locale;

@SpringBootTest
class I18nApplicationTests {
    @Autowired
    MessageSource messageSource;

    @Test
    void testXmlResource(){
        String name = "Test I18N";
        Object[] args1 = new Object[]{name};
        String sss = messageSource.getMessage("greeting", args1, Locale.CHINA);
        System.out.println("testXmlResource===>" + sss);//At 下午4:52:04 on 2023年4月9日, there was a disturbance in the Force on planet 7.

    }

    @Test
    void testPropertiesResource(){
        int planet = 7;
        String event = "a disturbance in the Force";
        Object[] args1 = new Object[]{planet, new Date(), event};
        String sss = messageSource.getMessage("源码例子", args1, Locale.US);
        System.out.println("源码例子===>" + sss);//At 下午4:52:04 on 2023年4月9日, there was a disturbance in the Force on planet 7.

    }

    @Test
    void mainTest() {
        //源码例子=At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.
        int planet = 7;
        String event = "a disturbance in the Force";
        Object[] args1 = new Object[]{planet, new Date(), event};
        String sss = messageSource.getMessage("源码例子", args1, Locale.CHINA);
        System.out.println("源码例子===>" + sss);//At 下午4:52:04 on 2023年4月9日, there was a disturbance in the Force on planet 7.

//源码例子2=There {0,choice,0#are no files|1#is one file|1<are {0,number,integer} files}.
        sss = messageSource.getMessage("源码例子2", new Integer[]{0}, Locale.CHINA);
        System.out.println("源码例子2===>" + sss);//There are no files.
        sss = messageSource.getMessage("源码例子2", new Integer[]{1}, Locale.CHINA);
        System.out.println("源码例子2===>" + sss);//There is one file.
        sss = messageSource.getMessage("源码例子2", new Integer[]{100}, Locale.CHINA);
        System.out.println("源码例子2===>" + sss);//There are 100 files.

//拿第1个参数=拿第1个参数{0}
        sss = messageSource.getMessage("拿第1个参数", new String[]{"参数1", "参数2", "参数3"}, Locale.CHINA);
        System.out.println("拿第1个参数===>" + sss);//拿第1个参数参数1
//拿第3个参数=拿第3个参数{2}
        sss = messageSource.getMessage("拿第3个参数", new String[]{"参数1", "参数2", "参数3"}, Locale.CHINA);
        System.out.println("拿第3个参数===>" + sss);//拿第3个参数参数3

//拿第1个数字参数=拿第1个数字参数{0,number}
        sss = messageSource.getMessage("拿第1个数字参数", new Double[]{100.22}, Locale.CHINA);
        System.out.println("拿第1个数字参数===>" + sss);//拿第1个数字参数100.22
//拿第1个数字参数（integer）=拿第1个数字参数{0,number,integer}
        sss = messageSource.getMessage("拿第1个数字参数（integer）", new Double[]{100.22}, Locale.CHINA);
        System.out.println("拿第1个数字参数（integer）===>" + sss);//拿第1个数字参数100
//拿第1个数字参数（currency）=拿第1个数字参数{0,number,currency}
        sss = messageSource.getMessage("拿第1个数字参数（currency）", new Double[]{100.22}, Locale.CHINA);
        System.out.println("拿第1个数字参数（currency）===>" + sss);//拿第1个数字参数￥100.22
//拿第1个数字参数（percent）=拿第1个数字参数{0,number,percent}
        sss = messageSource.getMessage("拿第1个数字参数（percent）", new Double[]{0.22335}, Locale.CHINA);
        System.out.println("拿第1个数字参数（percent）===>" + sss);//拿第1个数字参数22%
//拿第1个date参数（--）=拿第1个date参数{0,date}
        sss = messageSource.getMessage("拿第1个date参数（--）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个date参数（--）===>" + sss);//拿第1个date参数2023年4月9日
//拿第1个date参数（short）=拿第1个date参数{0,date,short}
        sss = messageSource.getMessage("拿第1个date参数（short）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个date参数（short）===>" + sss);//拿第1个date参数2023/4/9
//拿第1个date参数（medium）=拿第1个date参数{0,date,medium}
        sss = messageSource.getMessage("拿第1个date参数（medium）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个date参数（medium）===>" + sss);//拿第1个date参数2023年4月9日
//拿第1个date参数（long）=拿第1个date参数{0,date,long}
        sss = messageSource.getMessage("拿第1个date参数（long）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个date参数（long）===>" + sss);//>拿第1个date参数2023年4月9日
//拿第1个date参数（full）=拿第1个date参数{0,date,full}
        sss = messageSource.getMessage("拿第1个date参数（full）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个date参数（full）===>" + sss);//拿第1个date参数2023年4月9日星期日
//拿第1个time参数（--）=拿第1个date参数{0,time}
        sss = messageSource.getMessage("拿第1个time参数（--）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个time参数（--）===>" + sss);//拿第1个date参数下午4:52:04
//拿第1个time参数（short）=拿第1个date参数{0,time,short}
        sss = messageSource.getMessage("拿第1个time参数（short）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个time参数（short）===>" + sss);//拿第1个date参数下午4:52
//拿第1个time参数（medium）=拿第1个date参数{0,time,medium}
        sss = messageSource.getMessage("拿第1个time参数（medium）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个time参数（medium）===>" + sss);//拿第1个date参数下午4:52:04
//拿第1个time参数（long）=拿第1个date参数{0,time,long}
        sss = messageSource.getMessage("拿第1个time参数（long）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个time参数（long）===>" + sss);//拿第1个date参数CST 下午4:52:04
//拿第1个time参数（full）=拿第1个date参数{0,time,full}
        sss = messageSource.getMessage("拿第1个time参数（full）", new Date[]{new Date()}, Locale.CHINA);
        System.out.println("拿第1个time参数（full）===>" + sss);//拿第1个date参数中国标准时间 下午4:52:04

    }

}
