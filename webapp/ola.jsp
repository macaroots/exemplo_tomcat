<%
String nome = (String) request.getAttribute("nome");
String telefone = (String) request.getAttribute("telefone");
%><!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>
<img src="favicon.ico" />
<h2>Olá, <%=nome%>! Telefone: <%=telefone%></h2>

    <form action="ola" method="post">
        <label>
            Nome: <input name="nome" />
        </label>
        <label>
            Telefone: <input name="telefone" />
        </label>
        <button>Ok</button>
    </form>
</body>
</html>
