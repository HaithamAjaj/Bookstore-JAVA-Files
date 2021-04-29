
package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class Admin {
    JFrame fr = new JFrame("Admin");
    JPasswordField tx = new JPasswordField();
    JLabel lb = new JLabel("Enter password please");
    JButton ad = new JButton("Enter");
    JButton bk = new JButton("Back");
    
    
    public Admin(){
        
        fr.setLayout (null); 
        
        lb.setBounds(60,50,300,30);
        tx.setBounds(60,80,300,30);
        ad.setBounds(210,120,80,30);
        bk.setBounds(120,120,80,30);
        
        fr.add(lb);
        fr.add(tx);
        fr.add(ad);
        fr.add(bk);
        fr.setVisible(true);      
        fr.setSize(430,240);
        fr.setLocation(450, 250);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ad.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
          
        enter();

      }
    });
        
      bk.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
                back();
                fr.setVisible(false);

      }
    });
        
        
        
        
    }
    
    public void back(){
        Login  buy = new Login();

}
    public void enter(){
        
        try {
            
          File file = new File("adminPass.txt");
          Scanner scan = new Scanner(file);
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);

          String passtxt = " ";
          String ppaswd = tx.getText();


          while (scan.hasNext()) {
            passtxt = scan.nextLine();
          }

          if(ppaswd.equals(passtxt)) {
            AddBookstore menu =new AddBookstore();
            fr.setVisible(false);
          } 
          else if(ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Password");
            tx.setText("");
          }
        } catch (IOException d) {
          d.printStackTrace();
        }
    
        
    }    
    
}



