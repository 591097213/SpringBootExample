package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 * ImageCode
 */
@Entity
@Data
public class ImgCode {

    @Id
    // ImgCode的id直接用浏览器传过来的UUID实现
    private String uuid;

    private String code;
    private Long endTime;

    @ManyToOne
    private App app;
}
