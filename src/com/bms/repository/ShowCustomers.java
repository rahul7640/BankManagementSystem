package com.bms.repository;

import com.bms.db.DbConnection;
import com.bms.service.StaffPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowCustomers extends JFrame {
    JTable table;
    DefaultTableModel model;

    public ShowCustomers() {
        setTitle("Customer Details");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table Header
        String[] columns = {"Customer ID", "Name", "Father Name", "Phone", "District", "Pincode"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Exit Button
        JButton exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        exitBtn.setBackground(Color.RED);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setFocusPainted(false);
        exitBtn.setPreferredSize(new Dimension(100, 40));

        // Add button to bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(exitBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new StaffPanel();
            }
        });

        loadData();

        setVisible(true);
    }

    private void loadData() {
        try {
            Connection con = DbConnection.getConnection();
            String query = "SELECT * FROM customers";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String id = rs.getString("customer_id");
                String name = rs.getString("name");
                String father = rs.getString("father_name");
                String phone = rs.getString("phone");
                String district = rs.getString("district");
                String pincode = rs.getString("pincode");

                model.addRow(new Object[]{id, name, father, phone, district, pincode});
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
