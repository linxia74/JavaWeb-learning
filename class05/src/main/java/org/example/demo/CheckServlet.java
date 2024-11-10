package org.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.从请求参数中获取用户名
        String username = req.getParameter("username");
        //2.判断用户名是否存在
        boolean equals = !"admin".equals(username);
        //3.响应结果
        resp.getWriter().write(String.valueOf(equals));
    }
}