package all_projects.Text_File_Analyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text File Analyzer!");
        System.out.print("Enter the path to the text file: ");
        String filePath = scanner.nextLine();

        try {

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found! Please check the path and try again.");
                return;
            }

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            // Read the file with proper encoding (UTF-8)
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+"); // Split by whitespace (words)
                wordCount += words.length;
            }

            reader.close();

            // Display analysis
            System.out.println("\nFile Analysis:");
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Characters: " + charCount);


            System.out.print("\nEnter a search term (word, number, or symbol): ");
            String searchTerm = scanner.nextLine();
            System.out.print("Do you want to search for [1] word, [2] number, or [3] symbol? (Enter 1, 2, or 3): ");
            int searchChoice = Integer.parseInt(scanner.nextLine());

            int occurrences = 0;
            switch (searchChoice) {
                case 1:
                    occurrences = countWordOccurrences(filePath, searchTerm);
                    break;
                case 2:
                    occurrences = countNumberOccurrences(filePath, searchTerm);
                    break;
                case 3:
                    occurrences = countSymbolOccurrences(filePath, searchTerm);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            System.out.println("The search term \"" + searchTerm + "\" appears " + occurrences + " times.");

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int countWordOccurrences(String filePath, String searchWord) throws IOException {
        int occurrences = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(searchWord)) {
                    occurrences++;
                }
            }
        }

        reader.close();
        return occurrences;
    }

    private static int countNumberOccurrences(String filePath, String searchNumber) throws IOException {
        int occurrences = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(searchNumber)) {
                    occurrences++;
                }
            }
        }

        reader.close();
        return occurrences;
    }


    private static int countSymbolOccurrences(String filePath, String searchSymbol) throws IOException {
        int occurrences = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (String.valueOf(line.charAt(i)).equals(searchSymbol)) {
                    occurrences++;
                }
            }
        }

        reader.close();
        return occurrences;
    }
}
