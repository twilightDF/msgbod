package com.twilight.web;

import com.twilight.pojo.User;
import com.twilight.service.UserService;
import com.twilight.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取用户提交的参数
        String userName = req.getParameter("empName");
        String password = req.getParameter("password");

        //数据校验--略

        //调用service层添加用户
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        userService.regist(user);
        req.getRequestDispatcher("/login.htm").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
