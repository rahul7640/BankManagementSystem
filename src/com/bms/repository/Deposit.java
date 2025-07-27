package com.bms.repository;

import com.bms.db.DbConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Deposit extends JFrame {
    JTextField customerIdField, amountField;

    public Deposit() {
        setTitle("Deposit Amount");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label1 = new JLabel("Customer ID:");
        label1.setBounds(50, 50, 100, 30);
        add(label1);

        customerIdField = new JTextField();
        customerIdField.setBounds(170, 50, 150, 30);
        add(customerIdField);

        JLabel label2 = new JLabel("Deposit Amount:");
        label2.setBounds(50, 100, 120, 30);
        add(label2);

        amountField = new JTextField();
        amountField.setBounds(170, 100, 150, 30);
        add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(130, 160, 100, 30);
        add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositMoney();
            }
        });

        setVisible(true);
    }

    private void depositMoney() {
        String customerId = customerIdField.getText();
        String amtStr = amountField.getText();

        if (customerId.isEmpty() || amtStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amtStr);
            Connection con = DbConnection.getConnection();

            // Check if customer exists
            String checkQuery = "SELECT balance FROM customers WHERE customer_id = ?";
            PreparedStatement pst = con.prepareStatement(checkQuery);
            pst.setString(1, customerId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                double newBalance = currentBalance + amount;

                // Update balance
                String updateQuery = "UPDATE customers SET balance = ? WHERE customer_id = ?";
                PreparedStatement updatePst = con.prepareStatement(updateQuery);
                updatePst.setDouble(1, newBalance);
                updatePst.setString(2, customerId);
                updatePst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Amount Deposited Successfully.\nNew Balance: " + newBalance);
                updatePst.close();
            } else {
                JOptionPane.showMessageDialog(this, "Customer ID not found.");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Amount must be a number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

}
