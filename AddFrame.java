import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblRno, lblName;
JTextField txtRno, txtName;
JButton btnSave, btnBack;
JPanel p1,p2;


AddFrame()
{

c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1 =new JPanel();
lblRno =new JLabel("Rno");
txtRno =new JTextField(4);
lblName= new JLabel("Name");
txtName =new JTextField(10);
p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2= new JPanel();
btnSave=new JButton("Save");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);


btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aae)
{
String rno=txtRno.getText();
String name=txtName.getText();

if(rno.equals("") || name.equals("")) 
{
	JOptionPane.showMessageDialog(new JDialog(),"Roll Number/Name field is empty");
	txtRno.requestFocus();
}
else 
{
new DbHandler().addStudent(Integer.parseInt(rno),name);
txtRno.setText("");
txtName.setText("");
txtRno.requestFocus();
}
}
});


btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aae)
{
MainFrame a=new MainFrame();
dispose();
}
});


setTitle("Add student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}//end of constructor
}

