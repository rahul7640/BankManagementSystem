package com.bms.repository;

import com.bms.db.DbConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStaff extends JFrame {
    public DeleteStaff() {
        setTitle("Delete Customer");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Enter Staff Username to Delete:");
        label.setBounds(40, 30, 200, 25);
        add(label);

        JTextField staffIdField = new JTextField();
        staffIdField.setBounds(200, 30, 120, 25);
        add(staffIdField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(130, 80, 100, 30);
        add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String staffId = staffIdField.getText().trim();

                if (staffId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Staff ID cannot be empty");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Connection con = DbConnection.getConnection();
                        String sql = "DELETE FROM staff WHERE staff_id = ?";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, staffId);

                        int rows = pst.executeUpdate();
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(null, "Staff deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No staff found with this ID.");
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
