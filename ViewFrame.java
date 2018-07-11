import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
TextArea taData;
JButton btnBack;
JPanel p1,p2;

ViewFrame()
{

c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1 =new JPanel();
taData =new TextArea(5,30);
p1.add(taData);
c.add(p1);

p2= new JPanel();
btnBack=new JButton("Back");
p2.add(btnBack);
c.add(p2);

taData.setText(new DbHandler().viewStudent());

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent aae)
{
MainFrame a=new MainFrame();
dispose();
}
});



setTitle("View student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}//end of constructor
}

