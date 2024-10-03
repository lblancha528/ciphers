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

**Acknowledgements**
* Thursday Evening Tutors: 

**Notes to Self** 
* Test suite doen't return pass or fail for many M and E level tests. 
* I'm pretty sure they pass, but they won't run at all.