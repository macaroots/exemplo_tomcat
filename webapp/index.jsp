<%@page import="teste.Teste" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
Teste teste = new Teste();
String mensagem = (String) request.getAttribute("mensagem");
%><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
    <header>
        <img src="favicon.ico" />
        <nav>
            <ul>
                <li><a href="/LEA">Início</a></li>
                <li><a href="ola">Servlet doGet()</a></li>
                <li><a href="ola.jsp">JSP</a></li>
                <li><a href="chat.html">WebSocket</a></li>
                <li><a href="/LEA/ce">Agentes</a></li>
            </ul>
        </nav>
    </header>
    Olá!
    <main>
        <h1>Página inicial!</h1>
        <p>Mensagem do Servlet: <%=mensagem%></p>
        <p>Chamando classe externa: <%=teste.oi()%></p>
    </main>
</body>
</html>
