package com.fznsys.xiyou_full_platform.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6515261573146253923L;
    private String id;
    private String username;

    private String password;

    private String role;
    private String name;

}
