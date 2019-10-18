package com.stfstt.springm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String phone;
    private int age;
    private Date createTime;
}
