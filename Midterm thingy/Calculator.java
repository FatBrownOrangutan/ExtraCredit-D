/**
 * Reads up to 30 values from a file and calculates the average
 *
 * Jesus Ochoa
 * @version (a version number or a date)
*/
//Allows for user imputs
import java.util.Scanner;

//Helps the program create a file to read data from
import java.io.File;

//Needed for catching errors
import java.io.FileNotFoundException;

//Need this for the values
import java.io.PrintWriter;

public class Calculator

{public static void salesfiles()
 {try (PrintWriter thingy = new PrintWriter("sales.txt"))
 {
 thingy.println(1510.0);
 thingy.println(120.0);
 thingy.println(1630.0);
 thingy.println(23450.0);
 thingy.println(230.0);
 thingy.println(13510.0);
 thingy.println(2410.0); 
 thingy.println(220.0); 
 thingy.println(1530.0); 
 System.out.println("sales.txt file made :D");}
 catch (FileNotFoundException e)
 {System.out.println("Error: Cannot create file due to error");}}

public static String filerequest()
    {Scanner kbinput = new Scanner(System.in);
     System.out.print("File name?");
     return kbinput.nextLine();}

public static double[] skibidisigmafiles(String filename)
{double total = 0.0;
 int count = 0;
 try {File file = new File(filename);
      Scanner filethingy = new Scanner(file);
      while (filethingy.hasNextDouble() && count < 30)
      {total += filethingy.nextDouble();
       count++;}
       filethingy.close();
      if (count < 30)
      {System.out.println("Less than 30 sales found");}}
 catch (FileNotFoundException e)
 {System.out.println("File not found");
  System.exit(1);}
return new double[] {total, count};}

public static void displayResults(double total, double average)
{System.out.printf("Total Sales: $%.10f\n", total);
 System.out.printf("Average Sales: $%.10f\n", average);}
 
 public static void main(String[] args)
{salesfiles();
    String filename = filerequest();
double[] result = skibidisigmafiles(filename);

double total = result[0];
int number = (int) result[1];

double average = (number > 0) ? total / number : 0.0;

displayResults(total, average);}}
