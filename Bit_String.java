
public class Bit_String {
  private String Userbit;
  static int signedMag = 0, onesComp = 0, twosComp = 0, excessNot = 0; //creates the decimal values for each of the representations
  static String finalSignedMag = "", finalOnesComp = "", finalTwosComp = "", finalExcessNot = "";  //creates string values for the representations so addition signs can be added if necessary
  
  public Bit_String(String bit) {   //sets the class variable to the binary string the user entered
    Userbit = bit;
  }
  public boolean isNegative() {     //checks to see if the binary number is negative
    boolean isNegative = false;
    if(Userbit.charAt(0) == '1') {  //if the string starts with a 1, the number is negative
      isNegative = true;
    } 
    return isNegative;
  }
  
  public void setBitSignedMag() {   //sets the value of the signed magnitude decimal output
    isNegative();   
    int j = 1;  //j will be the counter that represents the 2^0, 2^1, 2^2... as the bit numbers get larger
    int sum = 0; 
    for(int i = 1; Userbit.length() - i > 1; i++) {     //this for loop circles through each of the numbers in the binary string
      if(Userbit.charAt(Userbit.length()-i) == '1') {   //if the character contains a 1, the correct value will be added to the toal sum
        sum+=j;
      }
      j*=2; 
    }
    if(isNegative()) {  //if the binary number is negative, this makes the positive sum negative
      signedMag = -sum;
    }
    else { 
      signedMag = sum;
    }
  }
  
  public void setBitOnesComp() {    //sets the value of the ones compliment decimal output
    int sum = 0;
    int j = 1;  //j will be the counter that represents the 2^0, 2^1, 2^2... as the bit numbers
    if(isNegative()) { //checks if the binary string is negative, because the bits will need to be flipped
      for(int i = 1; Userbit.length() - i >= 1; i++) { //circles through all of the characters of the binary string
        if(Userbit.charAt(Userbit.length()-i) == '0') { //adds the value of j to the sum whenever the character is 0, because ones compliment has flipped bits. 
          sum+=j;
        }
        j*=2;
      }
    }
    else { //does the same cycle as signed magnitude since it is not negative
      for(int i = 1; Userbit.length() - i >= 1; i++) { 
        if(Userbit.charAt(Userbit.length()-i) == '1') {
          sum+=j;
        }
        j*=2;
      }
    }
    if(isNegative()) {
      onesComp = -sum;
    }
    else { 
      onesComp = sum;
    }
  }
  
  public void setBitTwosComp() {   //sets the value of twos compliment decimal
    if(onesComp >= 0) { //if the binary value is positive, twos compliment is equals to ones compliment
      twosComp = onesComp;  
    }
    else {  //if ones comp in negative, twos comp is equal to one less than ones comp
      twosComp = onesComp -1;
    }
  }
  
  public void setBitExcessNot() { //sets the value of the excess notation decimal value
    int sum = 0;
    int j = 1;
    for(int i = 1; Userbit.length() - i >= 0; i++) {    //cycles through the same for loop 
      if(Userbit.charAt(Userbit.length() - i) == '1') {
        sum+=j;
      }
      j*=2;
    }
     excessNot = sum - 128; //sets the value of the excess notation value by taking the unsigned binary value and subtracting 128 from it
  }
  
  public void isBitPositive() {  //checks if the values are positive, and adds addition signs to the front of the decimal value if they are
    setBitSignedMag();
    setBitOnesComp();
    setBitTwosComp();
    setBitExcessNot();
    if(signedMag > 0) 
      finalSignedMag = "+" + signedMag;
    else
    finalSignedMag = "" + signedMag;
    
    if(onesComp > 0)
      finalOnesComp = "+" + onesComp;
    else
    finalOnesComp = "" + onesComp;
    
    if(twosComp > 0)  
      finalTwosComp = "+" + twosComp;
    else
    finalTwosComp = "" + twosComp;
    
    if(excessNot > 0)  
      finalExcessNot = "+" + excessNot;
    else
    finalExcessNot = "" + excessNot;
    
  }
 
  public String getBitResults() //gets all of the results of the calculations in one return statement 
  {
    isBitPositive();
    return "\nSigned magnitude: " + finalSignedMag
        + "\nOnes complement: " + finalOnesComp
        + "\nTwos complement: " + finalTwosComp
        + "\nExcess-128 notation: " + finalExcessNot;
  }
}
