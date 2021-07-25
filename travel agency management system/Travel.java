import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Travel{
    JButton b1,b2,b3,b4,b5;
      
public Travel()
{
    JFrame travel=new JFrame("Travel");  
    b1=new JButton("Register");  
    b1.setBounds(50,150,100,30);  
    travel.add(b1);  
    
    b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
	    travel.dispose();
        new Register();	  
    }
    });

    b2=new JButton("Show User");  
    b2.setBounds(180,150,100,30);  
    travel.add(b2);  
    
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
        travel.dispose();
	    new ShowUser();
    }  
    });

    b3=new JButton("Delete User");  
    b3.setBounds(125,200,100,30);  
    travel.add(b3);  
    
    b3.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
	    travel.dispose();
        new DeleteUser();	  
    }
    });
  
    b4=new JButton("Update");  
    b4.setBounds(255,200,100,30);  
    travel.add(b4);  
    
    b4.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
	    travel.dispose();
        new UpdateUser();	  
    }
    }); 

    b5=new JButton("Search");  
    b5.setBounds(310,150,100,30);  
    travel.add(b5);  
    
    b5.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
    	travel.dispose();
        new Search();	  
    }
    });   

    travel.setSize(480,480);  
    travel.setLayout(null);  
    travel.setVisible(true); 
    travel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}  
 public static void main(String[] args){
        new Travel();
     } 
}