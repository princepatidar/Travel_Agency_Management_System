import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateUser extends ConnectionManager
{
	JButton b1,b2;
	JLabel l;
	JTextField t;	
public UpdateUser()
{
	JFrame modify=new JFrame("Update");

	l=new JLabel("Id");
	l.setBounds(50,100,100,30);
	modify.add(l);

	t=new JTextField();
	t.setBounds(150,100,100,30);
	modify.add(t);

    b1=new JButton("Update");
	b1.setBounds(100,150,100,30);	
	modify.add(b1);
	
	b2=new JButton("back");
	modify.add(b2);
	b2.setBounds(0,0, 100,30);
	modify.setLayout(null);

	b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    { 
		modify.dispose();
		new Travel();
    }
    });   

	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		String id1=t.getText();
	 	try{  
				getConnect();
				int id=Integer.parseInt(id1);
				PreparedStatement stmt=con.prepareStatement("select * from user where id=?"); 
				
				stmt.setInt(1,id);  
				ResultSet rs = stmt.executeQuery();  
            	if (rs.next()) 
            	{ 
       				JLabel l1,l2,l3;
  					JTextField t1,t2,t3;
  					JButton b3;

					l1=new JLabel("Name");
					l1.setBounds(50,40, 100,30);
					modify.add(l1);

					t1=new JTextField();
					t1.setBounds(140,40, 100,30);
					modify.add(t1);

		        	l2=new JLabel("Phone no.");
					l2.setBounds(50,80, 100,30);
					modify.add(l2);

					t2=new JTextField();
					t2.setBounds(140,80, 100,30);
					modify.add(t2);
	
		        	l3=new JLabel("City");
					l3.setBounds(50,120, 100,30);
					modify.add(l3);
	  
					t3=new JTextField();
					t3.setBounds(140,120, 100,30);
					modify.add(t3);
			
					b3=new JButton("Apply");
        			b3.setBounds(80,170,100,30);
					modify.add(b3);
			
					b1.setVisible(false);
					l.setVisible(false);
					t.setVisible(false);
			
	     			b3.addActionListener(new ActionListener(){
        			public void actionPerformed(ActionEvent e)
        			{ 	
			  			String name=t1.getText();
	  		  			String phone=t2.getText();
	   		  			String city=t3.getText();
           		  		try{  
				     		if(phone.equals("")||name.equals("")||city.equals("")) //If username is null
               					JOptionPane.showMessageDialog(null,"All entries are not completed."); //Display dialog box with the message
           			        else 
           			        { 
								getConnect();	   
						 		String sql="UPDATE user set name='"+name+"' ,phone='"+phone+"' ,city='"+city+"' Where id="+id1;
						 		PreparedStatement pst=con.prepareStatement(sql);
						 		pst.execute();		
							}
				 
							con.close();
							JOptionPane.showMessageDialog(null,"User is registered.");
							t1.setText("");
							t2.setText("");
							t3.setText("");
		   				}catch(Exception ex){ System.out.println(ex);  }
					} 
					}); 
				con.close();
				}else{ JOptionPane.showMessageDialog(null,"Invalid ID"); t.setText(""); }
 	 		}catch(Exception ex){ System.out.println(ex);}
       	}
       	}); 
	
 	modify.setVisible(true);
	modify.setLayout(null);
	modify.setSize(400,400);		
	modify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }	
}
