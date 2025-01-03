package ngohlumdoun.chonnipa.lab6;

public class GuessGameV2 extends GuessGame {
    public GuessGameV2() {
        super();
    }

    public GuessGameV2(int min, int max) {
        super(min, max);
    }

    public GuessGameV2(int min, int max, int maxTries) {
        super(min, max, maxTries);
    }

    public void configureGame(int min, int max) {

        // Validate the min and max input
        while (min > max) {
            System.out.println("Invalid input: max must be greater than or equal to min.");

            System.out.print("Enter the min value:");
            min = input.nextInt();

            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
        setMin(min);
        setMax(max);

    }

    @Override
    public void configureGame(int min, int max, int maxTries) {

        // Validate the maximum number of tries input
        while (0 >= maxTries) {
            System.out.println("Invalid input: maxTries must be greater than 0.");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
        setMaxTries(maxTries);

    }

    @Override
    public boolean playSingleGame() {
        generateAnswer();
        int min = getMin();
        int max = getMax();
        int answer = getAnswer();
        int maxTries = getMaxTries();
        boolean answerCorrectly = false;

        int attempts = 0;
        // Display the welcome message
        System.out.println("Welcome to a number guessing game!");

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

            // Check if the user input is the target number
            attempts++;
            setAttempts(attempts);
            if (userInput == answer) {
                System.out.println("Congratulations! You've guessed the number in " + attempts
                        + ((attempts > 1) ? " attempts" : " attempt"));

                answerCorrectly = true;
                break;

            } else if (userInput > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }
        }

        if (!answerCorrectly)
            // Display the number of attempts made by the user
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);

        return answerCorrectly;
    }

    @Override
    public String toString() {
        int min = getMin();
        int max = getMax();
        int maxTries = getMaxTries();
        int attempts = getAttempts();

        return "Game Configuration: [Min: " + min + ", Max: " + max + ", Max Tries: " + maxTries + ", Attempts: "
                + attempts + "]";
    }
}
