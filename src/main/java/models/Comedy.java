package models;

public class Comedy extends BaseMovie {
    /**
     * Creates an instance of the Comedy class
     * @param movieTitle The movie title
     * @param movieYear The movie year
     * @param checkoutStatus The movie check-out status
     */
    public Comedy(String movieTitle, String movieYear, boolean checkoutStatus) {
        super("Comedy", movieTitle, movieYear, checkoutStatus);
    }
}