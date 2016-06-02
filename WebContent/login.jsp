<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
	
	<jsp:useBean id="users" class="com.beans.UsersBean" scope="application" />
	
        <c:choose>
    <c:when test="${empty login}">
       <FORM ACTION="http://localhost:8080/TioProjekt/loginServlet"
      		 METHOD="POST">
    		You are not login <br>
    		<table>
    		<tr>
    			<td>login:</td>
		    	<td><INPUT TYPE="TEXT" NAME="login"></td>
		    </tr>
		    <tr>
		    <td>password:</td>
  			<td><INPUT TYPE="PASSWORD" NAME="password"></td>
  			</tr>
  			<tr>
  			<td><INPUT TYPE="SUBMIT" VALUE="login">	</td>
  			</tr>
  			</table> 
		</FORM>
    </c:when>
    <c:otherwise>
    	You are already login as: ${login} <br>
         <FORM ACTION="http://localhost:8080/TioProjekt/loginServlet"
      		 METHOD="POST">
  			<INPUT TYPE="SUBMIT" VALUE="logout">	 
		</FORM>
    </c:otherwise>
</c:choose>
        
    </body>
</html>
