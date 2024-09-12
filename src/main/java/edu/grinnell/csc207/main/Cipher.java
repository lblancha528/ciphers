package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);

    if (args.length != 4){
      err.println("Error: Incorrect number of paramenters. \n");
      System.exit(1);
    }//if

    String cipherMode = null; //caesar or vigenes
    String codeMode = null; //encode or decode
    String msg = null;
    boolean msgFound = false;
    String keyS = null;
    char keyC = '\0';
    
    for (int i = 0; i < 4; i++){
      if (args[i].charAt(0) == '-'){ //must be a mode
        if (args[i] == "-encode" || args[i] == "-decode"){
          codeMode = args[i];
        }//if codeMode found, set
        else if (args[i] == "-caesar" || args[i] == "-vigenes"){
          cipherMode = args[i];
        }//if cipherMode found, set
        else{
          err.println("Error: Invalid mode parameter provided.\n");
        }//else
      }//if mode found
      else {
        if(CipherUtils.isValidString(args[i]) == false){
          err.println("Error: Invalid string parameter provided.\n");
        }//if, check that found string is valid
        else{
          if (msgFound == true){
            if (args[i].length() == 1){
              keyC = args[i].charAt(0);
            }//if string is one character, must be caesar key
            else{
              keyS = args[i];
            }//else
          }//if message is found
          else {
            msg = args[i];
            msgFound = true;
          }//else
        }//else
      }//else
    }//for

    if (cipherMode == "-caesar"){
      if (codeMode == "-encode"){
        pen.println("Message: " + msg + "\n Key: " + keyC + "\n Encrypted: " + CipherUtils.caesarEncrypt(msg, keyC));
      }//if
      else {
        pen.println("Message: " + msg + "\n Key: " + keyC + "\n Decrypted: " + CipherUtils.caesarDecrypt(msg, keyC));
      }//else
    }//if
    else{
      if (codeMode == "-encode"){
        pen.println("Message: " + msg + "\n Key: " + keyS + "\n Encrypted: " + CipherUtils.vigenereEncrypt(msg, keyS));
      }//if
      else {
        pen.println("Message: " + msg + "\n Key: " + keyS + "\n Decrypted: " + CipherUtils.vigenereDecrypt(msg, keyS));
      }//else
    }//else

  }
}
