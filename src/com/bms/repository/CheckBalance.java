package com.bms.repository;

import com.bms.db.DbConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBalance extends JFrame {
    JTextField customerIdField;

    public CheckBalance() {
        setTitle("Check Balance");
        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label1 = new JLabel("Enter Customer ID:");
        label1.setBounds(50, 50, 150, 30);
        add(label1);

        customerIdField = new JTextField();
        customerIdField.setBounds(200, 50, 120, 30);
        add(customerIdField);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(140, 100, 100, 30);
        add(checkBtn);

        checkBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }
        });

        setVisible(true);
    }

    private void checkBalance() {
        String customerId = customerIdField.getText();

        if (customerId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Customer ID");
            return;
        }

        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT name, balance FROM customers WHERE customer_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, customerId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                JOptionPane.showMessageDialog(this,
                        "Customer Name: " + name + "\nBalance: ₹" + balance);
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found.");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
