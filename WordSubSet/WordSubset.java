/**
 * Program Name: WordSubset.java
 * Author: Ibrahin Gonzalez
 * Class: COP337 RVC 12248
 * Professor Caryl Rahn
 * Assignment: Assignment 8
 * Date: 11/17/2024
 * Description: This program generates all possible subsets of a given string
 * entered by the user using a recursive method. Subsets include empty strings
 * and combinations of characters in any order.
 * 
 * The program demonstrates recursion by iterating through all possible
 * combinations of the input string and printing them.
 */

 import java.util.Scanner;

 public class WordSubset {
 
     /**
      * Main method to take user input and initiate the recursive generation of subsets.
      * 
      * @param args Command line arguments (not used)
      */
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter a string: ");
         String input = scanner.nextLine();
         
         System.out.println("All subsets of the string \"" + input + "\":");
         generateSubsets(input, "", 0);
 
         scanner.close();
     }
 
     /**
      * Recursive method to generate all possible subsets of the given word.
      * 
      * @param input The original string entered by the user
      * @param current The current subset being formed
      * @param index The current index in the input string being considered
      */
     public static void generateSubsets(String input, String current, int index) {
         // Base case: Print the current subset when the index reaches the end of the input.
         if (index == input.length()) {
             System.out.println(current);
             return;
         }
 
         // Recursive case: Include the character at the current index.
         generateSubsets(input, current + input.charAt(index), index + 1);
 
         // Recursive case: Exclude the character at the current index.
         generateSubsets(input, current, index + 1);
     }
 }
 