package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class EditData extends JFrame  implements ActionListener{

    JTextField nametext;
    JButton search, back;
    
    EditData() {
        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);
        
        JLabel text = new JLabel("EDIT YOUR DATA");
        text.setBounds(530, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);
        
         JLabel name = new JLabel("Enter Name For Edit : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(500, 250, 250, 50);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(750, 260, 260, 40);
        add(nametext);
        
        search = new JButton("SEARCH");
        search.setBounds(540, 440, 200, 40);
        search.setBackground(Color.BLUE);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Times New Roman", Font.BOLD, 28));
        search.addActionListener(this);
        add(search);

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
        if (ae.getSource() == search) {
            new Home();

            try {
                connect c = new connect();
                String query = "Select name from add_contact where name='" + name + "'";
                c.s.executeUpdate(query);

                if (ae.getSource() == search) {
                    //String name = connect.getString("name");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Home().setVisible(true);
        }

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }

    public static void main(String args[]) {
        new EditData();
    }
}
