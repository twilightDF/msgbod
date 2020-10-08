package com.twilight.web;

import com.twilight.pojo.User;
import com.twilight.service.UserService;
import com.twilight.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //接收数据
        String empName = req.getParameter("empName");
        String password = req.getParameter("password");
        //检验用户名和密码是否正确
        UserService userService = new UserServiceImpl();
        User user = userService.login(empName,password);

        //将用户信息储存到session中
        if(user != null){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect(req.getContextPath()+"/main.htm");

            System.out.println(req.getSession().getAttribute("user"));
        }else {
            resp.getWriter().write("无该用户，请先注册,3秒后回注册页面");
            resp.setHeader("refresh","3,url=" +req.getContextPath() + "/regist.htm");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
