<%--
  Created by IntelliJ IDEA.
  User: Isaac
  Date: 31/05/2024
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.lab620215421.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
%>

<html>
<head>
    <title><%= pelicula.getTitulo() %></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Detalles de la Pelicula: <%= pelicula.getTitulo() %></h1>
    <table class="table table-striped mt-3">
        <tr>
            <th>ID Pelicula</th>
            <td><%= pelicula.getIdPelicula() %></td>
        </tr>
        <tr>
            <th>Titulo</th>
            <td><%= pelicula.getTitulo() %></td>
        </tr>
        <tr>
            <th>Director</th>
            <td><%= pelicula.getDirector() %></td>
        </tr>
        <tr>
            <th>Año Publicación</th>
            <td><%= pelicula.getAnoPublicacion() %></td>
        </tr>
        <tr>
            <th>Rating</th>
            <td><%= pelicula.getRating() %>/10</td>
        </tr>
        <tr>
            <th>BoxOffice</th>
            <td><%= pelicula.getBoxOffice() %></td>
        </tr>
        <tr>
            <th>Genero</th>
            <td><%= pelicula.getNombreGenero() %></td>
        </tr>

        <tr>
            <th>Ver Actores</th>
            <td><a href="<%= request.getContextPath() %>/actorServlet?idPelicula=<%= pelicula.getIdPelicula() %>" >Ver Actores</a></td>
        </tr>

    </table>
</div>
</body>
</html>

