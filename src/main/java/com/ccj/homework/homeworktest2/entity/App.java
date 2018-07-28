package com.ccj.homework.homeworktest2.entity;

import java.util.Collection;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
public class App {

    @Id
    // appId用自定义的UUID实现，不自增
    private String appId;

    private String appSecret;

    @OneToMany(mappedBy = "app", fetch = FetchType.EAGER)
    private Collection<ImgCode> imgCodes;

    @JsonIgnore
    @ManyToMany(mappedBy = "apps")
    private Collection<User> users;

    public App() {
        this.imgCodes = new HashSet<ImgCode>();
        this.users = new HashSet<User>();
    }

}
