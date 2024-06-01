package com.example.lab620215421.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.lab620215421.beans.Pelicula;
import com.example.lab620215421.daos.PeliculaDaos;

import java.io.IOException;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        //String id = request.getParameter("id");
        /*if (id != null && !id.isEmpty()) {
            PeliculaDaos peliculaDaos = new PeliculaDaos();
            Pelicula pelicula = peliculaDaos.obtenerPeliculaPorId(Integer.parseInt(id));

            if (pelicula != null) {
                request.setAttribute("pelicula", pelicula);
                RequestDispatcher view = request.getRequestDispatcher("vistas/viewPelicula.jsp");
                view.forward(request, response);
            } else {
                response.sendRedirect("error.jsp"); // Página de error en caso de que no se encuentre la incidencia
            }
        } else {
            response.sendRedirect("error.jsp"); // Página de error en caso de que el ID sea nulo o vacío
        }*/


        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));


        PeliculaDaos peliculaDaos = new PeliculaDaos();
        Pelicula pelicula = peliculaDaos.obtenerPeliculaPorId(idPelicula);


        request.setAttribute("pelicula", pelicula);


        RequestDispatcher view = request.getRequestDispatcher("vistas/viewPelicula.jsp");
        view.forward(request, response);
    }
}

