import java.util.Scanner;

public class Hangman_Game {
    public static String[] words = { "batman", "hangman", "programming", "java", "string", "sweet", "friend" };
    public static int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String SecretWord = words[(int) (Math.random() * words.length)];
        char[] GuessedWordArray = new char[SecretWord.length()];
        int attempts = 0;
        boolean gamewon = false;
        for (int i = 0; i < SecretWord.length(); i++) {
            GuessedWordArray[i] = '_';
        }
        System.out.println("--------WELLCOME TO HANGMAN--------");
        while (attempts < MAX_TRIES && !gamewon) {
            System.out.println("Secret Word " + String.valueOf(GuessedWordArray));
            System.out.println("Attempts remaining: " + ((MAX_TRIES - attempts)));
            System.out.println("Enter a letter : ");
            char Guess = sc.nextLine().charAt(0);
            boolean found = false;
            for (int i = 0; i < SecretWord.length(); i++) {
                if (SecretWord.charAt(i) == Guess) {
                    GuessedWordArray[i] = Guess;
                    found = true;
                }
            }
            if (!found) {
                attempts++;
                System.out.println("Incorrect Guess ! ");
            }
            if (String.valueOf(GuessedWordArray).equals(SecretWord)) {
                gamewon = true;
            }
        }
        if (gamewon) {
            System.out.println("\n Congratulations! You guessed the word: " + SecretWord);
        } else {
            System.out.println("\nSorry, you ran out of attempts. The word was: " + SecretWord);
        }
        sc.close();
    }
}