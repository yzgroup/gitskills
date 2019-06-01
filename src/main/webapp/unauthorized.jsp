<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
 <%@ page import="com.alibaba.fastjson.JSONObject" %>

 <% 
 JSONObject json=new JSONObject();
 json.put("errcode", "0");
 json.put("status", "403");
 json.put("message", "对不起，您没有权限访问");
 response.setContentType("application/json;charset=UTF-8");
 response.setCharacterEncoding("UTF-8");
 response.getWriter().write(json.toString());
 %>
