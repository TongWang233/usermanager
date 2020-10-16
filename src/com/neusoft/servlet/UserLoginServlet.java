package com.neusoft.servlet;

import com.neusoft.dao.impl.UserDaoImpl;
import com.neusoft.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpSession session = req.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        String uname = req.getParameter("user");
        String pwd = req.getParameter("password");
        String verifycode = req.getParameter("verifycode");

        User user = new UserDaoImpl().login(uname,pwd);
        if (verifycode.equalsIgnoreCase(checkCode)){
            if (user!=null){
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }else {
                session.setAttribute("login_msg","账户或者密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);

            }
        }else{
            session.setAttribute("login_msg","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
