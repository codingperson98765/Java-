/*Ahmedh Shamsudeen
UCID 30121541
A5 Version 1.0
Tutorial 7
Purpose: Decrypts letters from password file.
Contains; char [] of alphabet. Contains list of decrypted password
Features;
- Recieved unencrypted password letter as a parameter as well as the total 
amount of letters in the unecrypted password and decrypts the password letters
one by one and adds them to the password list.
Limitations:
-Can not decrypt password if the cyphercode is more than one letter back or if the password contains numbers,etc.*/

public class Decryptor{
    private char [] alphabetLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char passwordLetter;
    
   
    
    
    //takes s from readfile and length of s
    public char decrypt(char a, int ab){
            
            for (int i=0; i< alphabetLetters.length; i++){
                if (alphabetLetters[i] == a){
                    if ((i + 1) <= 25){
                         passwordLetter = alphabetLetters[i+1];
                                               
                         
                    }
                    else if ((i + 1) > 25){
                        passwordLetter = alphabetLetters[i-25];
                                                
                    }     
                }
            }
        return passwordLetter;
    }
    
    
    
    
}
