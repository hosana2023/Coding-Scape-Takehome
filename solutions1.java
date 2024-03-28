// Marc Hosana
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class solutions1 {
    private static int sum = 0;
    public static void main(String[] args) {
        ArrayList<String> test = readFile("test.txt"); /* Stores file data to test ArrayList */
        for (String string : test) {  /* Iterates through every string in test ArrayList */ 
            numSummation(string);
    }
    System.out.println(sum);
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
            while(scan.hasNextLine()) { /* Loop will go through every line in the file */
                results.add(scan.nextLine()); /*  Stores the line of data in the results ArrayList */
                }
                scan.close();
        } catch (Exception e) {
            
        }
        return results;
    }
}

