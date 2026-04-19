package com.tlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//封装登录结果
public class LoginInfo {
    private Integer id;
    private String username;
    private String name;
    private String token;

}
