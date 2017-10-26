package com.wang.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {


    @Override
    public String index(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        return "/jsp/register.jsp";
    }
}
