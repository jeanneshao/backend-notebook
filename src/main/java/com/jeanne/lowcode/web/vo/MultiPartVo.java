package com.jeanne.lowcode.web.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @author Jeanne 2023/6/22
 **/
@Data
public class MultiPartVo {
//    private File file;
    private MultipartFile stringFile;
    private List<MultipartFile> files;
    private String requestParam;
    private String jsonBody;
}
