package com.wang.web.servlet;


import javax.servlet.ServletException;

import java.io.IOException;

public class UserServlet extends BaseServlet {




     //跳转到注册页面
    public String registUI(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {


        return  "/jsp/register.jsp";
    }
}
