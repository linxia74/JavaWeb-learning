package top.soft.classoa.class06.class06.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/11/23 13:59
 */
@WebServlet("/user/serlvet")
public class UserServlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("UserServlet被访问了");
    }
}
