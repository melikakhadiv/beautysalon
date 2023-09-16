package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.controller.exceptionHandler.ExceptionWrapper;
import com.example.beautysalon.model.entity.Timing;
import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.BeautyService;
import com.example.beautysalon.model.service.TimingService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Log4j
@WebServlet(urlPatterns = "/timing.do")
public class TimingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String edit= req.getParameter("edit");
            if (edit != null){
                Timing timing = TimingService.getService().findById(Long.valueOf(edit));
                req.getSession().setAttribute("timing",timing);
                req.getRequestDispatcher("/panel/admin/timing.jsp").forward(req,resp);
            }
            else if (req.getParameter("beautyService") != null) {
                req.getSession().setAttribute("timingBeautyList", TimingService.getService().findByBeauty("beautyService"));
                req.getRequestDispatcher("/panel/admin/timing.jsp").forward(req, resp);
            }


            else if (req.getParameter("beautyService") != null && req.getParameter("day") != null) {
                req.getSession().setAttribute("timingBeautyDayList", TimingService.getService()
                        .findByBeautyDay(req.getParameter("beautyService")
                                , req.getParameter("day")));
            }
            else if (req.getParameter("beautyService") != null && req.getParameter("userId") != null) {
                req.getSession().setAttribute("timingBeautyUserList", TimingService.getService()
                        .findByBeautyUser(req.getParameter("beautyService")
                                , Long.valueOf(req.getParameter("userId"))));
            }

            else if (req.getParameter("beautyService") != null && req.getParameter("beautyDayTime") != null
                    && req.getParameter("userId") != null && req.getParameter("beautyServiceDay") != null) {
                req.getSession().setAttribute("timingBeautyDayTimeList", TimingService.getService()
                        .findByBeautyUserDayTime
                                (req.getParameter("beautyDayTime")
                                        , Long.valueOf(req.getParameter("userId")),
                                        req.getParameter("beautyService"),
                                        req.getParameter("beautyServiceDay")));
            }

            else if (req.getParameter("beautyService") != null
                    && req.getParameter("userId") != null && req.getParameter("beautyServiceDay") != null) {
                req.getSession().setAttribute("timingBeautyUserDayList", TimingService.getService()
                        .findByBeautyUserDay(req.getParameter("beautyService")
                                , Long.valueOf(req.getParameter("userId"))
                                , req.getParameter("beautyServiceDay")));
            }else {

                req.getSession().setAttribute("timingList", TimingService.getService().findAll());
                req.getRequestDispatcher("/panel/admin/timing.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TimingService.getService().save(Timing
                    .builder()
                    .day(LocalDate.parse(req.getParameter("day")))
                    .startTime(LocalTime.parse(req.getParameter("startTime")))
                    .endTime(LocalTime.parse((req.getParameter("endTime"))))
                    .beauty(BeautyService.getService()
                            .findByUserAndBeauty(Long.valueOf(req.getParameter("userId"))
                                    , req.getParameter("beautyService")))
                    .build());

            resp.sendRedirect("/panel/" + ((User) req.getSession().getAttribute("userLogin")).getRole().getRole() + "/timing.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(400);
            log.error(ExceptionWrapper.getExceptionWrapper().getMessage(e));
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TimingService.getService().edit(Timing
                    .builder()
                    .id(Long.parseLong(req.getParameter("id")))
                    .day(LocalDate.parse(req.getParameter("day")))
                    .startTime(LocalTime.parse(req.getParameter("startTime")))
                    .endTime(LocalTime.parse((req.getParameter("endTime"))))
                    .beauty(BeautyService.getService()
                            .findByUserAndBeauty(Long.valueOf(req.getParameter("userId"))
                                    , req.getParameter("beautyService")))
                    .build());
            resp.sendRedirect("/timing.do");
        } catch (Exception e) {
            resp.sendError(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TimingService.getService().remove(Long.valueOf(req.getParameter("id")));
            resp.sendRedirect("/timing.do");
        } catch (Exception e) {
            resp.sendError(403);
        }
    }


}

