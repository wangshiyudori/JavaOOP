package com.cn.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckCodeServlet extends HttpServlet {
    //在Serializable类如何使用SerialVersionUID来实现版本控制
    private static final long serialVersionUID = 1L;
    private int width = 80;
    private int height = 20;
    private int codeCount = 4; // 验证码图片的字符数
    private int x = 16;
    private int fontHeight = 16;
    private int codeY = 18;
    private final char[] codeSequence = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = img.getGraphics();

        Random random = new Random();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);
        Font font=new Font("Times new Roman", Font.PLAIN,fontHeight);

        graphics.setColor(Color.black);
        graphics.setFont(font);
        Color juneFont=new Color(153,204,102);
        graphics.setColor(juneFont);
        for (int i = 0; i <130 ; i++) {
            int x = random.nextInt(width);
            int y=random.nextInt(height);
            int xl=random.nextInt(16);
            int yl=random.nextInt(16);
            graphics.drawLine(x,y,x+xl,y+yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证，线程安全的可变字符序列
        StringBuffer randomCode = new StringBuffer();
        for (int i = 0; i <codeCount ; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);

            graphics.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));

            graphics.drawString(strRand,(i+1)*x-4,codeY);
            randomCode.append(strRand);
        }

        HttpSession session = req.getSession();
        session.setAttribute("realcode",randomCode.toString());

        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",0);
        resp.setContentType("image/gif");

        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(img,"gif",sos);
        sos.flush();
        sos.close();

    }


}