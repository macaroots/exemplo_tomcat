<%@page import="agenda.Teste" %>
<%
Teste teste = new Teste();
%><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>
<img src="favicon.ico" />
<h2>Bye, World!!! <%=teste.oi()%></h2>
<a href="ola.jsp">Olá</a>
</body>
</html>
