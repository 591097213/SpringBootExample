package com.ccj.homework.homeworktest2.other.staticdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件中定义的可访问目录
 */
@Component
@ConfigurationProperties(prefix = "safety")
public class AccessibleUrls {

    private List<String> urls = new ArrayList<>();

    /**
     * @return the urls
     */
    public List<String> getUrls() {
        return urls;
    }
}
