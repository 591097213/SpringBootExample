package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.PhoNum;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ImgCodeRepository
 */
public interface PhoNumRepository extends JpaRepository<PhoNum, String> {

    public PhoNum findByNum(String num);
}
