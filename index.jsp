<%-- 
    Document   : index
    Created on : Mar 20, 2016, 2:03:43 PM
    Author     : cavaji
    
    follow     :    https://twitter.com/Cavaji
                    https://plus.google.com/u/0/109777059100477708540
                    http://cavaji.blogspot.com/
                    https://www.facebook.com/Cavaji-Soft-292268400944940/
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page import="controller.UserManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JspHibernateCRUD</title>
    </head>
    <body>
        <h1>JspHibernateCRUD</h1>
        <br/>
        <%
            Object value = request.getAttribute("ftDate");
            out.println(value + "<br/>");
        %>
        <br/>
        <%
            UserManager usermgr = new UserManager();
            List<User> result = usermgr.read();
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <%  for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                        User user = (User) iterator.next();%>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getUsername()%></td>
                    <td><%=user.getPassword()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <br/><hr/>
        Insert Data..
        <br/>
        <form name="Insert" action="Servlet" method="POST">
            <input type="hidden" name="action" value="insert" />
            name : <input type="text" name="name" value="" /><br/>
            username : <input type="text" name="username" value="" /><br/>
            password : <input type="text" name="password" value="" /><br/>
            <input type="submit" value="save" name="submit" />
            <input type="reset" value="reset" name="reset" />
        </form>
        <%
            Object mInsert = request.getAttribute("m1");
            Object message3 = request.getAttribute("message");
            if (mInsert == "3") {
                %>
                <font style="color: red;"><%=message3%></font>
                <%
            }
        %>
        <br/><hr/>
        Delete Data..
        <br/>
        <form name="Delete" action="Servlet" method="POST">
            <input type="hidden" name="action" value="delete" />
            Delete Id : <input type="text" name="id" value="" /><br/>
            <input type="submit" value="Ok" name="submit" />
            <input type="reset" value="reset" name="reset" />
        </form>
        <%
            Object mDelete = request.getAttribute("m1");
            Object message1 = request.getAttribute("message");
            if (mDelete == "1") {
                %>
                <font style="color: red;"><%=message1%></font>
                <%
            }
        %>
        <br/><hr/>
        Update Data..
        <br/>
        <form name="Update" action="Servlet" method="POST">
            <input type="hidden" name="action" value="update" />
            Id : <input type="text" name="id" value="" /><br/>
            name : <input type="text" name="name" value="" /><br/>
            username : <input type="text" name="username" value="" /><br/>
            password : <input type="text" name="password" value="" /><br/>
            <input type="submit" value="save" name="submit" />
            <input type="reset" value="reset" name="reset" />
        </form>
        <%
            Object mUpdate = request.getAttribute("m1");
            Object message2 = request.getAttribute("message");
            if (mUpdate == "2") {
                %>
                <font style="color: red;"><%=message2%></font>
                <%
            }
        %>
        <br/><hr/>
    </body>
</html>
