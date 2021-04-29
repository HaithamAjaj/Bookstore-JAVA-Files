
package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame {
  JButton blogin,back,ad;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUSer;
  JLabel username;
  JLabel password;
  ImageIcon image;
  JLabel label1;
  JFrame f;



  public Login(){
    super("Login Autentification");

    blogin = new JButton("Login");

  
    
    ad = new JButton("Admin");
    
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    newUSer = new JButton("New User?");
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");
   
    image = new ImageIcon(getClass().getResource("Bookshelves.jpg"));
     label1 = new JLabel(image);

    setSize(300,600);
    setLocation(500,80);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,208,150,20);
    pass.setBounds(70,243,150,20);
    blogin.setBounds(95,300,100,20);
    newUSer.setBounds(95,335,100,20);
  
    
    ad.setBounds(95,370,100,20);

     
    username.setBounds(20,208,80,20);
    password.setBounds(20,243,80,20);
    

    loginpanel.add(label1);
    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(newUSer);

    
    loginpanel.add(ad);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    
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




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          
        
        signIn();

      }
    });

    newUSer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        newUser();
        dispose();

      }
    });
    
   
    
   
    
    ad.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        goAdmin();
        dispose();

      }
    });
    
  
  
  
  
  
  } 
  
  
  public void goAdmin(){
  
      Admin ad = new Admin();
  }
  
  public void newUser(){
      NewUser user = new NewUser();
  }
  
  public void signIn(){
      
      try {
            
          File file = new File("userPass.txt");
          Scanner scan = new Scanner(file);
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);

          String usertxt = " ";
          String passtxt = " ";
          String puname = txuser.getText();
          String ppaswd = pass.getText();


          while (scan.hasNext()) {
            usertxt = scan.nextLine();
            passtxt = scan.nextLine();
          }

          if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
            MainMenu menu =new MainMenu();
            dispose(); // لما بتنتقل على صفحة المنيو بسكر الصفحة اللي بعدها
          } 
          else if(puname.equals("") && ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            txuser.setText("");
            pass.setText("");
            txuser.requestFocus();
          }
        } catch (IOException d) {
          d.printStackTrace();
        }
  
      
  }

  

    public static void main(String[] args) {
        new login.Login();
        
    }
    
}
