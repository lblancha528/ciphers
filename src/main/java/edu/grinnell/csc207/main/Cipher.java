package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Encrypt a message, takes 4 command line arguments.
 * @author Lily Blanchard
 * For CSC207-01 Rebelsky
 */
public class Cipher {
  /**
   * Main.
   * @param args
   *   the flags needed to determine encode or decode,
   *     vigeneres or caesar, and the key and message
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);

    if (args.length != 4) {
      err.println("Error: Incorrect number of parameters. \n");
      return;
    } // if

    String cipherMode = null; //caesar or vigenes
    String codeMode = null; //encode or decode
    String msg = null;
    boolean msgFound = false;
    String keyS = null;
    char keyC = '\0';

    for (int i = 0; i < 4; i++) {
      if (args[i].charAt(0) == '-') {
        //must be a mode
        // if codeMode found, set
        if (args[i].equals("-encode") || args[i].equals("-decode")) {
          codeMode = args[i];
        } else if (args[i].equals("-caesar") || args[i].equals("-vigenere")) {
          // if cipherMode found, set
          cipherMode = args[i];
        } else {
          err.println("Error: Invalid mode parameter provided.\n");
          return;
        } // else
      } else {
        if (!CipherUtils.isValidString(args[i])) {
          err.println("Error: Invalid string parameter provided.\n");
          return;
        } else {
          if (msgFound) {
            if (args[i].length() == 1) {
              // if string is one character, must be caesar key
              keyC = args[i].charAt(0);
            } else {
              keyS = args[i];
            } // else
          } else {
            msg = args[i];
            msgFound = true;
          } // else
        } // else
      } // else
    } // for

    if ((cipherMode == "-caesar" && keyC == '\0') || (cipherMode == "-vigenere" && keyS == null)) {
      err.println("Error: Caesar ciphers require a one-character key");
      return;
    } // if

    if (cipherMode == "-caesar") {
      if (codeMode == "-encode") {
        pen.println(CipherUtils.caesarEncrypt(msg, keyC));
      } else {
        pen.println(CipherUtils.caesarDecrypt(msg, keyC));
      } // else
    } else {
      if (codeMode == "-encode") {
        pen.println(CipherUtils.vigenereEncrypt(msg, keyS));
      } else {
        pen.println(CipherUtils.vigenereDecrypt(msg, keyS));
      } // else
    } // else

  } // main(String[])
} // Cipher()
