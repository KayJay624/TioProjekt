<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <!-- <META HTTP-EQUIV="Refresh"  CONTENT="1; URL=main.jsp"> -->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
     <jsp:useBean id="koszyk" class="com.beans.OrderBean" scope="session"/>
     
     <c:if test="${!empty param.action and !empty param.id_position}">
         <c:choose>
             <c:when test="${param.action =='add'}">
                 Dodano do koszyka.
                 <jsp:setProperty name="koszyk" property="newItem" value="${param.id_position}"/>
                  <a href="neworder.xhtml">Powrót</a>
             </c:when>
             <c:when test="${param.action == 'remove'}">
                 <jsp:setProperty name="koszyk" property="removeItem" value="${param.id_position}"/>
                 Usunięto z koszyka.
                 <a href="zawartoscKoszyka.jsp">Powrót</a>
             </c:when>
             <c:otherwise>
                 Błąd!
             </c:otherwise>
         </c:choose>
         
     </c:if>
 </body>
</html>