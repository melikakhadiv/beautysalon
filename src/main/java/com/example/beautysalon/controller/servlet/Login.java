package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j
@WebServlet(urlPatterns = "/login.do")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember");

            if (remember!= null && remember.equals("on")){
                Cookie uCookie = new Cookie("username",username);
                Cookie pCookie = new Cookie("password",password);
                resp.addCookie(uCookie);
                resp.addCookie(pCookie);
            }
            User user = UserService.getService().findByUserAndPass(username, password);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userLogin",user);
            resp.sendRedirect("/panel/"+user.getRole().getRole()+"/panel.jsp");
        } catch (Exception e) {
//            resp.sendError(404);
            e.printStackTrace();
            resp.sendRedirect("/signup.do");
        }
    }
}
