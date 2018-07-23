package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * Token
 */
@Entity
@Data
public class Token {

    @Id
    @GeneratedValue
    private Long id;

    private String currentTime;
    private Long endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private App app;

    @ManyToOne /* (fetch = FetchType.EAGER) */
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
}
