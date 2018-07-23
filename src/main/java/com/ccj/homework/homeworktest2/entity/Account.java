package com.ccj.homework.homeworktest2.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

/**
 * Account
 */
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    // id供登录用
    private Long id;

    private String accountName;
    private String pwd;

    @ManyToOne /* (fetch = FetchType.EAGER) */
    private User user;

    @OneToOne
    private PhoNum phoNum;

    @OneToMany(mappedBy = "account"/* , fetch = FetchType.EAGER */)
    private Collection<Token> tokens;

    public Account() {
        tokens = new ArrayList<Token>();
    }

}
