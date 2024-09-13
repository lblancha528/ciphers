package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/*
 * Helper functions for using caesar and vigenes ciphers.
 */
public class CipherUtils {
  /*
   * Convert a character to an integer with 'a' = 0.
   */
  private static int letter2int(char letter){
    int base = (int) 'a';
    return (int) letter - base;
  } // letter2int(char)

  /*
   * Convert an integer to a character with 'a' = 0.
   */
  private static char int2letter(int i){
    int base = (int) 'a';
    return (char) (base + i);
  } // nt2letter(int)

  /*
   * Encrypt a message using a caesar cipher.
   */
  public static String caesarEncrypt(String str, char letter){
    int key = CipherUtils.letter2int(letter);
    char[] encodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray(); //convert str to charArray for indexing
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + key);
      encodedArr[i] = int2letter(holder);
    } // for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  } // ceasarEncrypt(String, char)

  /*
   * Decrypt a message using a caesar cipher.
   */
  public static String caesarDecrypt(String str, char letter){
    int key = CipherUtils.letter2int(letter);
    char[] decodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray(); //convert str to char[] for indexing
    for (int i = 0; i < str.length(); i++) {
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) - key);
      decodedArr[i] = int2letter(holder);
    } // for
    String decodedStr = new String(decodedArr);
    return decodedStr;
  } // caesarDecrypt(String, char)

  /*
   * Encrypt a message using a vigenere cipher.
   */
  public static String vigenereEncrypt(String str, String key){
    char[] keyArr = CipherUtils.keyArray(str, key);
    char[] encodedArr = new char[str.length()]; //create blank array of appropriate length to store encoded message
    int holder; //to hold the current character being encoded, as an int
    char[] msg = str.toCharArray(); //convert str to char[] for indexing
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + keyArr[i]);
      encodedArr[i] = int2letter(holder);
    } // for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  } // vigenereEncrypt(String, String)

  /*
   * Decrypt a message using a vigenere cipher.
   */
  public static String vigenereDecrypt(String str, String key){
    char[] keyArr = CipherUtils.keyArray(str, key);
    char[] decodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray();
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) - keyArr[i]);
      decodedArr[i] = int2letter(holder);
    } // for
    String decodedStr = new String(decodedArr);
    return decodedStr;
  } // vigenereDecrypt(String, String)

  /*
   * Check that a given string consists of only lower case letters.
   */
  public static boolean isValidString(String str){
    int lower = letter2int('a');
    int upper = letter2int('z');
    char[] strArr = str.toCharArray();
    for (int i = 0; i < str.length(); i++){
      int letterNum = letter2int(strArr[i]);
      if (letterNum < lower || letterNum > upper){
        return false;
      } // if
    } // for
    return true;
  } // isValidString(String)

  /*
  * Create a character array of same length as string filled with key, repeating as needed.
  */
  public static char[] keyArray(String str, String key){
    char[] keyArr = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
      if (i > (key.length() - 1)){
        keyArr[i] = key.charAt(i % key.length());
      } // if
      else {
        keyArr[i] = key.charAt(i);
      } // else
    } // for
    return keyArr;
  } // keyArray(String, String)

  /*
   * If a letter is 'lower' than a or 'higher' than z, modify until it is a valid letter value.
   */
  public static int wrapLetter(int ltr){
    while (ltr < 0 || ltr > 25){
      if (ltr < 0){
        return ltr + 26;
      } // if ltr is less than 'a', increase
      if (ltr > 25){
        return ltr % 26;
      } // if ltr is more than 'z', wrap
    } // while
    return ltr;
  } // wrapLetter(int)
} // CipherUtils()
