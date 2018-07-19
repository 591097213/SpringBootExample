package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

    User findByPhoneNum(String phoneNum);

}
