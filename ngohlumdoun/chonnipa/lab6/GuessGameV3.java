package ngohlumdoun.chonnipa.lab6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GuessGameV3 extends GuessGameV2 {
    private static final int MAX_GAMES = 100;
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];
    private static int recordIndex;
    private int[] guesses;
    private int guessCount;
    private boolean win;

    public GuessGameV3() {
        super();
        guessCount = 0;
        win = false;
        guesses = new int[getMaxTries()];
    }

    public GuessGameV3(int min, int max) {
        super(min, max);
        guessCount = 0;
        win = false;
        guesses = new int[getMaxTries()];
    }

    public GuessGameV3(int min, int max, int maxTries) {
        super(min, max, maxTries);
        guessCount = 0;
        win = false;
        guesses = new int[getMaxTries()];
    }

    public void configureGame(int min, int max) {
        super.configureGame(min, max);
    }

    @Override
    public void configureGame(int min, int max, int maxTries) {
        super.configureGame(min, max, maxTries);

        // // Reset the game settings by reinitializing the min, max, and maxTries
        // values.
        // setMin(min);
        // setMax(maxTries);
        // setMaxTries(maxTries);

        guessCount = 0;
        win = false;

        // Clear any data from the previous game.
        guesses = new int[getMaxTries()];
    }

    @Override
    public boolean playSingleGame() {
        generateAnswer();
        int min = getMin();
        int max = getMax();
        int answer = getAnswer();
        int maxTries = getMaxTries();

        guessCount = 0;
        // Display the welcome message
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");

        for (int i = 0; i < maxTries; i++) {
            // Get the user input number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userInput = input.nextInt();
            setUserInput(userInput);

            // Validate the user input between the min and max values
            while (min > userInput || max < userInput) {
                System.out.println("The number must be between " + min + " and " + max);

                System.out.print("Enter an integer between " + min + " and " + max + ":");
                userInput = input.nextInt();
            }

            // Store the user's guesses in an array
            guesses[i] = userInput;

            // Check if the user input is the target number
            guessCount++;
            setAttempts(guessCount);
            if (userInput == answer) {
                System.out.println("Congratulations! You've guessed the number in " + guessCount
                        + ((guessCount > 1) ? " attempts" : " attempt"));

                win = true;
                break;

            } else if (userInput > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        if (!win)
            // Display the number of attempts made by the user
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);

        addGameRecord(this);
        return win;
    }

    public String getGameLog() {
        // Copy the guesses array to a new array to avoid modifying the original array
        int[] eachGameGuess = Arrays.copyOf(guesses, guessCount);
        String showEachGameGuess = Arrays.toString(eachGameGuess).replace("[", "").replace("]", "");

        // Format the game log to display the guesses for each game
        String gameLog = "Range: [" + getMin() + "-" + getMax() + "], Max Tries: " + getMaxTries() + ", Attempts: "
                + getAttempts() + ", Result: " + (win ? "Win" : "Lose") + ", Guesses: " + showEachGameGuess.toString();
        return gameLog;
    }

    public void addGameRecord(GuessGameV3 game) {
        // Check if the game record array is full before adding a new game record
        if (recordIndex < MAX_GAMES) {
            gameRecords[recordIndex] = game;
            recordIndex++;
        }
    }

    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    public static int getRecordCount() {
        return recordIndex;
    }

    @Override
    public String toString() {
        return getGameLog();
    }
}
