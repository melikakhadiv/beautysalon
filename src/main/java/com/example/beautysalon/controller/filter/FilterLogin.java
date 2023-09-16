package com.example.beautysalon.controller.filter;


import com.example.beautysalon.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/panel/*")
public class FilterLogin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession httpSession=((HttpServletRequest) servletRequest).getSession();
        User user=(User)httpSession.getAttribute("userLogin");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        if(user!= null){
//            request.getRequestDispatcher("/panel/"+user.getRole().name()+"/panel.jsp").forward(request,response);
            filterChain.doFilter(request,response);
        }
        else{
            response.sendRedirect("/login.do");
        }

    }
}
