package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SmsCodeRepository
 */
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    public RefreshToken findByCode(String code);

}
