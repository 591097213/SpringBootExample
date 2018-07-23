package com.ccj.homework.homeworktest2.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @ManyToOne(fetch = FetchType.EAGER)
    User user;

    @OneToOne
    Account account;

    @OneToMany /* (fetch = FetchType.EAGER) */
    Collection<SmsCode> smsCodes;

    public PhoNum() {
        smsCodes = new ArrayList<SmsCode>();
    }
}
