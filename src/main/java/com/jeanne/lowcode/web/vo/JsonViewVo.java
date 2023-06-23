package com.jeanne.lowcode.web.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jeanne 2023/6/22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonViewVo {
    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};
    private String username;
    private String password;
    private Long age;

    @JsonView(WithoutPasswordView.class)
    public String getUsername() {
        return this.username;
    }
    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return this.password;
    }
}
