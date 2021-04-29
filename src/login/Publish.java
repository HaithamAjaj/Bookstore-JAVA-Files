
package login;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Publish extends JFrame {
 public JFrame f; 
 public ImageIcon image;
 public JLabel lable,lable1,lable2,lable3,lable4,lable5;
 public JButton back,calculat,send,test;
 public JTextField t1,t2,t3,t4,t5;
 public Font f1;
    
public Publish(){
    
setLayout(new FlowLayout());
f=new JFrame();
f1 = new Font("Arial",Font.BOLD,40);
calculat = new JButton("Calculate"); 
back = new JButton("Back");
send = new JButton("Send");


t1= new JTextField();
t2= new JTextField();
t3= new JTextField();
t4= new JTextField();
t5= new JTextField();

image = new ImageIcon(getClass().getResource("11.jpg"));

lable = new JLabel(image); //main

lable1 = new JLabel("Number of page");
lable2 = new JLabel("Number of books");
lable3 = new JLabel("Paper quality 70% or 100%");
lable4 = new JLabel("Number of bookstores(10 or 15 or 20)");
lable5 = new JLabel("Total");


t1.setBounds(1050,150,100,30);
t2.setBounds(1050,250,100,30);
t3.setBounds(1050,350,100,30);
t4.setBounds(1050,450,100,30);
t5.setBounds(1050,550,100,30);

t1.setSize(200,50);
t2.setSize(200,50);
t3.setSize(200,50);
t4.setSize(200,50);
t5.setSize(200,50);

t1.setText("0");
t2.setText("0");
t3.setText("0");
t4.setText("0");
t5.setText("0");


lable1.setFont(f1);
lable1.setForeground(Color.orange);
lable1.setBackground(Color.yellow);
lable2.setFont(f1);
lable2.setForeground(Color.orange);
lable2.setBackground(Color.yellow);
lable3.setFont(f1);
lable3.setForeground(Color.orange);
lable3.setBackground(Color.yellow);
lable4.setFont(f1);
lable4.setForeground(Color.orange);
lable4.setBackground(Color.yellow);
lable5.setFont(f1);
lable5.setForeground(Color.orange);
lable5.setBackground(Color.yellow);


lable1.setBounds(50,120,1000,100);
lable2.setBounds(50,220,1000,100);
lable3.setBounds(50,320,1000,100);
lable4.setBounds(50,420,1000,100);
lable5.setBounds(50,520,1000,100);

calculat.setBounds(760,615,200,50);
f.add(calculat);

back.setBounds(280,615,200,50);
f.add(back);

send.setBounds(520,615,200,50);
f.add(send);



f.add(lable1);f.add(lable2);f.add(lable3);f.add(lable4);f.add(lable5);


f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);
f.add(lable);
f.setVisible(true);
f.setSize(1400,1000);
f.setLocation(-10, 0);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        back();
        f.setVisible(false);

      }
    });

calculat.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        
        calculatePrice();    
      }
    });

Writer writer = null;
    File check = new File("Publish.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("Publish.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }

send.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       
       send();  
      
      }});    





}

public void back(){

    MainMenu main = new MainMenu();
}

public void calculatePrice(){

            double number_of_pages = Double.parseDouble(t1.getText());
            double nbooks = Double.parseDouble(t2.getText()) ;;
            double paper_quality = Double.parseDouble(t3.getText());
            double Bookstores = Double.parseDouble(t4.getText());
            
          
            int x = (int)paper_quality;
            if(x == 100){
                paper_quality = 4;
            }
            else if(x == 70){
                paper_quality = 2;
            }
            else {
                paper_quality = 0;
            }
           
            
            int n = (int) Bookstores;
            if(n==10){
                Bookstores = 60;
            }
            else if (n==15){
                Bookstores = 70;
            }
            
            else if(n==20){
                Bookstores = 80;
            }
            else {
                Bookstores = 0;
            }
             
            
     double Total = ((number_of_pages*0.005*nbooks)+(number_of_pages*paper_quality)+Bookstores);

        DecimalFormat df = new DecimalFormat("$#.00");//creates decimal in currency format
        t5.setText(df.format(Total)); //
          
}

public void send(){

     try {
          File file = new File("Publish.txt");
          Scanner scan = new Scanner(file);
          FileWriter filewrite = new FileWriter(file, true);
          FileReader r = new FileReader("userPass.txt");
          int x;
          while ((x = r.read()) != -1){
          filewrite.write(x);
          }
          filewrite.write("Number of page is "+t1.getText()+"\n");
          filewrite.write("Number of books is "+t2.getText()+"\n");
          filewrite.write("Quality is "+t3.getText()+"\n");
          filewrite.write("Number of Bookstore is "+t4.getText()+"\n");
          
          
        }
      catch (IOException d) {
          d.printStackTrace();
        }
}

}


   
