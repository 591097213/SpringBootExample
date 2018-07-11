package com.ccj.homework.homeworktest2.filter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
