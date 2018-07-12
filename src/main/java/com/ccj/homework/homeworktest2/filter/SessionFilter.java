package com.ccj.homework.homeworktest2.filter;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccj.homework.homeworktest2.data.UserTockenData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 * 过滤器类，用于过滤URL
 */
@WebFilter
public class SessionFilter implements Filter {

    // 注入从配置文件中获取的可访问目录类
    @Autowired
    AccessibleUrls accessibleUrls;

    @Override
    public void doFilter(//
            ServletRequest servletRequest, //
            ServletResponse servletResponse, //
            FilterChain filterChain//
    ) throws IOException, ServletException {

        // 将ServletRequest类转为HttpServletRequest类，因为ServletRequest中没有getRequestURI()方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取tocken和URI
        String tocken = request.getParameter("tocken");
        String uri = request.getRequestURI();

        // 用于测试，输出接收到的URI
        // System.out.println("*********************filter url:" + uri);

        // 是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { // 不需要过滤直接传给下一个过滤器

            // 用于测试，定位过滤位置
            // System.out.println("111111111111111111111111111111111111111111111111111111111");
            filterChain.doFilter(request, response);

        } else { // 需要过滤器

            // 判断用户是否已登录，有无tocken
            if (tocken != null && UserTockenData.findUserTocken(tocken)) {

                // 用于测试，定位过滤位置
                // System.out.println("222222222222222222222222222222222222222222222222222222222");
                filterChain.doFilter(request, response);

            } else {

                // 用于测试，定位过滤位置
                // System.out.println("3333333333333333333333333333333333333333333333333333");
                // 返回错误码
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        }
    }

    /**
     *
     * 判断是否需要过滤，需要返回true，不需要返回false
     *
     */
    public boolean isNeedFilter(String uri) {

        // 用于测试定位
        // System.out.println("*****************************************进入判断：" + uri);

        List<String> urls = accessibleUrls.getUrls();

        // 用于测试，输出从配置文件获取的URI
        // System.out.println(urls.size());
        // for (int i = 0; i < urls.size(); i++) {
        // System.out.println(urls.get(i));
        // }

        for (int i = 0; i < urls.size(); i++) {
            if (urls.get(i).equals(uri)) {
                return false;
            } else {
                if (uri.substring(0, 6).equals("/phone")) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
