package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.SmsCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SmsCodeRepository
 */
public interface SmsCodeRepository extends JpaRepository<SmsCode, Long> {

    SmsCode findByAccountAndCode(Account account, String code);

}
