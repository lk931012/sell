package com.study.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 15:11
 * 用户实体
 */
@Entity
@Data
@DynamicUpdate
public class User {
    @Id
    private String userId;           //用户ID
    private String userName;        //用户名称
    private String userPassword;    //用户密码
}
