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
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpSession session = req.getSession();
        String id = req.getParameter("id") == null ? "1"
                : req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age") == null ? "1"
                : req.getParameter("age");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        User user = new User();
        user.setAddress(address);
        user.setGender(sex);
        user.setEmail(email);
        user.setQq(qq);
        user.setUsername(name);
        user.setId(Integer.parseInt(id));
        user.setAge(Integer.parseInt(age));
        int result = new UserDaoImpl().updateUser(user);
        session.setAttribute("msg","");
        if (result!=0) {
            session.setAttribute("msg", "修改成功");
            List<User> users = new UserDaoImpl().findAll();
            session.setAttribute("users", users);
            resp.sendRedirect("/userListServlet");
            //req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/list.jsp");
            //req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
