package com.bms.ui;

import com.bms.repository.Login;
import com.bms.service.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    public AdminLogin() {
        setTitle("Admin Login");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Admin Login");
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
        button.setBounds(110,200,80,30);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = field.getText();
                String password = field1.getText();

                if(username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    dispose();
                    new AdminPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });
        JButton button1 = new JButton("Exit");
        button1.setBounds(200,200,80,30);
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        setVisible(true);

    }
    }
