package com.example.web.databinder;

import com.example.web.vo.DataBinderVo;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author Jeanne 2023/6/22
 **/
public class DataBinderVoEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(@Nullable String text) throws IllegalArgumentException {
        if (!StringUtils.hasText(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            String[] split = text.split(";");
            Long idLong = Long.valueOf(split[0]) ;
            DataBinderVo build = DataBinderVo.builder().id(idLong).name(split[1]).build();
            setValue(build);
        }
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }

}
