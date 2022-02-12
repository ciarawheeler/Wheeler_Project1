import java.util.Scanner;
public class Project_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    //creates scanner to read user input
    int userChoice; 
    System.out.println("Return 8 if you would like to enter an 8-bit string, "  //prompts user to enter 8 for binary or 1 for decimal input
        + "or 1 if you would like to return a signed decimal integer:");
    userChoice = sc.nextInt();
    if(userChoice == 8) //if the user chooses 8, or a binary string, this code will run
    {
      System.out.println("Please enter the 8-bit String with no spaces, followed by the enter key.");   //prompts the user to enter the 8-bit string
      String userBit = sc.next();   
      Bit_String bitString = new Bit_String(userBit);   //creates an object of the Bit_String class and setting it to the users entered value
      System.out.println(bitString.getBitResults());    //prints the results of the calculations of all representations
    }
    else if(userChoice == 1) //if the user chooses 1, or a signed decimal, this code will run
    {
      System.out.println("Please enter the signed decimal integer followed by the enter key."); //prompts the user to enter a signed decimal integer
      int userDec = sc.nextInt();
      Decimal_Int decInt = new Decimal_Int(userDec);    //creates an object of the Decimal_Int class and sets it to the value entered by the user
      System.out.println(decInt.getDecResults());   //prints out the results of the calculations for all representations
    }
    else {  //if the user entered an invalid option, this error will print out
      System.out.println("That was not a valid choice. Rerun program.");
    }
  }
  
}
