/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewUser extends JFrame {
  JButton create,back;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);
    back = new JButton("Back");


    setSize(300,600);
    setLocation(500,80);
    newUserPanel.setLayout (null); 


    txuserer.setBounds(70,208,150,20);
    passer.setBounds(70,243,150,20);
    create.setBounds(95,300,100,20);
    back.setBounds(95,435,100,20);

    newUserPanel.add(create);
    newUserPanel.add(back);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    
          createAccount();

      }
    });
  
    
    back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        
        goBack();  
        dispose();

      }
    });
    
    
    
    
    
  }
  
  public void createAccount(){
      
          try {
    File file = new File("userPass.txt");
    Scanner scan = new Scanner(file);;

      FileWriter filewrite = new FileWriter(file, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = txuserer.getText();
      String ppaswder = passer.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
      }

        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocus(); //باستخدمها عشان يرجعني على اليوزر اكتب فيه من جديد

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        JOptionPane.showMessageDialog(null,"Account has been created.");
        dispose();
        Login log = new Login();



        }
        } catch (IOException d) {
      d.printStackTrace();
    }
  
  }
  
  public void goBack(){
  
       Login  buy = new Login();
  }

}