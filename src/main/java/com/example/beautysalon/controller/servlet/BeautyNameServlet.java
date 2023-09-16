package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.model.entity.BeautyName;
import com.example.beautysalon.model.service.BeautyNameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/service.do")
public class BeautyNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("beautyNameList", BeautyNameService.getService().findAll());
            req.getSession().setAttribute("beautyDistinctNameList", BeautyNameService.getService().findByAllName());
            req.getRequestDispatcher("/panel/admin/beautyName.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeautyName beautyName = BeautyName.builder()
                    .name(req.getParameter("name"))
                    .build();
            BeautyNameService.getService().save(beautyName);
            resp.sendRedirect("/service.do");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeautyName beautyName = BeautyName.builder()
                    .name(req.getParameter("name"))
                    .build();
            BeautyNameService.getService().edit(beautyName);
            resp.sendRedirect("/service.do");
        } catch (Exception e) {
            resp.sendError(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BeautyNameService.getService().remove(Integer.valueOf((req.getParameter("id"))));
            resp.sendRedirect("/service.do");
        } catch (Exception e) {
            resp.sendError(403);
        }
    }


}
