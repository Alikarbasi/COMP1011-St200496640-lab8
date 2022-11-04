package com.example.comp1011st200496640lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Netflix {
    private String title,type,rating,director,cast;
    private int showId;

    public Netflix(String title, String type, String rating, String director, String cast, int showId) {
        setTitle(title);
        setType(type);
        setRating(rating);
        setDirector(director);
        setCast(cast);
        setShowId(showId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length()>=2)
        this.title = title;
        else
            throw new IllegalArgumentException("title must have at least 2 characters");
    }

    public static List<String> getValidType(){
        return Arrays.asList("Movie","TvShow");
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(getValidType().contains(type))
        this.type = type;
        else
            throw new IllegalArgumentException("type should be one of these : "+getValidType());
    }

    public static List<String> getValidRating(){
        return Arrays.asList("PG-13","R","TV-14","TV-G","TV-MA","TV-Y","TV-Y7");
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        if(getValidRating().contains(rating))
        this.rating = rating;
        else
            throw new IllegalArgumentException("Rating should be from this list: "+getValidRating());
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if(director.length()>=5)
        this.director = director;
        else
            throw new IllegalArgumentException("Director must have at leas 5 characters");
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        if(cast.length()>=6)
        this.cast = cast;
        else
            throw new IllegalArgumentException("Cast must have at least 6 characters");
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        if(showId>=0)
            this.showId = showId;
        else
            throw new IllegalArgumentException("Show Id must be greater than 0");
    }
}

