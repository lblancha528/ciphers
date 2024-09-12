package edu.grinnell.csc207.util;

import java.io.PrintWriter;

public class CipherUtils {
  private static int letter2int(char letter) {
    int base = (int) 'a';
    return (int) letter - base;
  } //letter2int(char)

  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (base + i);
  } //int2letter(int)

  public static String caesarEncrypt(String str, char letter) {
    int key = CipherUtils.letter2int(letter);
    char[] encodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray(); //convert str to charArray for indexing
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + key);
      encodedArr[i] = int2letter(holder);
    } //for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  }//ceasarEncrypt(String, char)

  public static String caesarDecrypt(String str, char letter) {
    int key = CipherUtils.letter2int(letter);
    char[] decodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray(); //convert str to char[] for indexing
    for (int i = 0; i < str.length(); i++) {
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) - key);
      decodedArr[i] = int2letter(holder);
    }//for
    String decodedStr = new String(decodedArr);
    return decodedStr;
  }//caesarDecrypt(String, char)

  public static String vigenereEncrypt(String str, String key) {
    char[] keyArr = CipherUtils.keyArray(str, key);
    char[] encodedArr = new char[str.length()]; //create blank array of appropriate length to store encoded message
    int holder; //to hold the current character being encoded, as an int
    char[] msg = str.toCharArray(); //convert str to char[] for indexing
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + keyArr[i]);
      encodedArr[i] = int2letter(holder);
    }//for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  }//vigenereEncrypt(String, String)

  public static String vigenereDecrypt(String str, String key) {
    char[] keyArr = CipherUtils.keyArray(str, key);
    char[] decodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray();
    for (int i = 0; i < str.length(); i++){
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) - keyArr[i]);
      decodedArr[i] = int2letter(holder);
    }//for
    String decodedStr = new String(decodedArr);
    return decodedStr;
  }//vigenereDecrypt(String, String)

  public static boolean isValidString(String str){
    int lower = (int) 'a';
    int upper = (int) 'z';
    char[] strArr = str.toCharArray();
    for (int i = 0; i < str.length(); i++){
      int letterNum = letter2int(strArr[i]);
      if (letterNum < lower || letterNum > upper){
        return false;
      }//if
    }//for
    return true;
  }//isValidString(String)

  //Fills a character array that is the same length as the message with the key, repeating as necessary.
  public static char[] keyArray(String str, String key){
    char[] keyArr = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
      keyArr[i] = key.charAt(i % (key.length()));
    }
    return keyArr;
  }//keyArray(String, String)

  public static int wrapLetter(int ltr){
    if (ltr < 0){
      return ltr + 26;
    }//if ltr is less than 'a', increase
    if (ltr > 25){
      return ltr % 26;
    }//if ltr is more than 'z', wrap
    else {
      return ltr;
    }//else, nothing
  }//wrapLetter(int)
}
