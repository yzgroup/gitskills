<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
 <%@ page import="com.alibaba.fastjson.JSONObject" %>

 <%
  JSONObject json=new JSONObject();
  json.put("errcode", "0");
  json.put("message", "系统异常，请稍后再试");
  response.setContentType("application/json;charset=UTF-8");
  response.setCharacterEncoding("UTF-8");
  response.getWriter().write(json.toString());
 %>
