package top.soft.classoa.class06.class06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/11/23 16:41
 */
@WebServlet("/singServlet")
public class SingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        resp.setContentType("text/html;charset=utf-8");
        req.getSession().setAttribute("username",username);
        resp.sendRedirect("/detail.jsp");
    }
}
