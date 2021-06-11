import models.Comedy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComedyTests {
    /**
     * This test is for 'Getters'
     *      * @param movieTitle
     *      * @param movieYear
     *      * @param checkoutStatus
     */
    @Test
    public void testGetters() {
        String movieTitle = "Sister Act";
        String movieYear = "1992";

        Comedy comedy = new Comedy(movieTitle, movieYear, true);
        Assert.assertEquals(comedy.getGenre().toLowerCase(), "comedy");
        Assert.assertEquals(comedy.getMovieTitle(), movieTitle);
        Assert.assertEquals(comedy.getMovieYear(), movieYear);
        Assert.assertTrue(comedy.getCheckoutStatus());
    }
}
