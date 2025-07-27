package com.bms.repo.entity;

import com.bms.db.DbConnection;
import com.bms.service.StaffPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddCustomer extends JFrame {
    public AddCustomer(){
        setTitle("Staff Login");
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Customer Details");
        label.setBounds(118,40,200,30);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);

        JLabel label1 = new JLabel("Customer Name");
        label1.setBounds(130,110,100,40);
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        add(label1);

        JLabel label2 = new JLabel("Father Name");
        label2.setBounds(130,140,100,40);
        label2.setFont(new Font("Arial", Font.BOLD, 12));
        add(label2);

        JLabel phn = new JLabel("Phone Number");
        phn.setBounds(130,170,100,40);
        phn.setFont(new Font("Arial", Font.BOLD, 12));
        add(phn);

        JLabel dis = new JLabel("District");
        dis.setBounds(130,200,100,40);
        dis.setFont(new Font("Arial",Font.BOLD,12));
        add(dis);

        JLabel pin = new JLabel("Pin Code");
        pin.setBounds(130,230,100,40);
        pin.setFont(new Font("Arial", Font.BOLD,12));
        add(pin);

        JLabel id = new JLabel("Customer ID");
        id.setBounds(130,260,100,40);
        id.setFont(new Font("Arial", Font.BOLD,12));
        add(id);

        JTextField name = new JTextField();
        name.setBounds(280,120,100,22);
        add(name);
        JTextField father = new JTextField();
        father.setBounds(280,150,100,22);
        add(father);
        JTextField num = new JTextField();
        num.setBounds(280,180,100,22);
        add(num);
        JTextField diss = new JTextField();
        diss.setBounds(280,210,100,22);
                add(diss);
        JTextField pinn = new JTextField();
        pinn.setBounds(280,240,100,22);
        add(pinn);
        JTextField cusId = new JTextField();
        cusId.setBounds(280,270,100,22);
        add(cusId);

        JButton create = new JButton("Create");
        create.setBounds(160,320,100,30);
        add(create);

        JButton ex = new JButton("Exit");
        ex.setBounds(290,320,100,30);
        add(ex);
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StaffPanel();
            }
        });

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cname = name.getText();
                String fname = father.getText();
                String phone = num.getText();
                String district = diss.getText();
                String pincode = pinn.getText();
                String customerId = cusId.getText();

                try {
                    Connection con = DbConnection.getConnection();
                    String sql = "INSERT INTO customers (customer_id, name, father_name, phone, district, pincode) VALUES (?, ?, ?, ?, ?, ?)";
                    java.sql.PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, customerId);
                    ps.setString(2, cname);
                    ps.setString(3, fname);
                    ps.setString(4, phone);
                    ps.setString(5, district);
                    ps.setString(6, pincode);

                    int inserted = ps.executeUpdate();
                    if (inserted > 0) {
                        JOptionPane.showMessageDialog(null, "Customer created successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error inserting customer.");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
                if(cname.isEmpty() || customerId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all mandatory fields.");
                    return;
                }

            }
        });

        setVisible(true);
    }
}
