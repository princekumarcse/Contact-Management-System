package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteData extends JFrame implements ActionListener {

    JTextField nametext;
    JButton delete, back;
    
    DeleteData() {

        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);
        
        JLabel text = new JLabel("DELETE YOUR DATA");
         text.setBounds(530, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);
        
         JLabel name = new JLabel("Enter Name For Delete : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(500, 250, 250, 50);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(750, 260, 260, 40);
        add(nametext);
        
        delete = new JButton("DELETE");
        delete.setBounds(540, 440, 200, 40);
        delete.setBackground(Color.BLUE);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 28));
        delete.addActionListener(this);
        add(delete);

         back = new JButton("BACK");
        back.setBounds(830, 440, 100, 40);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
         back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);

    }

     public void actionPerformed(ActionEvent ae) {

        String name = nametext.getText();
        if (ae.getSource() == delete) {
            JOptionPane.showMessageDialog(null, "Your Data is Deleted");

            try {
                connect c = new connect();
                String query = "Select name from add_contact where name='" + name + "'";
                c.s.executeUpdate(query);

                if (ae.getSource() == delete) {
                    JOptionPane.showMessageDialog(null, "Your Data Deleted");
                    //String name = connect.getString("name");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new DeleteData();
    }
}
