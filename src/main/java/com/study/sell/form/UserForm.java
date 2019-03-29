package com.study.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Auther : 冷科
 * @Date : 2019/3/18 08:56
 */
@Data
public class UserForm {
    @NotEmpty(message = "用户名必填!")
    private String userName;
    @NotEmpty(message = "密码必填!")
    private String password;
}
