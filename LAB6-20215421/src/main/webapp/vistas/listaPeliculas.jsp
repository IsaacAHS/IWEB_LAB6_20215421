<%--
  Created by IntelliJ IDEA.
  User: Isaac
  Date: 31/05/2024
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab620215421.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) request.getAttribute("lista");
%>

<html>
<head>
    <title>Peliculas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Lista de Peliculas</h1>
    <form method="post" action="<%=request.getContextPath()%>/PeliculaServlet?action=s">
        <div class="row">
            <div class="col">
                <div class="form-floating mt-3">
                    <input type="text" class="form-control" id="floatingInput"
                           placeholder="Por ID o por nombre" name="textoBuscar" value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
                    <label for="floatingInput">Buscar pelicula</label>
                </div>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary mt-3">Buscar</button>
            </div>
        </div>

    </form>

    <table class="table table-striped mt-3">
        <tr class="table-primary">

            <th>Titulo</th>
            <th>Director</th>
            <th>Anio Publicacion</th>
            <th>Rating</th>
            <th>BoxOffice</th>
            <th>Genero</th>
            <th>Actores</th>

        </tr>
        <% for (Pelicula i : listaPeliculas) { %>
        <tr>
            <td><a href="<%=request.getContextPath()%>/DetallesServlet?idPelicula=<%=i.getIdPelicula()%>">
                <%=i.getTitulo() %>
            </a></td>
            <td><%=i.getDirector()%>
            </td>
            <td><%=i.getAnoPublicacion()%>
            </td>
            <td><%=i.getRating()%>/10
            </td>
            <td><%=i.getBoxOffice()%>
            </td>
            <td><%=i.getNombreGenero()%>
            </td>

            <td>
                <a href="<%= request.getContextPath() %>/actorServlet?idPelicula=<%= i.getIdPelicula() %>">Ver Actores</a>
            </td>

        </tr>
        <% } %>


    </table>
</div>


</body>
</html>
