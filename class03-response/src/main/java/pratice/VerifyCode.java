package pratice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 23164
 * @description: TODO
 * @date 2024/9/28 16:07
 */
@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 45;
        //1 创建验证码图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2 获取画笔
       Graphics g = image.getGraphics();
        //设置颜色
        g.setColor(Color.blue);
        g.fillRect(0,0,width,height);
        String str = "123456789";
        Random random = new Random();
        for (int i = 1; i <= 5; i++){
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
        //这是字体颜色
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        g.setColor(color);
        g.setFont(new Font("宋体",Font.BOLD,24));
        //填写验证码
            g.drawString(String.valueOf(ch),width/5*i,height/2);
        }
        //生成干扰线
        for (int i = 1; i <= 10; i++){
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(color);
            g.drawLine(x1,y1,x2,y2);
        }
        //响应到页面上
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
