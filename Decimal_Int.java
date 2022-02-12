
public class Decimal_Int {
  private int decNum;
  static String signedMag = "", onesComp = "", twosComp = "", excessNot = "";   //creates variables to store all of the converted values
  
  public Decimal_Int(int dec) {     //assigns the users value to the decimal int variable
    decNum = dec;
  }
  
  public boolean isNegative() {     //checks if the decimal number is negative
    boolean isNegative = false;
    if(decNum < 0) 
      isNegative = true;
    return isNegative;
  }
  
  public void setDecSignedMag() { 	//sets the signed magnitude binary representation of the decimal number
    if(isNegative()) {  //if the decimal is negative, run the following code
      int positiveDecNum = Math.abs(decNum);    //takes away the negative from the number
      signedMag = Integer.toBinaryString(positiveDecNum);   //automatically turns the positive decimal to binary
      switch(signedMag.length()) { //adds enough numbers to the beginning of the number in order to bmake it 8-bit
       case 1 : signedMag = "1000000" + signedMag; break;   //has a one as the MSB because it is negative.
       case 2 : signedMag = "100000" + signedMag; break;
       case 3 : signedMag = "10000" + signedMag; break;
       case 4 : signedMag = "1000" + signedMag; break;
       case 5 : signedMag = "100" + signedMag; break;
       case 6 : signedMag = "10" + signedMag; break;
       case 7 : signedMag = "1" + signedMag; break;
       default: System.out.println("invalid bit string"); break; 
     }
    }
    else {  //fills in the rest of the 8-bits with zeros because it is positive
      signedMag = Integer.toBinaryString(decNum);
      switch(signedMag.length()) { 
        case 1 : signedMag = "0000000" + signedMag; break;
        case 2 : signedMag = "000000" + signedMag; break;
        case 3 : signedMag = "00000" + signedMag; break;
        case 4 : signedMag = "0000" + signedMag; break;
        case 5 : signedMag = "000" + signedMag; break;
        case 6 : signedMag = "00" + signedMag; break;
        case 7 : signedMag = "0" + signedMag; break;
        default: System.out.println("invalid bit string"); break; 
      }
    }
  }
  
  public void setDecOnesComp() {    //sets the ones compliment representation of the decimal value
     if(isNegative()) { //if the decimal is negative, run the following code
       int positiveDecNum = Math.abs(decNum);   //creates a positive variable of the decimal
       String preFlip = Integer.toBinaryString(positiveDecNum); //creates the binary number before we flip all the bits
       switch(preFlip.length()) {   //fills in the rest of the 8-bits
        case 1 : preFlip = "0000000" + preFlip; break;
        case 2 : preFlip = "000000" + preFlip; break;
        case 3 : preFlip = "00000" + preFlip; break;
        case 4 : preFlip = "0000" + preFlip; break;
        case 5 : preFlip = "000" + preFlip; break;
        case 6 : preFlip = "00" + preFlip; break;
        case 7 : preFlip = "0" + preFlip; break;
        default: System.out.println("invalid bit string"); break; 
       }
       //swaps the 1s in the string to 0s and the 0s to 1s
        String firstSwap = preFlip.replace('1', '2');
        String secondSwap = firstSwap.replace('0', '1');
        onesComp = secondSwap.replace('2', '0');
     }
     else {     //runs the same thing but does not flip the bits
      String preFlip = Integer.toBinaryString(decNum);
      switch(preFlip.length()) { 
        case 1 : preFlip = "0000000" + preFlip; break;
        case 2 : preFlip = "000000" + preFlip; break;
        case 3 : preFlip = "00000" + preFlip; break;
        case 4 : preFlip = "0000" + preFlip; break;
        case 5 : preFlip = "000" + preFlip; break;
        case 6 : preFlip = "00" + preFlip; break;
        case 7 : preFlip = "0" + preFlip; break;
        default: System.out.println("invalid bit string"); break; 
      }
        onesComp = preFlip;
     }
   }
  
  public void setDecTwosComp() {    //sets the twos compliment representation of the decimal value
    if(isNegative()) {  //if the decimal is negative, create the binary string from the "toBinaryString" method
      String preCut = Integer.toBinaryString(decNum);
       twosComp = preCut.substring(preCut.length()-8, preCut.length()); //cuts the string to just the significant bits that are needed
    }
    else { //if the value is positive, twos comp is the same as ones comp
      twosComp = onesComp;
    }
  }
  
  public void setDecExcessNot() {   //sets the excess notation representation of the decimal value
    int excessDec = decNum + 128;   //adds 128 to the decimal value 
    excessNot = Integer.toBinaryString(excessDec);  //turns the decimal into binary representation
    switch(excessNot.length()) {    //fills in to make the binary  8-bits
      case 1 : excessNot = "0000000" + excessNot; break;
      case 2 : excessNot = "000000" + excessNot; break;
      case 3 : excessNot = "00000" + excessNot; break;
      case 4 : excessNot = "0000" + excessNot; break;
      case 5 : excessNot = "000" + excessNot; break;
      case 6 : excessNot = "00" + excessNot; break;
      case 7 : excessNot = "0" + excessNot; break;
      case 8 : excessNot = "" + excessNot; break;
      default: System.out.println("invalid bit string"); break; 
    }    
  }
  
  public String getDecResults() {   //returns the results of all the conversions in one return statement
    setDecSignedMag();  //sets all of the variables before returning them
    setDecOnesComp();
    setDecTwosComp();
    setDecExcessNot();
    return "Signed magnitude: " + signedMag
      + "\nOnes complement: " + onesComp 
      + "\nTwos complement: " + twosComp
      + "\nExcess-128 notation: " + excessNot;
  }

}
