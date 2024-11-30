package top.soft.classoa.class06.class06.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/wordsServlet")
public class WordsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type and encoding
        resp.setContentType("text/html;charset=UTF-8");

        // Get the "words" parameter
        String words = req.getParameter("words");

        // Print filtered words to the console for debugging
        System.out.println("Filtered words: " + words);

        // Respond to the client
        PrintWriter writer = resp.getWriter();
        if (words != null) {
            writer.write("Filtered Content: " + words);
        } else {
            writer.write("No words received.");
        }
        writer.close();
    }
}
