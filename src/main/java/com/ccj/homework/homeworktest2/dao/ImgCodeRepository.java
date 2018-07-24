package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.ImgCode;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ImgCodeRepository
 */
@CacheConfig(cacheNames = "imgCodes")
public interface ImgCodeRepository extends JpaRepository<ImgCode, Long> {

    @Cacheable
    public ImgCode findByUuid(String uuid);
}
