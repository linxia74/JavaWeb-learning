package top.soft.bookonline.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/11/23 15:44
 */
@WebServlet("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
    // 放行
        String[] urls = {"/login","login-page","login.html","/css","/images"};
        String requestUrl = request.getRequestURL().toString();
        for (String url : urls) {
            if (requestUrl.contains(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
    }
}
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            request.getRequestDispatcher("/login.html").forward(servletRequest,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
