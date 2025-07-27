package com.bms.repo.entity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateStaff extends JFrame {
    public CreateStaff(){
                setTitle("Create New Staff Login");
                setSize(350, 250);
                setLayout(null);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                JLabel userLabel = new JLabel("Username:");
                userLabel.setBounds(30, 30, 80, 25);
                add(userLabel);

                JTextField userField = new JTextField();
                userField.setBounds(120, 30, 150, 25);
                add(userField);

                JLabel passLabel = new JLabel("Password:");
                passLabel.setBounds(30, 70, 80, 25);
                add(passLabel);

                JPasswordField passField = new JPasswordField();
                passField.setBounds(120, 70, 150, 25);
                add(passField);

                JButton createBtn = new JButton("Create");
                createBtn.setBounds(100, 130, 100, 30);
                add(createBtn);

                createBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = userField.getText().trim();
                        String password = new String(passField.getPassword()).trim();

                        if (username.isEmpty() || password.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
                            return;
                        }

                        try {
                            // 1. Load JDBC driver (optional for newer versions)
                            Class.forName("com.mysql.cj.jdbc.Driver");

                            // 2. Connect to DB
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "root123");

                            // 3. Insert query
                            String query = "INSERT INTO staff_login (username, password) VALUES (?, ?)";
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1, username);
                            pst.setString(2, password);

                            int rows = pst.executeUpdate();
                            if (rows > 0) {
                                JOptionPane.showMessageDialog(null, "Staff Created Successfully!");
                                dispose();
                            }

                            con.close();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                        }
                    }
                    });

                setLocationRelativeTo(null);
                setVisible(true);
            }
        }

