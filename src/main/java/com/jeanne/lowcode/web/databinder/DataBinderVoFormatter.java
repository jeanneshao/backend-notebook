package com.jeanne.lowcode.web.databinder;

import com.jeanne.lowcode.web.vo.DataBinderVo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jeanne 2023/6/23
 **/
public class DataBinderVoFormatter implements Formatter<DataBinderVo> {
    @Override
    public DataBinderVo parse(String text, Locale locale) throws ParseException {
        if (!StringUtils.hasText(text)) {
            // Treat empty String as null value.
            return null;
        } else {
            String[] split = text.split(";");
            Long idLong = Long.valueOf(split[0]) ;
            DataBinderVo build = DataBinderVo.builder().id(idLong).name(split[1]).build();
            return build;
        }
    }

    @Override
    public String print(DataBinderVo object, Locale locale) {
        return object.toString();
    }
}
