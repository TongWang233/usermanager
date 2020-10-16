package com.neusoft.servlet;

import com.neusoft.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DeleteSelectedUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uids = req.getParameterValues("uid");
        if (uids != null && uids.length > 0) {
            for (String id : uids) {
                new UserDaoImpl().delUser(Integer.parseInt(id));
            }
        }
        resp.sendRedirect(req.getContextPath() + "/userListServlet");
        //req.getRequestDispatcher("/userListServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
