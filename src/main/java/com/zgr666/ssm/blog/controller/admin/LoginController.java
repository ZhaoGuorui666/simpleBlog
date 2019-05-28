package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @RequestMapping(value="/loginCheck")
    @ResponseBody
    public String loginCheck(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();

        String userName =request.getParameter("username");
        String passWord = request.getParameter("password");
        String checkCode = request.getParameter("checkcode");
        String truePass =userService.getPassByName(userName);
        String trueCode = (String)request.getSession().getAttribute("checkCode");
        if(passWord == truePass || passWord.equals(truePass)){
            if(!checkCode.equalsIgnoreCase(trueCode)){
                map.put("code",0);
                map.put("msg","验证码错误!!");
            }else{
                //登陆成功
                map.put("code",1);
                map.put("msg","");
                //添加session
                request.getSession().setAttribute("username",userName);
                //添加cookie
                Cookie nameCookie = new Cookie("username",userName);
                Cookie passCookie = new Cookie("password", passWord);
                //设置cookie有效期为3天
                nameCookie.setMaxAge(60*60*24*3);
                passCookie.setMaxAge(60*60*24*3);
                response.addCookie(nameCookie);
                response.addCookie(passCookie);

                //更新用戶的最后登陆时间和ip
                //更新用户
                System.out.println("进入loginCheck!");
            }
        }
        else{
            map.put("code",0);
            map.put("msg","用户密码不正确!!");
        }
        System.out.println("进入了logincheck5");
        String result = new JSONObject(map).toString();
        return  result;
    }

    @RequestMapping(value="/checkCode")
    @ResponseBody
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        int width = 60;
        int height = 20;
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache- Control","no-cache");
        response.setDateHeader("Expires",0);

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        String chars="0123456789abcdefghijklmnopqrstuvwxyz";
        char[] rands=new char[4];
        for(int i = 0;i<4;i++){
            int rand = (int)(Math.random()*36);
            rands[i] = chars.charAt(rand);
        }
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0,0,width,height);
        for(int i = 0;i<120;i++){
            int x = (int)(Math.random()*width);
            int y = (int)(Math.random()*height);
            int red = (int)(Math.random()*255);
            int green = (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            g.setColor(new Color(red,green,blue));
            g.drawOval(x,y,1,0);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC| Font.BOLD,18));
        g.drawString(""+rands[0],1,17);
        g.drawString(""+rands[1],16,15);
        g.drawString(""+rands[2],31,18);
        g.drawString(""+rands[3],46,16);
        g.dispose();

        ServletOutputStream sos=response.getOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"JPEG",baos);
        byte[] buffer = baos.toByteArray();
        response.setContentLength(buffer.length);
        sos.write(buffer);
        baos.close();
        sos.close();

        session.setAttribute("checkCode",new String(rands));
    }


    @RequestMapping("/admin")
    public String adminPage()   {return "admin/index";}
}
