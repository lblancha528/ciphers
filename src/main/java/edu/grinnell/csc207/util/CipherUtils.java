package edu.grinnell.csc207.util;

/**
 * Helper functions for using caesar and vigenes ciphers.
 * @author Lily Blanchard
 * For CSC207-01 Rebelsky
 */
public class CipherUtils {
  /**
   * Convert a character to an integer with 'a' = 0.
   * @param letter
   *   the letter to be converted to a number
   * @return the integer version of letter
   */
  private static int letter2int(char letter) {
    int base = (int) 'a';
    return (int) letter - base;
  } // letter2int(char)

  /**
   * Convert an integer to a character with 'a' = 0.
   * @param i
   *   the number to be converted to a letter
   * @return the character version of i
   */
  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (base + i);
  } // nt2letter(int)

  /**
   * Encrypt a message using a caesar cipher.
   * @param str
   *   the string to be encrypted
   * @param letter
   *   the character key to encode str
   * @return the encoded message
   */
  public static String caesarEncrypt(String str, char letter) {
    int key = CipherUtils.letter2int(letter);
    char[] encodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray(); //convert str to charArray for indexing
    for (int i = 0; i < str.length(); i++) {
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + key);
      encodedArr[i] = int2letter(holder);
    } // for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  } // ceasarEncrypt(String, char)

  /**
   * Decrypt a message using a caesar cipher.
   * @param str
   *   the string to be decoded
   * @param letter
   *   the character key to decode str
   * @return the decoded string
   */
  public static String caesarDecrypt(String str, char letter) {
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

  /**
   * Encrypt a message using a vigenere cipher.
   * @param str
   *   the string to be encoded
   * @param key
   *   the string key to encode str
   * @return the encoded message
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] keyArr = CipherUtils.keyArray(str, key);
    // create blank array of appropriate length to store encoded message
    char[] encodedArr = new char[str.length()];
    int holder; // to hold the current character being encoded, as an int
    char[] msg = str.toCharArray(); // convert str to char[] for indexing
    for (int i = 0; i < str.length(); i++) {
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) + letter2int(keyArr[i]));
      encodedArr[i] = int2letter(holder);
    } // for
    String encodedStr = new String(encodedArr);
    return encodedStr;
  } // vigenereEncrypt(String, String)

  /**
   * Decrypt a message using a vigenere cipher.
   * @param str
   *   the string to be decoded
   * @param key
   *   the string key to decode str
   * @return the decoded message
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] keyArr = CipherUtils.keyArray(str, key);
    char[] decodedArr = new char[str.length()];
    int holder;
    char[] msg = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      holder = CipherUtils.wrapLetter(letter2int(msg[i]) - letter2int(keyArr[i]));
      decodedArr[i] = int2letter(holder);
    } // for
    String decodedStr = new String(decodedArr);
    return decodedStr;
  } // vigenereDecrypt(String, String)

  /**
   * Check that a given string consists of only lower case letters.
   * @param str
   *   the string to be checked
   * @return whether str is a lowercase string
   */
  public static boolean isValidString(String str) {
    int lower = letter2int('a');
    int upper = letter2int('z');
    if (str.length() < 1) {
      return false;
    } // if
    char[] strArr = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      int letterNum = letter2int(strArr[i]);
      if (letterNum < lower || letterNum > upper) {
        return false;
      } // if
    } // for
    return true;
  } // isValidString(String)

  /**
   * Create a character array of same length as string filled with key, repeating as needed.
   * @param str
   *  the string
   * @param key
   *  the key
   * @return an array of key repeating for length of str
   */
  public static char[] keyArray(String str, String key) {
    char[] keyArr = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      if (i > (key.length() - 1)) {
        keyArr[i] = key.charAt(i % key.length());
      } else {
        keyArr[i] = key.charAt(i);
      } // else
    } // for
    return keyArr;
  } // keyArray(String, String)

  /**
   * If a letter is 'lower' than a or 'higher' than z, modify until it is a valid letter value.
   * @param ltr
   *   an int representing a letter
   * @return an acceptable int value to correspond to a letter
   */
  public static int wrapLetter(int ltr) {
    while (ltr < 0 || ltr > 25) {
      if (ltr < 0) {
        return ltr + 26;
      } // if ltr is less than 'a', increase
      if (ltr > 25) {
        return ltr % 26;
      } // if ltr is more than 'z', wrap
    } // while
    return ltr;
  } // wrapLetter(int)
} // CipherUtils()
