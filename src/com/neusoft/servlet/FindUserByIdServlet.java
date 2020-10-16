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

@WebServlet("/findUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        HttpSession session = req.getSession();
         String id = req.getParameter("id");
        User user = new UserDaoImpl().findbyid(Integer.parseInt(id));
        if (user!=null){
            req.setAttribute("user",user);
            req.getRequestDispatcher("/update.jsp").forward(req,resp);
        }else{
            session.setAttribute("msg", "修改失败");
            resp.sendRedirect("/list.jsp");
            //  req.getRequestDispatcher("/list.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
