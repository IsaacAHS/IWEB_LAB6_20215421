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
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value="/PeliculaServlet")
public class PeliculaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {

        PeliculaDaos peliculaDaos = new PeliculaDaos();

        ArrayList<Pelicula> listaPeliculas = peliculaDaos.listarPeliculas();

        request.setAttribute("lista", listaPeliculas);
        RequestDispatcher view = request.getRequestDispatcher("vistas/listaPeliculas.jsp");
        view.forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");
        PeliculaDaos peliculaDaos = new PeliculaDaos();
        switch(action){
            case "s":
                String textBuscar = request.getParameter("textoBuscar");
                ArrayList<Pelicula> lista = peliculaDaos.buscarPorTitulo(textBuscar);

                request.setAttribute("lista",lista);
                request.setAttribute("busqueda",textBuscar);
                request.getRequestDispatcher("vistas/listaPeliculas.jsp").forward(request,response);
        }
    }
}
