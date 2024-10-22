package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class employee extends JFrame implements ActionListener{

    JTextField tfname, tfroll;
    JButton submit, cancel;
    employee() {
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        add(p);
        
        JLabel heading = new JLabel("Employee Details");
        heading.setBounds(180, 10, 200, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblname = new JLabel("Employee Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);
        
        JLabel lblrollno = new JLabel("Employee ID");
        lblrollno.setBounds(100, 120, 100, 20);
        p.add(lblrollno);
        
        tfroll = new JTextField();
        tfroll.setBounds(240,120,200,20);
        p.add(tfroll);
        
        
        submit = new JButton("Submit");
        submit.setBounds(120, 390, 100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        p.add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        

        
        add(p, "Center");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String empid= tfroll.getText();
            
            
            String query = "insert into employee values('"+empid+"', '"+name+"')";
  
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
              
                
                JOptionPane.showMessageDialog(null, "Employee Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new employee();
    }
}
