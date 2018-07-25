package com.ccj.homework.homeworktest2.entity;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Address
 */
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String addressName;

    @JsonIgnore
    @ManyToMany(mappedBy = "addresses")
    private Collection<User> users;

    public Address() {
        this.users = new HashSet<User>();
    }
}
