package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class EntryData extends JFrame implements ActionListener {

    JTextField nametext, nicknametext, phonetext, mobiletext, emailtext, addresstext;
    JButton add, back;

    EntryData() {

        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);

        JLabel text = new JLabel("ADD CONTACT HERE");
        text.setBounds(470, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(550, 150, 100, 50);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(700, 160, 230, 30);
        add(nametext);

        JLabel nicname = new JLabel("Nick Name : ");
        nicname.setFont(new Font("Raleway", Font.BOLD, 20));
        nicname.setBounds(550, 210, 130, 50);
        add(nicname);

        nicknametext = new JTextField();
        nicknametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nicknametext.setBounds(700, 220, 230, 30);
        add(nicknametext);

        JLabel phone = new JLabel("Phone No : ");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(550, 270, 100, 50);
        add(phone);

        phonetext = new JTextField();
        phonetext.setFont(new Font("Raleway", Font.BOLD, 14));
        phonetext.setBounds(700, 280, 230, 30);
        add(phonetext);

        JLabel mobile = new JLabel("Mobile No : ");
        mobile.setFont(new Font("Raleway", Font.BOLD, 20));
        mobile.setBounds(550, 340, 230, 50);
        add(mobile);

        mobiletext = new JTextField();
        mobiletext.setFont(new Font("Raleway", Font.BOLD, 14));
        mobiletext.setBounds(700, 350, 230, 30);
        add(mobiletext);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(550, 390, 230, 50);
        add(email);

        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtext.setBounds(700, 400, 230, 30);
        add(emailtext);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(550, 440, 230, 50);
        add(address);

        addresstext = new JTextField();
        addresstext.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstext.setBounds(700, 450, 230, 30);
        add(addresstext);

        add = new JButton("Add Contact");
        add.setBounds(540, 540, 200, 40);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Times New Roman", Font.BOLD, 28));
        add.addActionListener(this);
        add(add);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
      

        if (ae.getSource() == add) {
            JOptionPane.showMessageDialog(null, "You are Registered");

        String name = nametext.getText();
        String nicname = nicknametext.getText();
        String phone = phonetext.getText();
        String mobile = mobiletext.getText();
        String email = emailtext.getText();
        String address = addresstext.getText();
        
            try {
                connect c = new connect();
                String query = "Insert into add_contact values('" + name + "', '" + nicname + "', '" + phone + "', '" + mobile + "', '" + email + "','" + address + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "You are Registered");

                //JOptionPane.showMessageDialog(rootPane, "Data Inserted");
                this.setVisible(false);
                new Home().setVisible(true);

            } catch (HeadlessException | SQLException ex) {
            }
        }
        if (ae.getSource() == back) {
            setVisible(false);
            new Home().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new EntryData();
    }
}
