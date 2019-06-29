<%-- 
    Document   : user
    Created on : Jun 25, 2019, 9:23:18 AM
    Author     : Hiep
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello, <s:property value="%{#session.USERLOGIN}"/></h1>
    </body>
</html>
