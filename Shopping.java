import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import java.awt.Image;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Font;
import java.io.FileWriter;
import java.io.PrintWriter;

/*Ahmedh Shamsudeen
UCID 30121541
A5 Version 1.0
Tutorial 7
Purpose: Handles all aspects of the Order Information Window
Contains; shopLayout() method which handles all the action events and any inputs in name and address. 
Features;
-Writes to  order.txt when the save button is clicked. Clears both name and address text areas when the clear button is clicked.
-
Limitations:
-Can only intiate methods from Shopping and not from any other class.

Sources of Icons;
https://www.iconsdb.com/red-icons/x-mark-icon.html = Red X
http://clipart-library.com/free/small-arrow-png.html = downward arrow
https://www.pinterest.ca/pin/659777414145280847/ = sun

*/

public class Shopping extends JFrame implements ActionListener{
    
    
    private JFrame shopFrame;
    private JLabel companyLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel shopLogo;
    private JLabel saveLogo;
    private JPanel shopPanel;
    private JButton saveButton;
    private JButton clearButton;
    private JTextField nameTextField;
    private JTextArea addressTextField;
    private GridBagLayout aGridBagLayout; 
    private String [] orderString = new String[2];
    Font font = new Font(Font.MONOSPACED,  Font.BOLD, 25);
    GridBagConstraints gbc = new GridBagConstraints();
    



    public void shopLayout(){

        shopFrame = new JFrame("Order Information");
        shopFrame.setSize(600, 375);
        shopPanel = new JPanel();
        shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shopFrame.add(shopPanel);
        
        aGridBagLayout = new GridBagLayout();    
        
        shopPanel.setLayout(null);

        ImageIcon sunIcon = new ImageIcon("Sun_1.jpg");
        
        
        ImageIcon saveIcon = new ImageIcon("Save_1.png");
        Image img = saveIcon.getImage();
        Image newimg = img.getScaledInstance(45,45 , java.awt.Image.SCALE_SMOOTH ) ;
        saveIcon = new ImageIcon(newimg);

        ImageIcon clearIcon  = new ImageIcon("Red.png");
        Image img1 = clearIcon.getImage();
        Image newimg1 = img1.getScaledInstance(15,15 , java.awt.Image.SCALE_SMOOTH ) ;
        clearIcon = new ImageIcon(newimg1);

        shopLogo = new JLabel(sunIcon,JLabel.CENTER);
        shopLogo.setBounds(365,20,100,100);
        shopPanel.add(shopLogo);

        companyLabel = new JLabel("DEENCORP");
        companyLabel.setFont(font);
        companyLabel.setBounds(225,30,150,55);
        shopPanel.add(companyLabel);
 
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(125, 145, 50, 15);
        shopPanel.add(nameLabel);

        addressLabel = new JLabel("Address");
        addressLabel.setBounds(337, 145, 50 , 15);
        shopPanel.add(addressLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(125,165,90,25);
        shopPanel.add(nameTextField);  

        addressTextField = new JTextArea();
        addressTextField.setBounds(337,165,125,75);
        addressTextField.setLineWrap(true);
        shopPanel.add(addressTextField);
        
        

        saveButton = new JButton(new AbstractAction("Save", saveIcon){
            @Override
            public void actionPerformed(ActionEvent e){
                try{System.out.println("saved");
                String nameField = new String(nameTextField.getText());
                String addressField = new String(addressTextField.getText());
                orderString[0] = nameField;
                orderString[1]  = addressField;
                FileWriter(orderString);
                shopFrame.setTitle("Saving Information ...");   
                Thread.sleep(2500);
                shopFrame.setTitle("Order Information");
            }
                catch(Exception ex){
                    return;}

            }
        });
        saveButton.setHorizontalTextPosition(SwingConstants.LEFT);
        saveButton.setBounds(125,275,125,25);
        shopPanel.add(saveButton);

        
        clearButton = new JButton(new AbstractAction("Clear", clearIcon){
            
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("cleared");   
                nameTextField.setText("");
                addressTextField.setText("");

            }
        });
        clearButton.setHorizontalTextPosition(SwingConstants.LEFT);
        clearButton.setBounds(337,275,125,25);
        shopPanel.add(clearButton);
        

        
        shopFrame.setVisible(true);

    }

    public void methodReducer1(){

    }

    public void actionPerformed (ActionEvent e){
        ;
    }

    public void lineWriter(String aString , String aString2){
        int c = 0;
        for (int x = 1; x < 3; x++)
        {
            orderString[c] = aString;
            orderString[x]  = aString2;
            
            
        }
        

    }
    public void addWidget(Component widget, int a, int b, int c, int d){
        gbc.gridx = a;
        gbc.gridy = b;
        gbc.gridwidth = c;
        gbc.gridheight = d;
        aGridBagLayout.setConstraints(widget, gbc);
        add(widget);
        shopPanel.add(widget,gbc);
        //shopPanel.setLayout(aGridBagLayout);
        //gbc.insets = new Insets(0,10,0,10);


    }
    
    public void FileWriter(String [] aStrings){
        try{FileWriter afileWriter = new FileWriter("order.txt");
        PrintWriter aprintWriter = new PrintWriter(afileWriter);
        for (int i = 0; i < 2; i++)
        {
            
            aprintWriter.println(aStrings[i]);
        }
    afileWriter.close();
    }
    catch(Exception ex){
        return;}
    }
       


}