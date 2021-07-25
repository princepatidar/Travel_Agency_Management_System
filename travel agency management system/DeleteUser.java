import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteUser extends ConnectionManager
{
	JTextField t1;
	JButton b1,b2;
	JLabel l1;
public DeleteUser()
{
	JFrame remove=new JFrame("Delete");
	l1= new JLabel("Id");
	l1.setBounds(50,70,100,30);
	remove.add(l1);

	t1 = new JTextField();
	t1.setBounds(170,70,100,30);
	remove.add(t1);

	b1 =new JButton("Delete");
	b1.setBounds(115,110,100,30);
	remove.add(b1);

	b2=new JButton("back");
	b2.setBounds(0,0,100,30);
	remove.add(b2);	

	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		String id1=t1.getText();
		try{  
	     	if(id1.equals("")) //If id is null
               	   JOptionPane.showMessageDialog(null,"Please enter user id"); //Display dialog box with the message 
          	else{
		    	int id=Integer.parseInt(id1);
		    	getConnect();			
		    	PreparedStatement stmt=con.prepareStatement("delete from user where id=+?"); 
		    	stmt.setInt(1,id); 
		    	stmt.execute();		    
			
		        JOptionPane.showMessageDialog(null,"Successfully Deleted.");
		        con.close();  		    
		        t1.setText("");
            }
   		}catch(Exception ex){ System.out.println(ex);}
    } 
   	});

	b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    { 
	   remove.dispose();
	   new Travel();
    }
    });
	
    remove.setVisible(true);
	remove.setSize(400,400);
	remove.setLayout(null);	
	remove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}


