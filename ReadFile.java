import java.io.BufferedReader;
import java.io.FileReader;

/*Ahmedh Shamsudeen
UCID 30121541
A5 Version 1.0
Tutorial 7
Purpose:Reads Password File and passes it to decryptor.
Contains; aFileReader() which reads the password file and has sent and get methods for the password array.
Features;
-Can read through file and pass encrypted letters to decryptor class
Limitations:
-Can only access password file if it is in the same directory as ReadFile.java*/



public class ReadFile{
    private char [] letters;
    private char [] password;
    Decryptor aDecryptor = new Decryptor();
    private String pass;
    
    
           
    
    public void aFileReader(){
        
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("password.txt"));
            String s;
            
            while((s = br.readLine()) != null) {
               
                //System.out.println(s);
                letters = new char[s.length()];
                password = new char[s.length()];
                loop(s);
            }
            br.close();
            
        }catch(Exception ex){
            return;
        }

    }
    
    public String loop(String as){
        for (int x=0; x < as.length(); x++){
            char aas = as.charAt(x);
            letters[x] = aas;
            password[x] = aDecryptor.decrypt(as.charAt(x) , as.length());  
            
        }
        pass = (String.valueOf(password));
        setPass(pass);
        return pass;

               
    }
    public void setPass(String apass){
        this.pass = apass;        
    }
        
    public String getPass(){
        return pass;        
    }

}
