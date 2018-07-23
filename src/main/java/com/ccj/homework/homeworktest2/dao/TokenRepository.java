package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TokenRepository
 */
public interface TokenRepository extends JpaRepository<Token, Long> {

    public Token findByAccountAndCurrentTime(Account account, String currentTime);

}
