import java.util.Scanner;

/*
  Version: March 27, 2021
  This version will always display an invalid age (0).
*/
/*Ahmedh Shamsudeen
UCID 30121541
A5 Version 1.0
Tutorial 7
Purpose:Take sinput and determines if it is within range of 1-144
Contains;Static varaible age which holds user input.
Features;
-Will keep asking for user input until it is within the range of 1-144 
Limitations:
-can only work if age is static, and no letters are inputed*/

public class RecursiveDriver
{
    public static final int MIN_AGE = 1;
    public static final int MAX_AGE = 144;
    public static Scanner in = new Scanner(System.in);
    
 
    //Student portion of the assignment
    //Student's need modify the method so it returns a value within the
    //valid range back to the main method.

    public static int age;
    public static int promptForAge()
    {
        System.out.print("Enter Age(1-144): ");
        age = in.nextInt();
        if (!(age >= 1 && age <= 144)){
            promptForAge();
        }
        
        return(age);
        
    }
    // End student portion

    public static void main(String [] args)
    {
        int age = 0;
        age = promptForAge();  
        System.out.println("Age: " + age);        
    }
}