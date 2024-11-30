package top.soft.classoa.class06.class06.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    // List to store sensitive words
    private final List<String> sensitiveWords = new ArrayList<>();

    // The target method name for dynamic proxy
    private static final String TARGET_METHOD = "getParameter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            // Load sensitive words from file
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词.txt");
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "UTF-8"))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sensitiveWords.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Set response encoding
        response.setContentType("text/html;charset=UTF-8");

        // Create a dynamic proxy to intercept the getParameter method
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(
                request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (TARGET_METHOD.equals(method.getName())) {
                            String value = (String) method.invoke(request, args);
                            if (value != null) {
                                for (String word : sensitiveWords) {
                                    if (value.contains(word)) {
                                        value = value.replaceAll(word, "******");
                                    }
                                }
                            }
                            return value;
                        }
                        return method.invoke(request, args);
                    }
                }
        );

        // Pass the proxyRequest to the next filter or servlet
        chain.doFilter(proxyRequest, response);
    }

    @Override
    public void destroy() {
        // Cleanup resources if needed
    }
}
