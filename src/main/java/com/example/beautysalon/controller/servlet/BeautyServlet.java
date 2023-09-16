package com.example.beautysalon.controller.servlet;


import com.example.beautysalon.model.entity.Beauty;
import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.BeautyNameService;
import com.example.beautysalon.model.service.BeautyService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j
@WebServlet(urlPatterns = "/beauty.do")
public class BeautyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameter("beautyService") != null) {
                req.getSession().setAttribute("beautyUserList", BeautyService.getService()
                        .findByName(req.getParameter("beautyService")));
            }

            if (req.getParameter("userId") != null) {
                req.getSession().setAttribute("beautyStylistList",
                        BeautyService.getService().findByUser(
                                Long.valueOf(req.getParameter("userId"))));
            }
            req.getSession().setAttribute("beautyNameList", BeautyNameService.getService().findAll());
            req.getSession().setAttribute("beautyList", BeautyService.getService().findAll());
            req.getRequestDispatcher("/panel/admin/beauty.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Beauty beauty = Beauty
                    .builder()
                    .beautyName(BeautyNameService.getService().findByName(req.getParameter("name")))
                    .price(Long.parseLong(req.getParameter("price")))
                    .duration(Integer.parseInt(req.getParameter("duration")))
                    .user((User) req.getSession().getAttribute("userLogin"))
                    .build();
            BeautyService.getService().save(beauty);
            resp.sendRedirect("/beauty.do");
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("beautyService", beauty);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            BeautyService.getService().edit(Beauty
                    .builder()
                    .id(Long.parseLong(req.getParameter("id")))
                    .beautyName(BeautyNameService.getService().findByName(req.getParameter("name")))
                    .price(Long.parseLong(req.getParameter("price")))
                    .duration(Integer.parseInt(req.getParameter("duration")))
                    .user((User) req.getSession().getAttribute("userLogin"))
                    .build());
            resp.sendRedirect("/beauty.do");
        } catch (Exception e) {
            resp.sendError(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            BeautyService.getService().remove(Long.parseLong(req.getParameter("id")));
            resp.sendRedirect("/beauty.do");
        } catch (Exception e) {
            resp.sendError(403);
        }
    }


}

