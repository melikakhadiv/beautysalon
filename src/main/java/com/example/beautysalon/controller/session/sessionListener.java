package com.example.beautysalon.controller.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class sessionListener implements HttpSessionListener {
    private static long visited;
    private static long online;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("visited: "+ ++visited);
        System.out.println("online: "+ ++online);
        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("online: "+ --online);
        HttpSessionListener.super.sessionDestroyed(se);
    }
}
