import java.io.*;
import java.util.*;

public class WordListComparatorDemo {

    // Define the Scrabble letter values
    private static final Map<Character, Integer> scrabbleValues = new HashMap<>();

    static {
        scrabbleValues.put('A', 1);
        scrabbleValues.put('E', 1);
        scrabbleValues.put('I', 1);
        scrabbleValues.put('O', 1);
        scrabbleValues.put('U', 1);
        scrabbleValues.put('L', 1);
        scrabbleValues.put('N', 1);
        scrabbleValues.put('S', 1);
        scrabbleValues.put('T', 1);
        scrabbleValues.put('R', 1);
        scrabbleValues.put('D', 2);
        scrabbleValues.put('G', 2);
        scrabbleValues.put('B', 3);
        scrabbleValues.put('C', 3);
        scrabbleValues.put('M', 3);
        scrabbleValues.put('P', 3);
        scrabbleValues.put('F', 4);
        scrabbleValues.put('H', 4);
        scrabbleValues.put('V', 4);
        scrabbleValues.put('W', 4);
        scrabbleValues.put('Y', 4);
        scrabbleValues.put('K', 5);
        scrabbleValues.put('J', 8);
        scrabbleValues.put('X', 8);
        scrabbleValues.put('Q', 10);
        scrabbleValues.put('Z', 10);
    }

    // Method to calculate the scrabble score of a word
    public static int getScrabbleValue(String word) {
        int value = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            value += scrabbleValues.getOrDefault(c, 0);
        }
        return value;
    }

    // Comparator that compares words based on their scrabble value
    public static class ScrabbleComparator implements Comparator<String> {
        @Override
        public int compare(String word1, String word2) {
            return Integer.compare(getScrabbleValue(word1), getScrabbleValue(word2));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();

        // Ask the user to input the file path
        System.out.print("Please enter the file path for wordlist.txt: ");
        String filePath = scanner.nextLine();

        // Read words from file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort the word list using the ScrabbleComparator
        Collections.sort(wordList, new ScrabbleComparator());

        // Print the sorted words as a comma-separated list
        System.out.println("Sorted words by Scrabble value:");
        System.out.println(String.join(", ", wordList));
    }
}
