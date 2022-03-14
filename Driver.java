/*Ahmedh Shamsudeen
Purpose: intitally runs the program.
Contains; Object of the login class, used to call method of login.
Features;
-Calls displayList() method from Login Class which calls a instance fromthe readfile class which starts the program.
Limitations:
-Can only intiate methods from display list and not from any other class*/
public class Driver{
    
    public static void main(String[] args){
        Login aLogin = new Login();
        aLogin.displayList();
        
    }
}
