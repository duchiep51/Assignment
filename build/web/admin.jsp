<%-- 
    Document   : admin
    Created on : Jun 25, 2019, 9:22:01 AM
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
        <s:form action="SearchAction" method="POST">
            <s:textfield name="searchValue" label="Fullname"/>
            <s:submit value="Search"/>
        </s:form>
        <s:if test="%{listAccount != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listAccount" status="counter">
                    <tr>
                        <td>
                            <s:property value="%{#counter.count}"/>
                        </td>
                        <td>
                            <s:property value="username"/>
                        </td>
                        <td>
                            <s:property value="fullname"/>
                        </td>
                        <td>
                            <s:property value="role"/>
                        </td>
                        <td>
                            <s:url action="DeleteAction" id="DeleteLink">
                                <s:param name="id" value="%{username}"/>
                                <s:param name="lastSearchValue" value="searchValue"/>
                            </s:url>
                            <s:a href="%{DeleteLink}">Delete</s:a>
                        </td>
                        <td>
                        <s:form action="EditAction" method="POST">
                            <s:hidden name="id" value="%{username}"/>
                            <s:hidden name="lastSeachValue" value="%{searchValue}"/>
                        </s:form>
                        </td>
                    </tr>
                    </s:iterator>
                </tbody>
            </table>

        </s:if>
        <s:else>
            No record found!
        </s:else> 
    </body>
</html>
