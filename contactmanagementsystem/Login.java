package contactmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
//import java.lang.System.Logger;
import java.sql.*;
import java.util.logging.Level;

public class Login extends JFrame implements ActionListener {

    JButton cancel, login;
    JTextField usernameTextField;
    JPasswordField PassTextField;
    JLabel password, username;

    Login() {

        setTitle("CONTACT MANAGEMENT SYSTEM");
        setLayout(null);

        JLabel text = new JLabel("WELCOME TO PHONEBOOK");
        text.setBounds(430, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/i.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(50, 0, 350, 750);//600,450
        add(image);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/grp.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(0, 0, 2500, 750);//600,450
        add(secimage);

        username = new JLabel("UserName : ");
        username.setBounds(500, 160, 1100, 150);
        username.setFont(new Font("Raleway", Font.BOLD, 28));
        add(username);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(720, 220, 250, 30);
        usernameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(usernameTextField);

        password = new JLabel("Password : ");
        password.setBounds(500, 240, 1100, 150);
        password.setFont(new Font("Raleway", Font.BOLD, 28));
        add(password);

        PassTextField = new JPasswordField();
        PassTextField.setBounds(720, 300, 250, 30);
        PassTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(PassTextField);

        cancel = new JButton("CANCEL");
        cancel.setBounds(590, 440, 100, 30);
        cancel.setBackground(Color.GREEN);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        login = new JButton("LOGIN");
        login.setBounds(790, 440, 100, 30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == login) {
            setVisible(false);
           new Home();
          
            String username = usernameTextField.getText();
            String password = PassTextField.getText();
            
            try {
                Conn c = new Conn();
                String query = "Select *from Login where username='" + username + "' and password='" + password + "'";
                c.s.executeQuery(query);
                if (username.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Enter Email");
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Enter Phone NO as Password");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Login Successful");
                    setVisible(false);
                    new Home();

                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);

        }


    }

    public static void main(String args[]) {
        new Login();
    }
}
