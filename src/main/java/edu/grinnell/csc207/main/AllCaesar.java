package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Run caesar cipher with two command line arguments.
 * @author Lily Blanchard
 * For CSC207-01 Rebelsky
 */
public class AllCaesar {
  /**
   * Main class.
   * @param args
   *   the flags needed to determine encode or decode,
   *     vigeneres or caesar, and the key and message
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);

    if (args.length != 2) {
      err.printf("Error: Incorrect number of parameters.\n");
      return;
    } // if

    String mode = args[0];
    String str = args[1];

    if (!(CipherUtils.isValidString(str))) {
      err.printf("Error: String contains characters other than lowercase letters.\n");
      return;
    } // if

    if (mode == "encode") {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
      } // for
    } else if (mode == "decode") {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
      } // for
    } else {
      err.printf("Error: Invalid option: \""
          + mode + "\". Valid options are \"encode\" or \"decode\".\n");
      return;
    } // else

    pen.close();
  } // main(String[])
} // class AllCaesar
