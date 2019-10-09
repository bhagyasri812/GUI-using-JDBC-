    
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Gui1 extends Frame implements ActionListener 
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
Button b1,b2,b3,b4;
Connection con=null;
Gui1()
{
	l1=new Label("empno");
	t1=new TextField(20);
	l2=new Label("name");
	
	
	t2=new TextField(20);
	l3=new Label("address");
	t3=new TextField(20);
	b1=new Button("INSERT");
	b2=new Button("UPDATE");
	b3=new Button("DELETE");
	b4=new Button("SELECT");
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	setLayout(new FlowLayout());
	add(l1);add(t1);
	add(l2);add(t2);
	add(l3);add(t3);
	add(b1);add(b2);
	add(b3);add(b4);
}
public static void main(String[] args)
{
	Gui1 ob=new Gui1();
	ob.setVisible(true);
	ob.setSize(400,400);
	
}
public void actionPerformed(ActionEvent ae) 
{
	   try
	   {
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	      con=DriverManager.getConnection
	    		  ("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456789");
	   }
	   catch(Exception ab)
	   {
	        ab.printStackTrace();
	   }
	        
	        if(ae.getSource()==(b1))
	        {
	        try
	        {
	    
	     PreparedStatement st=con.prepareStatement("insert into mphasi values(?,?,?)");
	     String x=t1.getText();
	     String y=t2.getText();
	     String z=t3.getText();
	     int p=Integer.parseInt(x);
	     st.setInt(1,p);
	     st.setString(2,y);
	     st.setString(3,z);
	     st.execute();
	     System.out.println("one row inserted");
	   }

	        catch(Exception ab)
	        {
	             System.out.println(ab);
	        }
	        }
	        if(ae.getSource()==(b2))
	        {
	             try
	             {
	   PreparedStatement st=con.prepareStatement("update mphasi set name=?,address=? where empno=?");
	     String x=t1.getText();
	     String y=t2.getText();
	     String z=t3.getText();
	     int p=Integer.parseInt(x);
	    st.setString(1,y);
	     st.setString(2,z);
	     st.setInt(3,p);
	     st.execute();
	     System.out.println("one row updated");
	             }
	             catch(Exception rt)
	             {
	                  rt.printStackTrace();
	             }          
	             
	        }
	        if(ae.getSource()==(b3))
	        {
	             try
	             {
	   PreparedStatement st=con.prepareStatement("delete  from mphasi where empno=?");
	     String x=t1.getText();
	    // String y=t2.getText();
	    // String z=t3.getText();
	     int p=Integer.parseInt(x);
	   // st.setString(1,y);
	   //  st.setString(2,z);
	     st.setInt(1,p);
	     st.execute();
	     System.out.println("one row updated");
	             }
	             catch(Exception rt)
	             {
	                  rt.printStackTrace();
	             }          
	             
	        }
	        if(ae.getSource()==(b4))
	        {
	             try
	             {
	   //PreparedStatement st=con.prepareStatement("select * from mphasi");
	    //String x=t1.getText();
	    // String y=t2.getText();
	    // String z=t3.getText();
	     //int p=Integer.parseInt(x);
	   // st.setString(1,y);
	   //  st.setString(2,z);
	     //st.setInt(1,p);
	     
	     Statement st1=con.createStatement();
			ResultSet rs=st1.executeQuery("select * from mphasi");  
			
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
	     System.out.println("one row updated");
	             }
	             catch(Exception rt)
	             {
	                  rt.printStackTrace();
	             }          
	             
	        }

	
}

}