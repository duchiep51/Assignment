<%-- 
    Document   : error
    Created on : Jun 25, 2019, 9:19:40 AM
    Author     : Hiep
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error Page</h1>
        <h2>
            <s:property value="%{#request.ERROR}"/>
        </h2>
        <font color="red">
        <a href="index.jsp">Back to login</a>
        </font>
    </body>
</html>
