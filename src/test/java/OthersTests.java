import models.Others;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OthersTests {
    /**
     * This test is for 'Getters'
     *      * @param movieTitle
     *      * @param movieYear
     *      * @param checkoutStatus
     */
    @Test
    public void testGetters() {
        String movieTitle = "Sister Act 2";
        String movieYear = "1993";

        Others comedy = new Others(movieTitle, movieYear, true);
        Assert.assertEquals(comedy.getGenre().toLowerCase(), "others");
        Assert.assertEquals(comedy.getMovieTitle(), movieTitle);
        Assert.assertEquals(comedy.getMovieYear(), movieYear);
        Assert.assertTrue(comedy.getCheckoutStatus());
    }
}
