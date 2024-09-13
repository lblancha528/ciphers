package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/*
 * Run caesar cipher with two command line arguments.
 */
public class AllCaesar {
  /*
   * Main class.
   */
  public static void main(String[] args){
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);

    if (args.length != 2){
      err.printf("Error: Incorrect number of parameters.\n");
      System.exit(1);
    } // if

    String mode = args[0];
    String str = args[1];

    if ((CipherUtils.isValidString(str)) == false){
      err.printf("Error: String contains characters other than lowercase letters.\n");
      System.exit(1);
    } // if

    if (mode == "encode"){
      for (char ch = 'a'; ch <= 'z'; ch++){
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } // for
    } // if
    else if (mode == "decode"){
      for (char ch = 'a'; ch <= 'z'; ch++){
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } // for
    } // else if
    else{
      err.printf("Error: Invalid option: \"" + mode + "\". Valid options are \"encode\" or \"decode\".\n");
      System.exit(1);
    } // else
    
    pen.close();
  }
}
