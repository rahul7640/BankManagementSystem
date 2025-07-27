package com.bms.repository;

import com.bms.db.DbConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteCustomer extends JFrame {
    public DeleteCustomer() {
        setTitle("Delete Customer");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Enter Customer ID to Delete:");
        label.setBounds(40, 30, 200, 25);
        add(label);

        JTextField custIdField = new JTextField();
        custIdField.setBounds(200, 30, 120, 25);
        add(custIdField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(130, 80, 100, 30);
        add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerId = custIdField.getText().trim();

                if (customerId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Customer ID cannot be empty");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Connection con = DbConnection.getConnection();
                        String sql = "DELETE FROM customers WHERE customer_id = ?";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, customerId);

                        int rows = pst.executeUpdate();
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(null, "Customer deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No customer found with this ID.");
                        }

                        pst.close();
                        con.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });

        setVisible(true);
    }
}
