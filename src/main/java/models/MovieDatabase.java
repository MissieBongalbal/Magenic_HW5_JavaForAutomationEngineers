package models;

import java.util.*;

public class MovieDatabase {
    /**
     * Unique list of every movie in the models.MovieDatabase
     */
    private ArrayList<BaseMovie> movieArchive;

    /**
     * Creates an instance of the MovieDatabase class
     */
    public MovieDatabase() {
        movieArchive = new ArrayList<BaseMovie>();
    }

    /**
     * Gets the movie archive
     * @return the movie archive
     */
    public ArrayList<BaseMovie> getMovieArchive() {
        return movieArchive;
    }

    /**
     * Adds the given movie to the movie archive
     * @param newMovie The movie to be added
     */
    public void addMovie(BaseMovie newMovie) {
        if(!movieArchive.contains(newMovie)) {
            movieArchive.add(newMovie);
        } else {
            System.out.println("Movie is already listed!");
        }
    }

    /**
     * Deletes the given movie from the movie archive
     * @param deleteMovie The movie to be deleted
     */
    public void deleteMovie(BaseMovie deleteMovie) {
        if (movieArchive.contains(deleteMovie)) {
            movieArchive.remove(deleteMovie);
            System.out.println("Movie has been deleted!");
            System.out.println("");
        } else {
            System.out.println("Movie is no longer listed!");
        }
    }

    /** Returns a List of models Movie objects from archive, and an empty list if no movies are found
     * @param movieTitle The movie title
     * @return The List of models Movie objects, and an empty list if no movies are found
     */
    public List<BaseMovie> findMovieByTitle(String movieTitle) {
        List<BaseMovie> movieLists = new ArrayList<BaseMovie>();

        for (BaseMovie movie : movieArchive) {
            if (movie.getMovieTitle().equals(movieTitle)) {
                movieLists.add(movie);
            }
        }

        return movieLists;
    }

    /** Returns a List of models Movie objects from archive, and an empty list if no movies are found
     * @param movieYear The movie year
     * @return The List of models Movie objects, and an empty list if no movies are found
     */
    public List<BaseMovie> findMovieByYear(String movieYear) {
        List<BaseMovie> movieLists = new ArrayList<BaseMovie>();

        for (BaseMovie movie : movieArchive) {
            if(movie.getMovieYear().equals(movieYear)) {
                movieLists.add(movie);
            }
        }

        return movieLists;
    }
}
