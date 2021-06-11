package models;

public abstract class BaseMovie {
    /**
     * The movie genre.
     */
    private String genre;

    /**
     * The movie title.
     */
    private String movieTitle;

    /**
     * The movie year.
     */
    private String movieYear;

    /**
     * The movie check-out status.
     */
    private boolean checkoutStatus;

    /**
     * Creates an instance of the BaseMovie class
     * @param genre The movie genre
     * @param movieTitle The movie title
     * @param movieYear The movie year
     * @param checkoutStatus The movie check-out status
     */
    public BaseMovie(String genre, String movieTitle, String movieYear, boolean checkoutStatus) {
        setGenre(genre);
        setMovieTitle(movieTitle);
        setMovieYear(movieYear);
        setCheckoutStatus(checkoutStatus);
    }

    /**
     * Gets the movie genre
     * @return The movie genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the Movie genre
     * @param genre The movie genre
     */
    public void setGenre(String genre) {
        if (genre != "") {
            this.genre = genre;
        } else {
            System.out.println("Genre is missing!");
        }
    }

    /**
     * Gets the movie title
     * @return The movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Sets the Movie title
     * @param movieTitle The movie title
     */
    public void setMovieTitle(String movieTitle) {
        if (movieTitle != "") {
            this.movieTitle = movieTitle;
        } else {
            System.out.println("Movie Title is missing!");
        }
    }

    /**
     * Gets the movie year
     * @return The movie year
     */
    public String getMovieYear() {
        return movieYear;
    }

    /**
     * Sets the Movie year
     * @param movieYear The movie year
     */
    public void setMovieYear(String movieYear) {
        if (movieYear != "") {
            this.movieYear = movieYear;
        } else {
            System.out.println("Movie year is missing!");
        }
    }

    /**
     * Gets the movie checkout status
     * @return The movie checkout status
     */
    public boolean getCheckoutStatus() {
        return checkoutStatus;
    }

    /**
     * Sets the Movie checkout status
     * @param checkoutStatus The movie checkout status
     */
    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }
}
