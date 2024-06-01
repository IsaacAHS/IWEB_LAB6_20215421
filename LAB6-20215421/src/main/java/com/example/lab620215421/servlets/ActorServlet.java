package com.example.lab620215421.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.lab620215421.beans.Pelicula;
import com.example.lab620215421.daos.PeliculaDaos;
import com.example.lab620215421.beans.Actor;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "actorServlet", value = "/actorServlet")
public class ActorServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));


        PeliculaDaos peliculaDaos = new PeliculaDaos();
        ArrayList<Actor> lista = peliculaDaos.obtenerActores(idPelicula);


        request.setAttribute("lista",lista);




        RequestDispatcher view = request.getRequestDispatcher("vistas/listaActores.jsp");
        view.forward(request, response);
    }

}
