package com.ccj.homework.homeworktest2.entity;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Account> accounts;

    @ManyToMany
    private Collection<Address> addresses;

    @ManyToMany
    private Collection<App> apps;


    public User() {
        this.accounts = new HashSet<Account>();
        this.addresses = new HashSet<Address>();
        this.apps = new HashSet<App>();
    }


}
