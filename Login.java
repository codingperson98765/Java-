
import javax.swing.AbstractAction;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
/*Ahmedh Shamsudeen
Purpose: Handles all aspects of the Login Window
Contains; userLogin() method which handles all the action events when the use tries to login. 
Features;
-Checks if user input matches with the text in the decrypted password array, if it matches the user is logged in.
-If user incorrectly types password in three times the windo closes after a short timer.
-
Limitations:
-Must be called before the Readfile or else the encrypted password field will return null */

public class Login implements ActionListener{

    private JLabel passlabel;
    private JFrame aframe;
    private JPasswordField passwordText;
    private JPanel apanel;
    private JButton aButton;
    private int counter;

   

    
    char[] inputPassword;
    private String realPassword;
    String passFromFile;
    ReadFile aReadFile = new ReadFile();
    Shopping aShopping = new Shopping();
    


    public void userLogin() {
        
        aframe = new JFrame("Login Screen");
        apanel = new JPanel();
        aframe.setSize(400, 250);
        aframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        aframe.add(apanel);

        apanel.setLayout(null);
        
        

        passlabel = new JLabel("Enter Password");
        passlabel.setBounds(140,75,125,25);
        apanel.add(passlabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(140,100,125,25);
        passwordText.addActionListener(this);
        apanel.add(passwordText);

        aButton = new JButton(new AbstractAction("Login"){
            @Override
            public void actionPerformed(ActionEvent e){
                passwordCheck(passwordText);   

            }
        });
        aButton.setBounds(140,150,80,25);
        
        aButton.addActionListener(new Login());
        apanel.add(aButton);
        
        aframe.setVisible(true);

    } 

    public void actionPerformed (ActionEvent e)
    {
	   //JButton aButton = (JButton) e.getSource();
       Component aComponent = (Component) e.getSource();
       if (aComponent instanceof JPasswordField){
        JPasswordField passwordText = (JPasswordField) aComponent;
        passwordCheck(passwordText);
        
        
       }
       
       
    }
    
    public void passwordCheck(JPasswordField apasswordText) {
        char[] inputPassword = apasswordText.getPassword();
        realPassword =  String.valueOf(inputPassword);
        
        
        if (realPassword.equals(passFromFile)){
            System.out.println("Successful Login" + passFromFile + realPassword);
            aframe.dispose();
            //next step is to open the shopping window
            aShopping.shopLayout();

        }
        else{
            System.out.println("Unsuccessfull Login");
            counter++;
            aframe.setTitle("No. incorrect login attempts (max = 3) :" + counter);
            if (counter == 3){
                aframe.setTitle("Max Attempts exceeded, now EXITING....");
                try {Thread.sleep(2000);
                aframe.dispose();}
                catch(Exception ex){return;}

            }
            
        }

        
    }
     
    public void displayList(){
        aReadFile.aFileReader();
        passFromFile = aReadFile.getPass();
        
        userLogin();
    }






}
