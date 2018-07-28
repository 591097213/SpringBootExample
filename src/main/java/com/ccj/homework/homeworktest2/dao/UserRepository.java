package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByAccounts(String account);

}
