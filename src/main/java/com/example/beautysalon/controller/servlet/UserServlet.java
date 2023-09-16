package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.RoleService;
import com.example.beautysalon.model.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet(urlPatterns = "/user.do")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String edit = req.getParameter("edit");
            if (edit != null) {
                User user = UserService.getService().findById(Long.valueOf(edit));
                req.getSession().setAttribute("userEdit", user);
//                System.out.println(req.getSession().getAttribute("userEdit"));
                System.out.println("user edit find" + user);
                req.getRequestDispatcher("/panel/admin/user.jsp").forward(req, resp);
            } else {
                req.getSession().setAttribute("rolesList", RoleService.getSevice().findAll());
                req.getSession().setAttribute("userList", UserService.getService().findAll());
                req.getRequestDispatcher("/panel/admin/user.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = User.builder()
                    .role(RoleService.getSevice().findByRoles(req.getParameter("role")))
                    .userName(req.getParameter("username"))
                    .password(req.getParameter("password"))
                    .phoneNumber(req.getParameter("phoneNumber"))
                    .name(req.getParameter("name"))
                    .family(req.getParameter("family"))
                    .build();
            UserService.getService().save(user);
            resp.sendRedirect("/user.do");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            User user = User.builder().id(Long.parseLong(req.getParameter("id")))
                    .role(RoleService.getSevice().findByRoles(req.getParameter("role")))
                    .userName(req.getParameter("username"))
                    .password(req.getParameter("password"))
                    .phoneNumber(req.getParameter("phoneNumber"))
                    .name(req.getParameter("name"))
                    .family(req.getParameter("family"))
                    .status(Boolean.parseBoolean(req.getParameter("status")))
                    .build();
            System.out.println("USER : " + user);
            UserService.getService().edit(user);
            resp.sendRedirect("/user.do");
        } catch (
                Exception e) {
            e.printStackTrace();
            resp.sendError(400);

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("Deleted method ");
            UserService.getService().remove(Long.valueOf(req.getParameter("id")));
            resp.sendRedirect("/user.do");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(403);
        }
    }


}
