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

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
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
      int result = new UserDaoImpl().delUser(Integer.parseInt(id));
      if (result!=0){
          session.setAttribute("msg", "删除成功");
          List<User> users = new UserDaoImpl().findAll();
          session.setAttribute("users", users);
          resp.sendRedirect("/list.jsp");
          // req.getRequestDispatcher("/list.jsp").forward(req,resp);
      }else {
          session.setAttribute("msg", "删除失败");
          List<User> users = new UserDaoImpl().findAll();
          session.setAttribute("users", users);
          resp.sendRedirect("/list.jsp");
          //req.getRequestDispatcher("/list.jsp").forward(req,resp);
      }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
