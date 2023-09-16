package com.example.beautysalon.controller.servlet;

import com.example.beautysalon.model.entity.Reservation;
import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.BeautyService;
import com.example.beautysalon.model.service.ReservationService;
import com.example.beautysalon.model.service.TimingService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@Log4j
@WebServlet(urlPatterns = "/reserve.do")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("reserveList", ReservationService.getService().findAll());
            req.getSession().setAttribute("beautyDistinctList", BeautyService.getService().findByAllName());

//            if (req.getParameter("beautyService") != null) {
//                req.getSession().setAttribute("timingBeautyList", TimingService.getService()
//                        .findByBeauty("beautyService"));
//
//                req.getSession().setAttribute("beautyNameList", BeautyService.getService()
//                        .findByName(req.getParameter("beautyService")));
//            }
//
//
//            if (req.getParameter("userId") != null) {
//                req.getSession().setAttribute("beautyStylistList",
//                        BeautyService.getService()
//                                .findByUserAndBeauty(Long.valueOf(req.getParameter("userId"))
//                                        , req.getParameter("beautyService")));
//            }
//
//
//            if (req.getParameter("userId") != null) {
//                req.getSession().setAttribute("timingBeautyUserList", TimingService.getService()
//                        .findByBeautyUser(req.getParameter("beautyService")
//                                , Long.valueOf(req.getParameter("userId"))));
//            }
//
//            if (req.getParameter("userId") != null && req.getParameter("beautyServiceDay") != null) {
//                req.getSession().setAttribute("timingBeautyUserDayList", TimingService.getService()
//                        .findByBeautyUserDay(req.getParameter("beautyService")
//                                , Long.valueOf(req.getParameter("userId"))
//                                , req.getParameter("beautyServiceDay")));
//            }
//
//            if (req.getParameter("beautyDayTime") != null
//                    && req.getParameter("userId") != null && req.getParameter("beautyServiceDay") != null) {
//                req.getSession().setAttribute("timingBeautyDayTimeList", TimingService.getService()
//                        .findByBeautyUserDayTime
//                                (req.getParameter("beautyDayTime")
//                                        , Long.valueOf(req.getParameter("userId")),
//                                        req.getParameter("beautyService"),
//                                        req.getParameter("beautyServiceDay")));
//            }

            req.getRequestDispatcher("/panel/admin/reservation.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            ReservationService.getService().save(Reservation
                    .builder()
                    .customer((User) req.getSession().getAttribute("userLogin"))
                    .beauty(BeautyService.getService()
                            .findByUserAndBeauty
                                    (Long.valueOf(req.getParameter("userId"))
                                            , req.getParameter("beautyService")))
                    .timing(TimingService.getService()
                            .findByBeautyUserDayTime(req.getParameter("beautyDayTime")
                                    , Long.valueOf(req.getParameter("userId"))
                                    , req.getParameter("beautyService")
                                    , req.getParameter("beautyServiceDay")))
                    .reservationTime(LocalTime.parse(req.getParameter("reserveTime")))
                    .prePay(Integer.parseInt(req.getParameter("prePay")))
                    .build());
            resp.sendRedirect("/panel/" + ((User) req.getSession().getAttribute("userLogin")).getRole().getRole() + "/reservation.jsp");
        } catch (Exception e) {
            resp.sendError(400);
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReservationService.getService().edit(Reservation
                    .builder()
                    .id(Long.valueOf(req.getParameter("id")))
//                    .user()
//                    .beautyService()
//                    .timing()
                    .prePay(Integer.parseInt(req.getParameter("prePay")))
                    .build());
            resp.sendRedirect("/reserve.do");
        } catch (Exception e) {
            resp.sendError(400);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ReservationService.getService().remove(Long.valueOf(req.getParameter("id")));
            resp.sendRedirect("/reserve.do");
        } catch (Exception e) {
            resp.sendError(403);
            throw new RuntimeException(e);
        }
    }


}
