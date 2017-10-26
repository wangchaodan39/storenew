package com.wang.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
   @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

       try {
           //重写Servlet生命周期方法
           //1获取方法名称
           String methodName=request.getParameter("method");

           if (methodName==null || methodName.trim().length()==0 ){
                     methodName="index";
            }
           //2.运用反射获取方法对象
           Method method=this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
           //方法执行，接受返回值
           String path =(String) method.invoke(this, request, response);
           //判断返回值，若为路径则转发，若为空则重定向到页面
           if (path!=null){
               request.getRequestDispatcher(path).forward(request,response);
           }else {

           }

       } catch (NoSuchMethodException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }

   }
      //给定一个默认方法执行没有method参数时执行的方法
     public  String index(ServletRequest request, ServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("您没有写明方法(Method)参数");


       return  null;
     }


}
