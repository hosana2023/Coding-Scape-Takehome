//Marc Hosana 
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class solutions2 {
     private static final Map<String, String> dictionary = new HashMap<>();
     private static final ArrayList<String> extractedNumbers = new ArrayList<>();
     private static int sum = 0;
     static {
        dictionary.put("one", "1");
        dictionary.put("two", "2");
        dictionary.put("three", "3");
        dictionary.put("four", "4");
        dictionary.put("five", "5");
        dictionary.put("six", "6");
        dictionary.put("seven", "7");
        dictionary.put("eight", "8");
        dictionary.put("nine", "9");
     }
    public static void main(String[] args) {

        ArrayList<String> test = readFile("test2.txt");
    /* Extracts all the number from test ArrayList */
        for (String string : test) {
     extractNumbers(string);
     }
    /* Iterates through every converted string */
        for (String extracted : extractedNumbers) {
            numSummation(extracted);
        }
    System.out.print(sum);
}

    public static void extractNumbers(String string) {
     String extracted = ""; 
     int currentIndex = 0;
     while (currentIndex < string.length()) {
         String remainingString = string.substring(currentIndex);
         boolean foundMatch = false;
         for (String spelledOut : dictionary.keySet()) { /* Through every key value pair */
             if (remainingString.startsWith(spelledOut)) {   /* Checks to see if it starts with any key values */
                 String digit = dictionary.get(spelledOut); /* If succesfull, gets the value pair */
                 int endOfNumberIndex = currentIndex + spelledOut.length() - 1; 
                 extracted += digit;
                 currentIndex = endOfNumberIndex;
                 foundMatch = true;
                 break; /* Control flow goes back to for loop to iterate next string */
             }
             else if (Character.isDigit(remainingString.charAt(0))) {
                 // extractedNumbers.add(remainingString.substring(0,1));
                 extracted += remainingString.substring(0,1);
                 int endOfNumberIndex = currentIndex + 1;
                 currentIndex = endOfNumberIndex;
                 foundMatch = true;
                 break; /* Control flow goes back to for loop to iterate next string */
             }
         }
         if (!foundMatch) {
             /* If no spelled-out number was found at current index, move to the next character */ 
             currentIndex++;
         }
     }
     extractedNumbers.add(extracted);
}

    public static void numSummation(String string) {
        ArrayList<String> nums = new ArrayList<>();
        int num = 0;
        for (char c : string.toCharArray()) {
            int c_Code = (int)c;  /* Turns the char into its corresponding decimal value */

            if (c_Code >= 48 && c_Code <= 57) {   /* Checks to see if decimal value is within the 0-9 range */
                nums.add(String.valueOf(c)); /* Adds the number found into nums Arraylist as a string */
            }
        }
        if (nums.size() > 1) { /* If there 2 numbers found then will parse first/last numbers together */
            num = Integer.parseInt(nums.get(0) + nums.get(nums.size() - 1));
        } else { /* If there is only 1 number found, then will parse first number with first num */
            num = Integer.parseInt(nums.get(0) + nums.get(0)); 
        }
        sum += num; /* adds num to sum */
}

    public static ArrayList<String> readFile (String problemFile) {
        File file = new File(problemFile);
        ArrayList<String> results = new ArrayList<String>();
    
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) { // Loop will go through every line in the file
                results.add(scan.nextLine()); // Stores the line of data in the results ArrayList
                }
                scan.close();
        } catch (Exception e) {
            
        }
        return results;
    }
    
}
