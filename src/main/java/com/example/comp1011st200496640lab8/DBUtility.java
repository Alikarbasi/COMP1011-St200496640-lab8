package com.example.comp1011st200496640lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    public static String user = "student";
    public static String pw = "student";
    private static String connectUrl = "jdbc:mysql://127.0.0.1:3306/javatest";

    public static ArrayList<Netflix> getShowsFromDB() {
        ArrayList<Netflix> shows = new ArrayList<>();
        String sql = "SELECT showId,title,type,rating,director,cast FROM netflix";
        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

        ) {
            while (resultSet.next()) {

                int showId=resultSet.getInt("showId");
                String  title=resultSet.getString("title");
                String type= resultSet.getString("type");
                String rating= resultSet.getString("rating");
                String director = resultSet.getString("director");
                String cast = resultSet.getString("cast");

                Netflix newShow=new Netflix(title,type,rating,director,cast,showId);
                shows.add(newShow);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return shows;
    }
    public static ArrayList<String> getRatingFromDB() {
        ArrayList<String> ratings = new ArrayList<>();
        String sql = "SELECT distinct rating FROM netflix";
        try (
                Connection conn = DriverManager.getConnection(connectUrl, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

        ) {
            while (resultSet.next()) {

                String rating= resultSet.getString("rating");
                ratings.add(rating);


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ratings;
    }



}
