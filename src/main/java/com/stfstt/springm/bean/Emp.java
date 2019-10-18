package com.stfstt.springm.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@Component
@Validated
@PropertySource(value = {"classpath:emp.properties"})
@ConfigurationProperties(prefix = "emp")
public class Emp {
    //    @Value("${emp.last-name}")
    private String lastName;
    //    @Value("#{10*2}")
    private Integer age;
    //    @Value("88888")
    private Double salary;
    private Boolean boss;
    private Date birthday;

    private Map map;
    private List list;

    private Forte forte;

}
