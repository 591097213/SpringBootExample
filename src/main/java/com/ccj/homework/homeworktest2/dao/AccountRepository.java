package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccountRepository
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByPhoNum(PhoNum PhoNum);

}
