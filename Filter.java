/*


*/

import java.util.Scanner;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * This program filters.
 * 
 * When playing with file filters, it is useful to know that "end-of-file" is
 * denoted at the command-line in Windows by Ctrl-Z and by Ctrl-D in Linux.
 */
public class Filter {
   public static void main(String[] args) {
      final Scanner in = new Scanner(System.in);
      int columns = 3; // Default number of columns.
      int precision = 13; // Default number of digits after a decimal point.
      int groups = 0; // Default size of a group. Zero means no groups.
      int groupsCounter = 0;
      int width = 4 + 1 + precision;
      String fmt = "%" + width + "." + precision + "f";
      while (in.hasNextDouble()) {
         int i;
         for (i = 0; i < columns; i++) {
            Double input = in.nextDouble();
            System.out.printf(fmt, input);
            System.out.print(" ");
         }
         if (groupsCounter == groups) {
            System.out.println("");
            groupsCounter = 0;
            i = 0;
         }
         groupsCounter++;
      }

   }
}
