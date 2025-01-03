package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 11448
 * @description: TODO
 * @date 2024/10/19 14:03
 */
@WebServlet("/cookieDemo02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取Cookie 数组
        Cookie[] cookies = req.getCookies();
//        2.遍历 Cookie 数组
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)){
                System.out.println("value的结果"+cookie.getValue());
                break;
            }
        }
    }
}