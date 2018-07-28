package com.ccj.homework.homeworktest2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * PhoNum
 */
@Entity
@Data
public class PhoNum {

    @Id
    String num;

    @OneToOne
    Account account;
}
