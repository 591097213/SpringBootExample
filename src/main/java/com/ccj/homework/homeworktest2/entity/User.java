package com.ccj.homework.homeworktest2.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean sex;
    private String email;
    private short age;

    @OneToMany(mappedBy = "user"/* , fetch = FetchType.EAGER */)
    private Collection<PhoNum> phoNums;

    @OneToMany(mappedBy = "user"/* , fetch = FetchType.EAGER */)
    private Collection<Account> accounts;

    @ManyToMany
    private Collection<Address> addresses;

    @ManyToMany
    private Collection<App> apps;

    @OneToMany(mappedBy = "user"/* , fetch = FetchType.EAGER */)
    private Collection<Token> tokens;

    @OneToMany(mappedBy = "user"/* , fetch = FetchType.EAGER */)
    private Collection<SmsCode> smsCodes;

    public User() {
        this.accounts = new ArrayList<Account>();
        this.addresses = new ArrayList<Address>();
        this.apps = new ArrayList<App>();
        this.phoNums = new ArrayList<PhoNum>();
        this.tokens = new ArrayList<Token>();
        this.smsCodes = new ArrayList<SmsCode>();
    }


}
