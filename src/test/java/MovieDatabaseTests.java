import models.BaseMovie;
import models.MovieDatabase;
import models.MovieFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MovieDatabaseTests {
    /**
     * This tests adding and deleting movies
     */
    @Test
    public void testAddDeleteMovie() {
        MovieDatabase database = new MovieDatabase();
        BaseMovie movieOne = MovieFactory.CreateMovie(MovieFactory.Genres.Comedy, "50 First Date", "2004", false);

        database.addMovie(movieOne);
        Assert.assertTrue(database.getMovieArchive().contains(movieOne));

        database.deleteMovie(movieOne);
        Assert.assertFalse(database.getMovieArchive().contains(movieOne));
    }

    /**
     * This tests finding movies
     */
    @Test
    public void testFindingMovies() {
        // Creates the movieDatabase instance and the testing variables
        MovieDatabase database = new MovieDatabase();
        BaseMovie movieOne = MovieFactory.CreateMovie(MovieFactory.Genres.Comedy, "50 First Date", "2004", false);
        BaseMovie movieTwo = MovieFactory.CreateMovie(MovieFactory.Genres.Comedy, "Overboard", "1987", false);

        // Adds both movies to the database
        database.addMovie(movieOne);
        database.addMovie(movieTwo);

        // Finds all movies by movie name that match the first movie and verify that the first movie is found
        List<BaseMovie> foundMovies = database.findMovieByTitle("50 First Date");
        Assert.assertTrue(foundMovies.contains(movieOne));

        // Finds all movies by year that match the second movie and verify that the second movie is found
        foundMovies = database.findMovieByYear("1987");
        Assert.assertTrue(foundMovies.contains(movieTwo));
    }
}