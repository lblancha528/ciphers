Lily Blanchard
MP1 Redo: Caesar and Vigeneres Ciphers
CSC207-01 Rebelsky

**Changes**
* I have fixed all style errors except for magic numbers.
* In CipherUtils.vigenereEncrypt and .vigenereDecrypt, I have 
   changed the added or subtracted value in lines 88 and 109
   to be letter2int(keyArr[i]) instead of keyArr[i]. 
   Before the encoder and decoder were adding/ subtracting
   too much because the key was not converted to valid 
   alphabetic integer values.
* In Cipher.main, I fixed a spelling mistake that caused vigenere
   operations to fail.
* In CipherUtils.isValidString, I added a check for a null string.
* I have changed all instances of "System.exit(1);" to "return;" 
   because this was causing infinite loops.
* I have added an if statement check in Cipher.main to check
   that a valid combination of caesar/vigenere mode and key has
   been provided.
* I have changed the test cipherLongCaesarKey() to have param "ha"
   instead of "h" at SamR's instructions.
* I learned that the grey circle means there is an infinite loop!

**Acknowledgements**
* Thursday Evening Tutors: Charles