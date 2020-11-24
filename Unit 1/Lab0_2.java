/**
Lab 0
* @author MonicaChan
* @version 1.0
*/
public class Lab0_2{

  /**
   * @param pw password string
   * @return a boolean to indicate if the password is strong enough or not.
   This method returns whether or not the password meets the following
   * criteria: 8 characters long, contains an uppercase letter,
   * lowercase letter, number, and symbol. */
  public static boolean checkComplexity(String pw){
    //validPass will stay false until all the requirements for the password are met.
    boolean validPass = false;

    //these next four booleans are the requirements (besides length) that the password must meet.
    boolean upperCase = false;
    boolean lowerCase = false;
    boolean hasInteger = false;
    boolean hasCharacter = false;
    if(pw.length() >= 8){
      for(int i = 0; i < pw.length(); i++){
        //invalid characters for the password
        if(31 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 0){
          return false;
        }
        else{
          //checks for numbers ascii
          if(57 >= (int) pw.charAt(i) &&  (int) pw.charAt(i)>= 48)
            hasInteger = true;

          //checks for uppercase ascii
          if(90 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 65)
            upperCase = true;

          //checks for lowercase ascii
          if(122 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 97)
            lowerCase = true;

          //checks for symbols ascii
          else if(64 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 58)
              hasCharacter = true;
          else if(96 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 91)
              hasCharacter = true;
          else if(126 >= pw.charAt(i) && pw.charAt(i) >= 123)
              hasCharacter = true;
        }
      }
    }
    //the password will only be valid if it has all these elements.
    if(hasInteger && upperCase && lowerCase && hasCharacter){
      validPass = true;
    }
    return validPass;
  }


  /**
   * @param pw password to get strength of
   * @return a double which represents the password Strength, the higher the number,
   the more strong.
   * This function will do a rough calculation of password strength.
   * The algorithm is a very poor (but much quicker and easier!)
   * version of bit-based information entropy.
  Numbers only (10 possible) = 3.3
  Case insensitive letters only (26 possible) = 4.7
  Case insensitive alphanumeric (36 possible) = 5.1
  Case sensitive letters only (52 possible) = 5.7
  Case sensitive alphanumeric (62 possible) = 6.0
  Case sensitive alphanumeric and symbols (94 possible) = 6.6

   */
  public static double getPWStrength(String pw){

    int passLength = pw.length();
    boolean hasInteger = false;
    boolean upperCase = false;
    boolean lowerCase = false;
    boolean hasCharacter = false;

    //bit values for the different password combinations
    double numOnly = 3.3;
    double lowOnly = 4.7;
    double lowAlpha = 5.1;
    double sensOnly = 5.7;
    double sensAlpha = 6.0;
    double sensAlphaSym = 6.6;


  //counts the consecutive repeated types of symbols by checking the character compared to the one after it.
  int countRepeat = 0;
  for(int i = 0; i < pw.length()-1; i++){
    //repeating integers
    if (57 >= (int)pw.charAt(i) && (int)pw.charAt(i) >= 48 && 57 >= (int)pw.charAt(i+1) && (int)pw.charAt(i+1) >= 48)
      countRepeat += 1;

    //repeating upper case
    else if(90 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 65 && 90 >= (int) pw.charAt(i+1) && (int) pw.charAt(i+1) >= 65)
      countRepeat += 1;

    //repeating lower case
    else if(122 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 97 && 122 >= (int) pw.charAt(i+1) && (int) pw.charAt(i+1) >= 97)
      countRepeat += 1;

    //repeating symbols
    else if(47 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 33 && 47 >= (int) pw.charAt(i+1) && (int) pw.charAt(i+1) >= 33)
      countRepeat += 1;

    //more repeating symbols
    else if(64 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 58 && 64 >= (int) pw.charAt(i+1) && (int) pw.charAt(i+1) >= 58)
      countRepeat += 1;

    //more repeating symbols
    else if(96 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 91 && 96 >= (int) pw.charAt(i+1) && (int) pw.charAt(i+1) >= 91)
      countRepeat += 1;

    //more repeating symbols
    else if(126 >= pw.charAt(i) && pw.charAt(i) >= 123 && 126 >= pw.charAt(i+1) && pw.charAt(i+1) >= 123)
      countRepeat += 1;
  }

  //rather like getPWStrength, evaluates if pass has number, upper case, lower case, and symbol.
  //the outputs of this loop is used in the next set of if statements to determine what kind of password it is.
  for(int i = 0; i < pw.length(); i++){
    if(31 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 0)
      return 0.0;
    else{
      if(57 >= (int) pw.charAt(i) &&  (int) pw.charAt(i)>= 48)
        hasInteger = true;

      else if(90 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 65)
        upperCase = true;

      else if(122 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 97)
        lowerCase = true;

      else if(64 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 58)
        hasCharacter = true;
      else if(96 >= (int) pw.charAt(i) && (int) pw.charAt(i) >= 91)
        hasCharacter = true;
      else if(126 >= pw.charAt(i) && pw.charAt(i) >= 123)
        hasCharacter = true;

    }
  }

  //These sets of if statements are all the possible types of password combinations, given by the bit table.
  double passwordStrength = 0.0;
  //alphanumeric case sensitive with symbols
  if(hasInteger && upperCase && lowerCase && hasCharacter)
    //formula for the strength = bit value for type of password * length of password minus the number of consecutive characters of the same type.
    passwordStrength = sensAlphaSym * pw.length() - countRepeat;

  //alphanumeric case sensitive
  else if(hasInteger && upperCase && lowerCase)
    passwordStrength = sensAlpha * pw.length() - countRepeat;

  //alphanumeric case sensitive
  else if(hasInteger && lowerCase)
    passwordStrength = lowAlpha * pw.length() - countRepeat;

  //case sensitive only
  else if(lowerCase && upperCase)
    passwordStrength = sensOnly * pw.length() - countRepeat;

  //case insensitive only
  else if(lowerCase)
    passwordStrength = lowOnly * pw.length() - countRepeat;

  //numbers only
  else if(hasInteger)
    passwordStrength = numOnly * pw.length() - countRepeat;

  //rounding the output to the tenths place.
  return Math.round(passwordStrength * 100.0) / 100.0;

}


/** Generates a random password that meets the complexity requirement
 and is of strength at least 90.
 * @return a password String.

 integers 57 & 48
 Upper case 90 - 65
 lower case 122-97
 symbol 58-64, 96 -91, 126-123
 */
 public static String generatePW(){
   String password = "";
   double strength = 0.0;
   //loop checks to see if the password string meets strength requirements, if it doesn't, add on more characters.
   while(strength < 90.0){
     //adds an integer
     password += (char)(int)((Math.random() * (57 - 47)) + 48);
     //lower case
     password += (char)(int)((Math.random() * (122 - 96)) + 97);
     //adds a symbol
     password += (char)(int)((Math.random() * (64 - 57)) + 58);
     //adds an Upper case.
     password += (char)(int)((Math.random() * (90 - 64)) + 65);
     //rechecks password Strength
     strength = getPWStrength(password);
   }
   return password;
 }

 /**
  Returns an encrypted version of the password. Encrypts password
  using Vigenere Cipher.
  * @param key is the key used to encrypt the password, and decrypt.
  * @param password is the password to encrypt.
  * @return string with the encrypted password.
  */
 public static String encryptPW(String key, String password){
   //passwordCode contains the ascii codes for the password characters.
   int[] passwordCode = new int[password.length()];
   //keyCode contains the ascii codes for the key characters.
   int[] keyCode = new int[password.length()];
   String newKey = "";

   //this for loop lengthens the key to be the length of the password.
   for(int i = 0, n = 0; i < password.length(); i++, n++){
     if(n == key.length())
        n = 0;
     newKey += key.charAt(n);
   }
   //this for loop adds the int ascii codes into the password Code array and the key code array. Also subtract 33 from the ascii code to make the range of codes from 0-93.
    for(int k = 0; k< password.length(); k++){
      passwordCode[k] = (int)password.charAt(k)-33;
      keyCode[k] = (int)(newKey.charAt(k))-33;
   }

   String encrypted = "";
   //Using some operations, convert the numbers from the key and the password codes and creating a new character and adding that into the encrypted string.
   for(int m = 0; m<password.length(); m++)
     encrypted += (char)(((passwordCode[m] + keyCode[m]) % 94) + 33);

   return encrypted;
 }

 /**
 Returns an decrypted version of the password. Decrypts password
 * using Vigenere Cipher.

 * @param key is the key used to decrypt the password, same as the one used to encrypt.
 * @param encrypted is the encrypted password.
 * @return the decrypted password.
 */
 public static String decryptPW(String key, String encrypted){

   String newKey = "";
   int[] keyCode = new int[encrypted.length()];
   int[] encryptedCode = new int[encrypted.length()];

   //this loop lengthens the key to be the length of the password.
   for(int i = 0, n = 0; i < encrypted.length(); i++, n++){
     if(n == key.length())
        n = 0;
     newKey += key.charAt(n);
   }

   //this loop offsets the encrypted characters (I un-offset them in the encryption.)
   for(int c = 0; c<encrypted.length(); c++){
     encryptedCode[c] = (int)encrypted.charAt(c) -33;
     keyCode[c] = (int)newKey.charAt(c) -33;
   }

   String password = "";

   //this loop finishes the decryption and adds the characters to the password string.
   for(int n = 0; n<encrypted.length(); n++){
     //we know the key code the key code was added to the original password code, the encrypted code minus key code gets us one step closer to the decrypted character.
     int difference = encryptedCode[n] - keyCode[n];

     //if the difference is less than 0, we need to offset it by 94 characters due to wraparaound.
     if(difference<=0)
       difference += 94;

     //if the difference is greater than 93, we need to bring it around back to 0, so use modulo.
     else if(difference> 93)
       difference = difference % 94;

     //un-offset the character ascii code
     difference += 33;

     //convert the ascii code back to a character.
     password += (char)difference;
   }
   return password;
 }
}
