package com.jeanne.lowcode.web.controller;

import com.jeanne.lowcode.web.databinder.DataBinderVoEditor;
import com.jeanne.lowcode.web.databinder.DataBinderVoFormatter;
import com.jeanne.lowcode.web.vo.DataBinderVo;
import com.jeanne.lowcode.web.vo.JsonViewVo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author Jeanne 2023/6/22
 **/
@RestController
public class WebDataBinderController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(DataBinderVo.class, new DataBinderVoEditor());
        binder.setDisallowedFields("password");
        binder.addCustomFormatter(new DataBinderVoFormatter());
    }

    @PostMapping("/customEditor")
    public DataBinderVo getUser3(
            @ModelAttribute DataBinderVo dataBinderVo,
            @RequestParam DataBinderVo dataBinderVo2,
            @RequestParam("id") Optional<Long> id
//          ,  @RequestBody DataBinderVo jsonViewVo
    ) {
        return DataBinderVo.builder().id(77l).name("222dsd").build();
    }

    @PostMapping("/binder")
    public JsonViewVo getUser3(Model model,
                               @ModelAttribute String password,
                               @RequestBody JsonViewVo jsonViewVo) {
        return new JsonViewVo("eric", "7!jd#h23", 21l);
    }
}
