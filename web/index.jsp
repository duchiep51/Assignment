<%-- 
    Document   : index
    Created on : Jun 25, 2019, 8:54:27 AM
    Author     : Hiep
--%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Login Page</h1>
        <s:form action="LoginAction" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:submit value="Login"/>
        </s:form> 
        <s:a href="create.jsp">Register</s:a>
    </body>
</html>
