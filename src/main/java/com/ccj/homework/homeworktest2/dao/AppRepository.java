package com.ccj.homework.homeworktest2.dao;

import com.ccj.homework.homeworktest2.entity.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {

    App findByAppId(String string);

}
