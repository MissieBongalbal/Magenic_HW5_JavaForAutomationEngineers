import models.BaseMovie;
import models.MovieFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseMovieTests {
    /**
     * Generically tests the 'getter' methods for each shape using the Movie Factory
     */
    @Test
    public void GettersTest() {
        // Initializes a generic movie object that will hold our genres (like comedy)
        BaseMovie movie = null;

        // The desired movieTitle, movieYear and checkoutStatus used for testing
        String movieTitle = "Sister Act";
        String movieYear = "1992";

        // Creates a Movie and validates the 'Getters' using the MovieFactory
        movie = MovieFactory.CreateMovie(MovieFactory.Genres.Comedy, movieTitle, movieYear, true);
        Assert.assertEquals(movie.getGenre().toLowerCase(), "comedy");
        Assert.assertEquals(movie.getMovieTitle(), movieTitle);
        Assert.assertEquals(movie.getMovieYear(), movieYear);
        Assert.assertTrue(movie.getCheckoutStatus());
    }
}
