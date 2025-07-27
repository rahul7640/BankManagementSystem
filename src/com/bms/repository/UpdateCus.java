package com.bms.repository;

import com.bms.db.DbConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UpdateCus extends JFrame {
        JTextField idField, nameField, fatherField, phoneField, districtField, pinField;

        public UpdateCus() {
            setTitle("Update Customer");
            setSize(400, 400);
            setLayout(null);
            setLocationRelativeTo(null);

            JLabel lbl = new JLabel("Enter Customer ID:");
            lbl.setBounds(30, 20, 150, 30);
            add(lbl);

            idField = new JTextField();
            idField.setBounds(180, 20, 150, 25);
            add(idField);

            JButton searchBtn = new JButton("Search");
            searchBtn.setBounds(140, 60, 100, 30);
            add(searchBtn);

            JLabel nameLbl = new JLabel("Name:");
            nameLbl.setBounds(30, 110, 100, 25);
            add(nameLbl);
            nameField = new JTextField();
            nameField.setBounds(180, 110, 150, 25);
            add(nameField);

            JLabel fatherLbl = new JLabel("Father Name:");
            fatherLbl.setBounds(30, 150, 100, 25);
            add(fatherLbl);
            fatherField = new JTextField();
            fatherField.setBounds(180, 150, 150, 25);
            add(fatherField);

            JLabel phoneLbl = new JLabel("Phone:");
            phoneLbl.setBounds(30, 190, 100, 25);
            add(phoneLbl);
            phoneField = new JTextField();
            phoneField.setBounds(180, 190, 150, 25);
            add(phoneField);

            JLabel distLbl = new JLabel("District:");
            distLbl.setBounds(30, 230, 100, 25);
            add(distLbl);
            districtField = new JTextField();
            districtField.setBounds(180, 230, 150, 25);
            add(districtField);

            JLabel pinLbl = new JLabel("Pincode:");
            pinLbl.setBounds(30, 270, 100, 25);
            add(pinLbl);
            pinField = new JTextField();
            pinField.setBounds(180, 270, 150, 25);
            add(pinField);

            JButton updateBtn = new JButton("Update");
            updateBtn.setBounds(140, 320, 100, 30);
            add(updateBtn);

            // 🔍 Search button logic
            searchBtn.addActionListener(e -> {
                String id = idField.getText();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter Customer ID");
                    return;
                }
                fetchCustomer(id);
            });

            // ✅ Update button logic
            updateBtn.addActionListener(e -> {
                String id = idField.getText();
                String name = nameField.getText();
                String father = fatherField.getText();
                String phone = phoneField.getText();
                String district = districtField.getText();
                String pincode = pinField.getText();

                try {
                    Connection con = DbConnection.getConnection();
                    String sql = "UPDATE customers SET name=?, father_name=?, phone=?, district=?, pincode=? WHERE customer_id=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, father);
                    pst.setString(3, phone);
                    pst.setString(4, district);
                    pst.setString(5, pincode);
                    pst.setString(6, id);

                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Customer updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "No customer found with given ID");
                    }

                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            });

            setVisible(true);
        }

        // 🧠 Function to fetch existing details
        private void fetchCustomer(String id) {
            try {
                Connection con = DbConnection.getConnection();
                String query = "SELECT * FROM customers WHERE customer_id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    fatherField.setText(rs.getString("father_name"));
                    phoneField.setText(rs.getString("phone"));
                    districtField.setText(rs.getString("district"));
                    pinField.setText(rs.getString("pincode"));
                } else {
                    JOptionPane.showMessageDialog(this, "Customer not found");
                }

                rs.close();
                pst.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

