<%--
  Created by IntelliJ IDEA.
  User: Isaac
  Date: 31/05/2024
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab620215421.beans.Actor" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Actor> lista = (ArrayList<Actor>) request.getAttribute("lista");

%>
<html>
<head>
    <title>Actores </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Actores de la Película: <%= lista.get(1).getTitulo() %></h1>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>Id Actor</th>
            <th>Nombre</th> 
            <th>Apellido</th>
            <th>Anio de Nacimiento</th>
            <th>Ha Ganado Oscar</th>
        </tr>
        <% for (Actor actor : lista) { %>
        <tr>
            <td><%= actor.getIdActor() %></td>
            <td><%= actor.getNombre() %></td>
            <td><%= actor.getApellido() %></td>
            <td><%= actor.getAnoNacimiento() %></td>
            <td><%= actor.isPremioOscar() ? "Sí" : "No" %></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>
