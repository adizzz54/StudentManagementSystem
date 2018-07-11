import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JPanel p1,p2;
JButton btnSave, btnBack;

DeleteFrame()
{

c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblRno= new JLabel("Rno");
txtRno= new JTextField(4);

p1.add(lblRno);
p1.add(txtRno);
c.add(p1);


p2= new JPanel();
btnSave=new JButton("Delete");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);

btnSave.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent aee)
	{
		String rno=txtRno.getText();
		if(rno.equals(""))
		{
			JOptionPane.showMessageDialog(new JDialog(),"Roll Number field is empty");
			txtRno.requestFocus();
		}
		new DbHandler().deleteStudent(Integer.parseInt(rno));
		txtRno.setText("");
		txtRno.requestFocus();
	}
}); 

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aae)
{
MainFrame a=new MainFrame();
dispose();
}
});


setTitle("Delete student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}//end of constructor
}

