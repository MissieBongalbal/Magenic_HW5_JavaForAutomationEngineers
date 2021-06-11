package models;

public class MovieFactory {
    /**
     * The Movie Genre
     */
    public enum Genres { Others, Comedy }

    /**
     * Creates a movie object with the given parameters
     * @param genres
     * @param movieTitle
     * @param movieYear
     * @param checkoutStatus
     */
    public static BaseMovie CreateMovie(Genres genres, String movieTitle, String movieYear, boolean checkoutStatus){
        // Switch based on movie type
        switch (genres) {
            case Comedy:
                return new Comedy(movieTitle, movieYear, checkoutStatus);
            case Others:
                return new Others(movieTitle, movieYear, checkoutStatus);

            // If the movie type is not set return null instead of the movie object
            default:
                return null;
        }
    }
}
