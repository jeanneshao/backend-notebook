package com.jeanne.lowcode.ioc.packageinfo;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Jeanne 2023/6/17
 **/
@Component
public class PackageInfoComponent {
    public String componentText;
    @Nullable
    public Boolean componentBoolean;

}
