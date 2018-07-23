package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * SmsCode
 */
@Entity
@Data
public class SmsCode {

    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private Long endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private App app;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private PhoNum phoNum;

}
