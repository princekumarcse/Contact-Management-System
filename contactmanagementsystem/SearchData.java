package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SearchData extends JFrame implements ActionListener {

    JTextField nametext;
    JButton search, back;

    SearchData() {

        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);

        JLabel text = new JLabel("SEARCH YOUR DATA HERE");
        text.setBounds(430, 0, 1100, 150);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);

        JLabel name = new JLabel("Enter Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(530, 250, 150, 50);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(700, 260, 260, 40);
        add(nametext);

        search = new JButton("SEARCH");
        search.setBounds(540, 540, 200, 40);
        search.setBackground(Color.BLUE);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Times New Roman", Font.BOLD, 28));
        //search.addActionListener(this);
        add(search);
        back = new JButton("BACK");
        back.setBounds(830, 540, 100, 40);
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

            try {
                connect c = new connect();
                String query = "Select name from add_contact where name='" + name + "'";
                Result rest=c.s.executeUpdate(query);

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
    }

    public static void main(String rags[]) {
        new SearchData();
    }

}
