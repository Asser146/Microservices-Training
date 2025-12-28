package com.example.MovieCatalog.models;

public class Rating {
    private int movieId;
    private  int movieRating;

    public Rating(int movieId, int movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public Rating() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
