package com.ccj.homework.homeworktest2.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;

@WebFilter
public class SessionFilter implements Filter {


    String[] includeUrls =
            new String[] {"/login", "/swagger-ui.html", "/swagger-resources", "/v2/api-docs"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        // System.out.println("filter url:" + uri);
        // 是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { // 不需要过滤直接传给下一个过滤器
            System.out.println("111111111111111111111111111111111111111111111111111111111");
            filterChain.doFilter(servletRequest, servletResponse);
        } else { // 需要过滤器
            // session中包含user对象,则是登录状态
            if (session != null && session.getAttribute("user") != null) {
                System.out.println("222222222222222222222222222222222222222222222222222222222");
                filterChain.doFilter(request, response);
            }
            // else {
            // String requestType = request.getHeader("X-Requested-With");
            // // 判断是否是ajax请求
            // if (requestType != null && "XMLHttpRequest".equals(requestType)) {
            // response.getWriter().write(this.NO_LOGIN);
            // }
            else {
                System.out.println("3333333333333333333333333333333333333333333333333333");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
            return;
        }
    }

    /**
     *
     * 判断是否需要过滤
     *
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return false;
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
