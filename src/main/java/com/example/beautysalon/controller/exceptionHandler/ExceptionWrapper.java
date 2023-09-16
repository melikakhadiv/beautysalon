package com.example.beautysalon.controller.exceptionHandler;


import java.sql.SQLException;

public class ExceptionWrapper {
    private static ExceptionWrapper exceptionWrapper = new ExceptionWrapper();

    private ExceptionWrapper() {
    }

    public static ExceptionWrapper getExceptionWrapper() {
        return exceptionWrapper;
    }

    public String getMessage(Exception e) {
        if (e instanceof SQLException) {
            return "SQL error!!";
        }else if (e instanceof AccessDeniedException) {
            return e.getMessage() + "\nAccess Denied!!";
        } else if (e instanceof NotFoundException) {
            return e.getMessage() + "\nNot Found!!";
        } else if (e instanceof InvalidDataException) {
            return e.getMessage() + "\nInvalid  Info!!";
        } else if (e instanceof DataIsCreatedException) {
            return e.getMessage() + "\nThis Data Is Already Created!!";
//        }else if (e instanceof JsonProcessingException) {
//            return e.getMessage() + "\nJson Error!!";
        }else {
            return "Please Call Support!";
        }
    }
}
