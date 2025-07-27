package com.bms.ui;

import com.bms.repository.Login;
import com.bms.service.StaffPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffLogin extends JFrame {
    public StaffLogin(){
        setTitle("Staff Login");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Staff Login");
        label.setBounds(118,40,150,30);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(85,110,90,40);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        add(label1);
        JTextField field = new JTextField();
        field.setBounds(195,120,100,22);
        add(field);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(85,150,90,40);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        add(label2);
        JPasswordField field1 = new JPasswordField();
        field1.setBounds(195,160,100,22);
        add(field1);

        JButton button = new JButton("Login");
        button.setBounds(110,205,80,30);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = field.getText().trim();
                String password = new String(field1.getPassword()).trim();

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "root123");

                    String query = "SELECT * FROM staff_login WHERE username=? AND password=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, username);
                    pst.setString(2, password);

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        String role = rs.getString("role");
                        JOptionPane.showMessageDialog(null, "Login successful! Role: " + role);

                        dispose();
                        new StaffPanel(); // Open staff dashboard
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }

                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JButton ex = new JButton("Exit");
        ex.setBounds(200,205,80,30);
        add(ex);
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        setVisible(true);
    }
}
