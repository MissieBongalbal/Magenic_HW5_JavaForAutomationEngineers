package models;

public class Others extends BaseMovie {
    /**
     * Creates an instance of the Comedy class
     * @param movieTitle The movie title
     * @param movieYear The movie year
     * @param checkoutStatus The movie check-out status
     */
    public Others(String movieTitle, String movieYear, boolean checkoutStatus) {
        super("Others", movieTitle, movieYear, checkoutStatus);
    }
}