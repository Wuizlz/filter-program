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
      int columns = 7; // Default number of columns.
      int precision = 6; // Default number of digits after a decimal point.
      int groups = 12; // Default size of a group. Zero means no groups.
      int groupsCounter = 1;
      int colCounter = 1;
      int width = 4 + 1 + precision;
      String fmt = "%" + width + "." + precision + "f";
      while (in.hasNextDouble()) {
         if (colCounter <= columns && (groupsCounter <= groups || groups == 0)) {
            colCounter++;
            groupsCounter++;
            double input = in.nextDouble();
            System.out.printf(fmt, input);
            System.out.print(" ");
         } else if (colCounter > columns) {
            System.out.println();
            colCounter = 1;
         } else if (groupsCounter > groups) {
            System.out.println("\n");
            groupsCounter = 1;
            colCounter = 1;
         }

      }
      in.close();
   }

}
