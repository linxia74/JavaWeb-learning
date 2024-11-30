package top.soft.classoa.class06.class06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/11/23 13:38
 */
//@WebFilter("/*")
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo02初始化");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("放行资源之前FilterDemo02执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行资源之后FilterDemo02执行");
    }
}
