import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LogIn extends JFrame{
Container c;
JButton btnLogin;
JLabel lblName,lblPass;
JTextField txtName;
JPasswordField pass;
JPanel p1,p2,p3,m;
LogIn()
{
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
m =new JPanel();
c.add(m);
p1 =new JPanel();
lblName = new JLabel("User Name");
txtName = new JTextField(10);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2=new JPanel();
lblPass = new JLabel("Password");
pass= new JPasswordField(10);
p2.add(lblPass);
p2.add(pass);
c.add(p2);

p3=new JPanel();
btnLogin =new JButton("LOGIN");
p3.add(btnLogin);
c.add(p3);



btnLogin.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
String n1,p1;
n1=txtName.getText();
p1=pass.getText();

if(n1.equals("admin") && p1.equals("1234"))
{
	
MainFrame a = new MainFrame();
dispose();
}
else
JOptionPane.showMessageDialog(c,"Invalid ID/Password");
txtName.requestFocus();
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
LogIn m = new LogIn();
}
}

