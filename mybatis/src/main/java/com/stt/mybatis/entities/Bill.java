package com.stt.mybatis.entities;

import lombok.*;

import java.util.Date;

/**
 * 帐单实体类
 *
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Bill {

    private Integer bid;
    // 账单编码
    private String bill_Code;
    // 商品名称
    private String billName;
    // 商品单位
    private String billCom;
    // 商品数量
    private Integer bill_Num;
    // 总金额
    private Double money;
    // 供应商
    private Provider provider;
    // 是否付款 0 未付款， 1已付款
    private Integer pay;
    // 创建时间
    private Date create_Date;


}
