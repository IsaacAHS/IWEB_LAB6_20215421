package com.example.lab620215421.daos;

import com.example.lab620215421.beans.Pelicula;
import com.example.lab620215421.beans.Actor;


import java.sql.*;
import java.util.ArrayList;

public class PeliculaDaos {
    public static ArrayList<Pelicula> listarPeliculas(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        String url ="jdbc:mysql://localhost:3306/mydb";
        String username="root";
        String password= "root";

        String sql= "select pe.idPelicula,pe.titulo, pe.director , pe.anopublicacion, pe.rating,pe.boxOffice, ge.nombre\n" +
                "from pelicula pe\n" +
                "join genero ge\n" +
                "where pe.idGenero=ge.idGenero\n" +
                "order by rating desc, boxOffice desc;";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setDirector(rs.getString(3));
                pelicula.setAnoPublicacion((rs.getInt(4)));
                pelicula.setRating(rs.getDouble(5));
                pelicula.setBoxOffice(rs.getDouble(6));
                pelicula.setNombreGenero(rs.getString(7));

                listaPeliculas.add(pelicula);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listaPeliculas;


    }

    public ArrayList<Pelicula> buscarPorTitulo(String name){

        ArrayList<Pelicula> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";


        String sql = "SELECT pe.titulo, pe.director, pe.anopublicacion, pe.rating, pe.boxOffice, ge.nombre " +
                "FROM pelicula pe " +
                "JOIN genero ge ON pe.idGenero = ge.idGenero " +
                "WHERE pe.titulo LIKE ? " +
                "ORDER BY rating DESC, boxOffice DESC;";


        //String sql = "select * from pelicula where lower(titulo) like lower(?);";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //pstmt.setString(1,name);
            pstmt.setString(1, name + "%");

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setTitulo(rs.getString(1));
                    pelicula.setDirector(rs.getString(2));
                    pelicula.setAnoPublicacion((rs.getInt(3)));
                    pelicula.setRating(rs.getDouble(4));
                    pelicula.setBoxOffice(rs.getDouble(5));
                    pelicula.setNombreGenero(rs.getString(6));

                    lista.add(pelicula);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


    public Pelicula obtenerPeliculaPorId(int id) {
        //Pelicula pelicula = null;
        Pelicula pelicula = new Pelicula();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "SELECT pe.idPelicula, pe.titulo, pe.director, pe.anopublicacion, pe.rating, pe.boxOffice, ge.nombre " +
                "FROM pelicula pe " +
                "JOIN genero ge ON pe.idGenero = ge.idGenero " +
                "WHERE pe.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    //pelicula = new Pelicula();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    pelicula.setNombreGenero(rs.getString(7));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }

    public ArrayList<Actor> obtenerActores(int id){

        ArrayList<Actor> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";


        String sql = "SELECT a.idActor, a.Nombre, a.Apellido, a.anoNacimiento, a.premioOscar, p.idPelicula, p.titulo \n" +
                "FROM actor a \n" +
                "JOIN protagonistas pr ON a.idActor = pr.idActor \n" +
                "JOIN pelicula p ON pr.idPelicula=p.idPelicula\n" +
                "WHERE pr.idPelicula LIKE ?";



        //String sql = "select * from pelicula where lower(titulo) like lower(?);";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //pstmt.setString(1,name);
            pstmt.setInt(1, id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(rs.getInt(1));
                    actor.setNombre(rs.getString(2));
                    actor.setApellido(rs.getString(3));
                    actor.setAnoNacimiento(rs.getInt(4));
                    actor.setPremioOscar(rs.getBoolean(5));
                    actor.setIdPelicula(rs.getInt(6));
                    actor.setTitulo(rs.getString(7));

                    lista.add(actor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }




}
