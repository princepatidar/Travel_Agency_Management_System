import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Register extends ConnectionManager
{
	JLabel l1,l2,l3;
  	JTextField t1,t2,t3;
  	JButton b1,b2;
public Register()
{
	JFrame register=new JFrame("Register");	       
	
	b1=new JButton("back");
	b1.setBounds(0,0,100,30);
	register.add(b1);

	b2=new JButton("Apply");
    b2.setBounds(80,250,100,30);
	register.add(b2);

	l1=new JLabel("Name");
	l1.setBounds(50,100, 100,30);
	register.add(l1);

	t1=new JTextField();
	t1.setBounds(140,100, 100,30);
	register.add(t1);

    l2=new JLabel("Phone no.");
	l2.setBounds(50,150, 100,30);
	register.add(l2);

	t2=new JTextField();
	t2.setBounds(140,150, 100,30);
	register.add(t2);
	
    l3=new JLabel("City");
	l3.setBounds(50,200, 100,30);
	register.add(l3);
	  
	t3=new JTextField();
	t3.setBounds(140,200, 100,30);
	register.add(t3);
		
	b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
		register.dispose();
	    new Travel();
    }
    });       

	b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
	   String name=t1.getText();
	   String phone1=t2.getText();
	   String city=t3.getText();
        try{  
		
  				if(phone1.equals("")||name.equals("")||city.equals("")) //If user is null
               		 JOptionPane.showMessageDialog(null,"All entries are not completed."); //Display dialog box with the message
          		else{
						long phone=Long.parseLong(phone1);
						getConnect();
						PreparedStatement stmt=con.prepareStatement("insert into user(name,phone,city)"+"values(?,?,?)");  
 
						stmt.setString(1,name);  
						stmt.setLong(2,phone); 
						stmt.setString(3,city); 
						stmt.executeUpdate();  
			  			con.close();

						JOptionPane.showMessageDialog(null,"User is registered.");
						t1.setText("");
						t2.setText("");
						t3.setText("");	
           			}
       	   }catch(Exception ex){ System.out.println(ex);}   	
       }
       });

    register.setVisible(true);
	register.setLayout(null);
	register.setSize(400,400);
	register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
  }
}
