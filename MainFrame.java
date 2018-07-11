import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete;
MainFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete= new JButton("Delete");

c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
AddFrame a = new AddFrame();
dispose();
}
});



btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{

ViewFrame a= new ViewFrame();
dispose();
}
});



btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a = new UpdateFrame();
dispose();
}
});




btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a = new DeleteFrame();
dispose();
}
});

setTitle("Student Management System");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}//end of constructor

public static void main(String []a)
{
MainFrame m = new MainFrame();
}

}


class DbHandler{


public void addStudent(int rno, String name){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
String sql="insert into student values(?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
long r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(), "1 row inserted");
con.close();
}
catch(Exception e){
JOptionPane.showMessageDialog(new JDialog(),"issue aisa hai ki "+ e);
}
}


public String viewStudent(){
StringBuffer sb= new StringBuffer();
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
String sql="select * from student";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
sb.append("Roll No- "+ rs.getInt(1)+ "Name-"+ rs.getString(2)+"\n");
}
rs.close();
con.close();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(new JDialog(),"issue"+ e);
}
return sb.toString();
}

public void deleteStudent(int rno)
{
	try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
		String sql="delete from student where rno=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,rno);
		long r=pst.executeUpdate();
		JOptionPane.showMessageDialog(new JDialog()," 1 record deleted");
		con.close();
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(new JDialog(),"issue "+ e);
		}
}

public void updateStudent(int rno , String name) {
		try{
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
		String sql="update student set name=? where rno=? ";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,name);
		pst.setInt(2,rno);
		long r=pst.executeUpdate();
		JOptionPane.showMessageDialog(new JDialog(), "1 Record Updated");
		con.close();
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(new JDialog(),"issue "+ e);
		}
}
}




