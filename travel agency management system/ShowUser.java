import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ShowUser extends ConnectionManager
{ 
   final String[] columnNames = {"ID","Name", "Phone", "City"};
   JButton b1;
   String name,city;
   long phone;
   int id;
public ShowUser()
{
	JFrame show = new JFrame("Database Result");
	b1=new JButton("back");
	show.add(b1);
	b1.setBounds(0,0,100,30);
		
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(columnNames);
	
	
	JTable table = new JTable();	
	table.setModel(model); 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	JScrollPane scroll = new JScrollPane(table);
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 	
	
	try
	{ 
		getConnect();
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from user");
		while(rs.next())
		{
		   id=rs.getInt("ID");
   		   name = rs.getString("name");
		   phone = rs.getLong("phone");
		   city = rs.getString("city"); 
		   model.addRow(new Object[]{id,name,phone,city}); 
		}
		con.close();
 	 }catch(Exception ex){ System.out.println(ex);}
	
	b1.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    { 
		show.dispose();
	    new Travel();
    }
    });
		
	show.add(scroll);
	show.setVisible(true);
	show.setSize(450,450);
	show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	show.setLayout(new FlowLayout(FlowLayout.LEFT));
 }
}
