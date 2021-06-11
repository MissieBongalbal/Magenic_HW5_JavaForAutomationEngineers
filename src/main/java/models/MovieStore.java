package models;

import resources.OptionStrings;
import utilities.UserHelperMethods;
import java.util.*;

public class MovieStore {
    /**
     * The movie database instance
     */
    private MovieDatabase movieDatabase;

    /**
     * The scanner reference to read input from the user.
     */
    private Scanner scanner;

    /**
     * Creates an instance of the MovieStoreManager class
     */
    public MovieStore() {
        // Creates a new MovieDatabase
        this.movieDatabase = new MovieDatabase();

        // Sets the scanner to System.in
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets the Movie Database
     * @return the movie database
     */
    public MovieDatabase getMovieDatabase() {
        return movieDatabase;
    }

    /**
     * Sets the Song database
     * @param movieDatabase The new movie database
     */
    protected void setMovieDatabase(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    /**
     * Displays the main menu and handles the user choice
     */
    private void mainMenu() {
        // Displays the main menu options and deceivers the users choice
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(OptionStrings.MAIN_MENU_OPTIONS);
        String userChoiceText = OptionStrings.MAIN_MENU_OPTIONS[userChoice];

        // Checks for each of the options and handles accordingly
        if (userChoiceText.equals("Manage Movie")) {
            manageMenu();
        } else if (userChoiceText.equals("Viewing Option")) {
            viewingMenu();
        } else {
            System.out.println("ENDING PROGRAM...");
            System.out.println("Thank you for using this Movie Store!");
        }
    }

    /**
     * Displays the manage menu and handles the user choice
     */
    private void manageMenu() {
        // Displays the play menu options and deceivers the users choice
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(OptionStrings.MANAGE_MENU_OPTIONS);
        String userChoiceText = OptionStrings.MANAGE_MENU_OPTIONS[userChoice];

        // Checks for each of the options and handles accordingly
        if (userChoiceText.equals("Add Movie")) {
            MovieFactory.Genres genres = UserHelperMethods.getGenreInputFromPrompt("1. Comedy | 2. Others");
            String movieTitle = UserHelperMethods.getInputFromPrompt("Movie Title: ");
            String movieYear = UserHelperMethods.getInputFromPrompt("Movie Year: ");

            MovieFactory movieFactory = new MovieFactory();
            BaseMovie movieToAdd = movieFactory.CreateMovie(genres, movieTitle, movieYear, false);
            movieDatabase.addMovie(movieToAdd);
            System.out.println("Movie has been added!");
            System.out.println("");
        } else if (userChoiceText.equals("Remove Movie")) {
            // Takes the user input for the movie title then deletes the movie
            String movieTitle = UserHelperMethods.getInputFromPrompt("Which movie would you like to delete: ");
            BaseMovie movieToDelete = findMovie(movieTitle);
            movieDatabase.deleteMovie(movieToDelete);
        } else if (userChoiceText.equals("Rent a Movie")) {
            // Takes the user input for the movie title then update the movie checkout status
            String movieTitle = UserHelperMethods.getInputFromPrompt("Which movie would you like to rent: ");
            BaseMovie movieToRent = findMovie(movieTitle);
            boolean currentStatus = movieToRent.getCheckoutStatus();

            if (currentStatus == false) {
                movieToRent.setCheckoutStatus(true);
                System.out.println("Movie Title: " + movieToRent.getMovieTitle() + " is now being rented!");
            } else {
                System.out.println("Movie Title: " + movieToRent.getMovieTitle() + " is not available to be rented!");
            }

            System.out.println("");
        }

        // Returns to the Main Menu
        System.out.println("Returning to Main Menu...");
        mainMenu();
    }

    /**
     * Displays the viewing menu and handles the user choice
     */
    private void viewingMenu() {
        // Displays the play menu options and deceivers the users choice
        int userChoice = UserHelperMethods.displayOptionsAndWaitForValidOption(OptionStrings.VIEWING_MENU_OPTIONS);
        String userChoiceText = OptionStrings.VIEWING_MENU_OPTIONS[userChoice];

        // Checks for each of the options and handles accordingly
        if (userChoiceText.equals("Search by Title")) {
            String movieTitle = UserHelperMethods.getInputFromPrompt("What is the title of the movie you're looking for:");
            BaseMovie foundMovie = findMovie(movieTitle);
            if (foundMovie != null) {
                System.out.println("MOVIE: "
                        + foundMovie.getGenre()
                        + " | " + foundMovie.getMovieTitle()
                        + " | " + foundMovie.getMovieYear()
                        + " | " + foundMovie.getCheckoutStatus());
                System.out.println("");
            } else {
                System.out.println("No Search Result");
                System.out.println("");
            }
        } else if (userChoiceText.equals("Search by Year")) {
            String movieYear = UserHelperMethods.getInputFromPrompt("What is the year of the movie you're looking for:");
            BaseMovie foundMovie = findMovieYear(movieYear);
            if (foundMovie != null) {
                System.out.println("MOVIE: "
                        + foundMovie.getGenre()
                        + " | " + foundMovie.getMovieTitle()
                        + " | " + foundMovie.getMovieYear()
                        + " | " + foundMovie.getCheckoutStatus());
                System.out.println("");
            } else {
                System.out.println("No Search Result");
                System.out.println("");
            }
        }

        // Returns to the Main Menu
        System.out.println("Returning to Main Menu...");
        mainMenu();
    }

    /**
     * Finds the movie for the given title, if more than one movie is found, the user is prompted to select which movie from all found
     * @param movieTitle The movie title
     * @return The movie object
     */
    private BaseMovie findMovie(String movieTitle) {
        // Finds all songs that match the name in the database
        List<BaseMovie> foundMovies = movieDatabase.findMovieByTitle(movieTitle);

        // If no movies were found display a message to the user, and return null
        if (foundMovies.isEmpty()) {
            System.out.println("Movie: " + movieTitle +" was not found, returning to main menu:");
            return null;
        }

        // If only one movie matches return that movie
        else if (foundMovies.size() == 1) {
            return foundMovies.get(0);
        }

        // If multiple movies match call the displayOptionsAndWaitForValidOption method to have the user select from the movies
        else {
            int selectedMovieIndex = UserHelperMethods.displayOptionsAndWaitForValidOption(foundMovies);
            return foundMovies.get(selectedMovieIndex);
        }
    }

    /**
     * Finds the movie for the given year, if more than one movie is found, the user is prompted to select which movie from all found
     * @param movieYear The movie year
     * @return The movie object
     */
    private BaseMovie findMovieYear(String movieYear) {
        // Finds all songs that match the name in the database
        List<BaseMovie> foundMovies = movieDatabase.findMovieByYear(movieYear);

        // If no movies were found display a message to the user, and return null
        if (foundMovies.isEmpty()) {
            System.out.println("Movie: " + movieYear +" was not found, returning to main menu:");
            return null;
        }

        // If only one movie matches return that movie
        else if (foundMovies.size() == 1) {
            return foundMovies.get(0);
        }

        // If multiple movies match call the displayOptionsAndWaitForValidOption method to have the user select from the movies
        else {
            int selectedMovieIndex = UserHelperMethods.displayOptionsAndWaitForValidOption(foundMovies);
            return foundMovies.get(selectedMovieIndex);
        }
    }

    /**
     * The main method and console app
     * NOTE: This has some seed data, but you can add any data you'd like in this method, just make sure to create mps and call the main menu method at the end
     * @param args The list of arguments
     */
    public static void main(String[] args) {
        // Initializes the Movie Store console app
        MovieStore movieStore = new MovieStore();

        // Add new movie to the database for Comedy
        movieStore.movieDatabase.addMovie(new Comedy("Secret, Greatly", "2013", false));
        movieStore.movieDatabase.addMovie(new Comedy("Extreme Job", "2019", false));
        movieStore.movieDatabase.addMovie(new Comedy("Wedding Campaign", "2005", false));
        movieStore.movieDatabase.addMovie(new Comedy("Sunny", "2011", false));
        movieStore.movieDatabase.addMovie(new Comedy("Scandal Makers", "2008", false));
        movieStore.movieDatabase.addMovie(new Comedy("I Can Speak", "2017", false));

        // Add new movie to the database for Others
        movieStore.movieDatabase.addMovie(new Others("Secret Sunshine", "2007", false));
        movieStore.movieDatabase.addMovie(new Others("Poetry", "2010", false));
        movieStore.movieDatabase.addMovie(new Others("The Beauty Inside", "2015", false));
        movieStore.movieDatabase.addMovie(new Others("Burning", "2018", false));
        movieStore.movieDatabase.addMovie(new Others("Spring, Summer, Fall, Winter...and Spring", "2003", false));
        movieStore.movieDatabase.addMovie(new Others("Peppermint Candy", "1999", false));

        // Add rented movies
        movieStore.movieDatabase.addMovie(new Comedy("Miss Granny", "2014", true));
        movieStore.movieDatabase.addMovie(new Comedy("My Annoying Brother", "2016", true));
        movieStore.movieDatabase.addMovie(new Others("Ditto", "2000", true));
        movieStore.movieDatabase.addMovie(new Others("The Way Home", "2002", true));

        // Starts the application by opening the main menu
        movieStore.mainMenu();
    }
}
