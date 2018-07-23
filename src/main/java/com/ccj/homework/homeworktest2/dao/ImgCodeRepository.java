package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.ImgCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ImgCodeRepository
 */
public interface ImgCodeRepository extends JpaRepository<ImgCode, Long> {

    public ImgCode findByUuid(String uuid);
}
