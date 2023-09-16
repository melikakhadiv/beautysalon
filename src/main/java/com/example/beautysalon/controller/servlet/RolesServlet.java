package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.model.entity.Roles;
import com.example.beautysalon.model.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/roles.do")
public class RolesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("rolesList", RoleService.getSevice().findAll());
            req.getRequestDispatcher("/panel/admin/roles.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Roles roles = Roles.builder()
                    .role(req.getParameter("role"))
                    .build();
            RoleService.getSevice().save(roles);
            resp.sendRedirect("/roles.do");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Roles roles = Roles.builder()
                    .role(req.getParameter("role"))
                    .build();
            RoleService.getSevice().edit(roles);
            resp.sendRedirect("/roles.do");
        } catch (Exception e) {
            resp.sendError(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RoleService.getSevice().remove(Integer.valueOf(req.getParameter("id")));
            resp.sendRedirect("/roles.do");
        } catch (Exception e) {
            resp.sendError(403);
        }
    }


}
