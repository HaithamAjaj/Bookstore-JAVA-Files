
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
import java.text.*;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import java.io.*;
import java.util.Scanner;


public class Design extends JFrame {
 public JFrame f; 
 public JPanel p,p1;
 public ImageIcon image;
 public JLabel lable,lable1,lable2,lable3,lable4,lable5,lt,l1,l2;
 public JRadioButton r1,r2,r3;
 public JCheckBox m1,m2,m3;
 public JButton back,show,border;
 public JTextField t1,t2,t3,t4,t5;
 public Font f1,f2,f3,f4;
 

public Design(){
r1 = new JRadioButton("Yellow");
r2= new JRadioButton("White"); 
r3 = new JRadioButton("light pink"); 


m1 = new JCheckBox("Lucida");
m2 = new JCheckBox("Calibri");
m3 = new JCheckBox("Andalus");

show = new JButton("Send");
border = new JButton("Add a border");
back = new JButton("Back");
setLayout(new FlowLayout());
f=new JFrame();
p = new JPanel();
p1 = new JPanel();

f1 = new Font("Lucida Calligraphy",Font.BOLD,40);
back = new JButton("Back");
image = new ImageIcon(getClass().getResource("3.jpg"));

f4 = new Font("Times New Roman",Font.BOLD,20);

r1.setFont(f4);
r2.setFont(f4);
r3.setFont(f4);
m1.setFont(f4);
m2.setFont(f4);
m3.setFont(f4);
back.setFont(f4);
show.setFont(f4);
border.setFont(f4);


lable = new JLabel(image);
lt = new JLabel("Choose the right font");//main
lable1 = new JLabel("Number of page");


p.setBounds(80, 80, 500, 500);

p1.setBounds(80, 80, 480, 480);


r1.setBounds(800, 80, 150, 50);
r2.setBounds(1000, 80, 150, 50);
r3.setBounds(1200, 80, 150, 50);

m1.setBounds(800, 150, 150, 50);
m2.setBounds(1000, 150, 150, 50);
m3.setBounds(1200, 150, 150, 50);

show.setBounds(1000,500, 150, 50);
border.setBounds(800,400, 150, 50);
back.setBounds(1200,600, 150, 50);
lt.setBounds(105, 110, 250, 140);

f1 = new Font("Lucida Calligraphy",Font.BOLD,30);
f2 = new Font("Calibri",Font.BOLD,30);
f3 = new Font("Andalus",Font.BOLD,30);



f.add(m1);f.add(m2);f.add(m3);
f.add(r1);f.add(r2);f.add(r3);

f.add(show);
f.add(border);
f.add(back);
p1.add(lt);
p.add(p1);
f.add(p);
f.add(lable);
f.setVisible(true);
f.setSize(1400,1000);
f.setLocation(-10, 0);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


r1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        yellow();
      }
    });
r2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        white();
      
      }
    });
r3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        pink();
        
      }
    });


m1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        lucida();
        
      }
    });
m2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       calibri();
          
      }
    });
m3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        andalus();
        
      }
    });


Writer writer = null;
    File check = new File("design.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("design.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }
border.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
          
          addBorder(); 
         
      }
    });

back.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        back();
        f.setVisible(false);

      }
    });
show.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       
          send();
      
      }});



}

public void yellow(){
        r2.setSelected(false);
        r3.setSelected(false); 
        p1.setBackground(Color.yellow);
        p.setBackground(Color.yellow); 

}

public void white(){
        r1.setSelected(false);
        r3.setSelected(false);
        p1.setBackground(Color.WHITE);
        p.setBackground(Color.WHITE); 

}

public void pink(){
    
        r2.setSelected(false);
        r1.setSelected(false); 
        p1.setBackground(Color.getHSBColor(255, 255, 153));
        p.setBackground(Color.getHSBColor(255, 255, 153)); 

}

public void lucida(){

        m2.setSelected(false);
        m3.setSelected(false); 
        lt.setFont(f1);
        lt.setBackground(Color.BLACK);
}

public void calibri(){

        m1.setSelected(false);
        m3.setSelected(false);
        lt.setFont(f2);
        lt.setBackground(Color.BLACK);
}

public void andalus(){
        m2.setSelected(false);
        m1.setSelected(false); 
        lt.setFont(f3);
        lt.setBackground(Color.BLACK);

}

public void addBorder(){

          p.setForeground(Color.black); 
          p1.setBackground(Color.white);
}

public void send(){
    
    try {
          File file = new File("design.txt");
          Scanner scan = new Scanner(file);;
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);
          FileReader r = new FileReader("userPass.txt");
          
          int x;
          while ((x = r.read()) != -1){
          filewrite.write(x);
          }
          
          
          if(r1.isSelected()){
              filewrite.write("the color is yellow \n");
              
          }
          else if(r2.isSelected()){
              filewrite.write("the color is White \n");
              
          }
          else if(r3.isSelected()){
              filewrite.write("the color is Light pink \n");
              
          }
          
          if(m1.isSelected()){
              
              filewrite.write("the font is Lucida Calligraphy ");
              filewrite.close();
          }
          else if(m2.isSelected()){
              filewrite.write("the font is Calibri");
              filewrite.close();
          }
          else if(m3.isSelected()){
              filewrite.write("the font is Andalus");
              filewrite.close();
          }
          
          
        }
      catch (IOException d) {
          d.printStackTrace();
        }

}

public void back(){

    MainMenu main = new MainMenu();
}
}

  
