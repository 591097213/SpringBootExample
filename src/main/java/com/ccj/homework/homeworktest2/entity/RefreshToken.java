package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * RefreshToken
 */
@Entity
@Data
public class RefreshToken {

    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private Long endTime;

    @OneToOne
    private Token token;
}
