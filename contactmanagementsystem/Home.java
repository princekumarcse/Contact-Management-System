package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {

    JButton entry, search, edit, delete, exit;

    Home() {
        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);

        JLabel text = new JLabel("PHONEBOOK");
        text.setBounds(490, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 80));
        add(text);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/pic2.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(0, 0, 2400, 750);//600,450
        add(secimage);

        entry = new JButton("ENTRY");
        entry.setBounds(630, 160, 200, 60);
        entry.setBackground(Color.BLUE);
        entry.setForeground(Color.WHITE);
        entry.setFont(new Font("Times New Roman", Font.BOLD, 38));
        entry.addActionListener(this);
        add(entry);

        search = new JButton("SEARCH");
        search.setBounds(630, 240, 200, 60);
        search.setBackground(Color.BLUE);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Times New Roman", Font.BOLD, 38));
        search.addActionListener(this);
        add(search);

        edit = new JButton("EDIT");
        edit.setBounds(630, 320, 200, 60);
        edit.setBackground(Color.BLUE);
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("Times New Roman", Font.BOLD, 38));
        edit.addActionListener(this);
        add(edit);

        delete = new JButton("DELETE");
        delete.setBounds(630, 400, 200, 60);
        delete.setBackground(Color.BLUE);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 38));
        delete.addActionListener(this);
        add(delete);

        exit = new JButton("EXIT");
        exit.setBounds(630, 480, 200, 60);
        exit.setBackground(Color.BLUE);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Times New Roman", Font.BOLD, 38));
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == entry) {
            this.setVisible(false);
            new EntryData().setVisible(true);
        } else if (ae.getSource() == search) {
            this.setVisible(false);
            new SearchData().setVisible(true);
        } else if (ae.getSource() == edit) {
            this.setVisible(false);
            new EditData().setVisible(true);
        } else if (ae.getSource() == delete) {
            this.setVisible(false);
            new DeleteData().setVisible(true);
        } else if (ae.getSource() == exit) {
            this.setVisible(false);

        }

    }

    public static void main(String args[]) {
        new Home();
    }
}
