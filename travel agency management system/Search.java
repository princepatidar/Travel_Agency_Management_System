import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Search extends ConnectionManager
{
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5;
public Search()
{
	JFrame search=new JFrame("Search");
	l5= new JLabel("Id");
	l5.setBounds(150,30,20,30);
	search.add(l5);

	t5 = new JTextField();
	t5.setBounds(170,30,100,30);
	search.add(t5);

	b1 =new JButton("Search");
	b1.setBounds(115,70,100,30);
	search.add(b1);

	b2=new JButton("back");
	b2.setBounds(0,0, 100,30);
	search.add(b2);

	l1 = new JLabel("ID");  
    l1.setBounds(20, 120, 100, 20);  
    t1 = new JTextField(50);  
    t1.setBounds(130, 120, 200, 20);  
    l2 = new JLabel("Name");  
    l2.setBounds(20, 150, 100, 20);  
    t2 = new JTextField(100);  
    t2.setBounds(130, 150, 200, 20);  
    l3 = new JLabel("Phone no.");  
    l3.setBounds(20, 180, 100, 20);  
    t3 = new JTextField(50);  
    t3.setBounds(130, 180, 200, 20);  
    l4 = new JLabel("City");  
    l4.setBounds(20, 210, 100, 20);  
    t4 = new JTextField(50);  
    t4.setBounds(130, 210, 100, 20);
  
    search.add(l1);  
    search.add(t1);  
    search.add(l2);  
    search.add(t2);  
    search.add(l3);  
    search.add(t3);  
    search.add(l4);  
    search.add(t4);  
        //Set TextField Editable False  
    t1.setEditable(false);  
    t2.setEditable(false);  
    t3.setEditable(false);  
    t4.setEditable(false);

	b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){ 
	   search.dispose();
	   new Travel();
    }
    });

	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		String id1=t5.getText();
    	try{  
	            if(id1.equals("")) //If username is null
               	   JOptionPane.showMessageDialog(null,"Please enter user id"); //Display dialog box with the message
                else
                {
		            int id=Integer.parseInt(id1); 
			        getConnect();
		            PreparedStatement stmt=con.prepareStatement("select * from user where id=?"); 
		            stmt.setInt(1,id); 
		            ResultSet rs = stmt.executeQuery();  
            	    if (rs.next()) 
                    {  
                	   String s = rs.getString(1);  
                	   String s1 = rs.getString(2);  
                	   String s2 = rs.getString(3);  
                	   String s3 = rs.getString(4);  
                	   //Sets Records in TextFields.
			
                	   t1.setText(s);  
                	   t2.setText(s1);  
                	   t3.setText(s2);  
                	   t4.setText(s3);     
		            }
		            else 
                    { 
			             JOptionPane.showMessageDialog(null,"Records not found");
			             t1.setText("");  
                	     t2.setText("");  
                	     t3.setText("");  
                	     t4.setText("");
		            }
                    con.close();
		            t5.setText("");
                }
   	        }catch(Exception ex){ System.out.println(ex);}
        } 
        });

    search.setVisible(true);
	search.setSize(400,400);
	search.setLayout(null);	
	search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
