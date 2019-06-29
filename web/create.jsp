<%-- 
    Document   : create
    Created on : Jun 27, 2019, 7:27:09 AM
    Author     : Hiep
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Register account</h1>
        <s:form action="RegisterAction" method="POST">
            <s:textfield name="username" label="Username"/>
            <s:password name="password" label="Password"/>
            <s:password name="confirm" label="Confirm"/>
            <s:textfield name="emailId" label="Email"/>
            <s:textfield name="phoneNo" label="Phone Number: (090-1234567)"/>
            <s:submit value="Register"/>
        </s:form>
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <s:property value="username"/> is existed
        </s:if>
    </body>
</html>
