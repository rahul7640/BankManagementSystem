package com.bms.repo.entity;

import com.bms.repository.ShowCustomers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDetails extends JFrame {
    CustomerDetails(){
        setTitle("Customer Details");
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton a1 = new JButton("All Customers");
        a1.setBounds(115,80,140,40);
        a1.setFont(new Font("Arial",Font.BOLD,12));
        add(a1);

        JButton a2 = new JButton("Search by Id");
        a2.setBounds(115,130,140,40);
        a2.setFont(new Font("Arial",Font.BOLD,12));
        add(a2);

        JButton a3 = new JButton("Search by Name");
        a3.setBounds(115,180,140,40);
        a3.setFont(new Font("Arial",Font.BOLD,12));
        add(a3);

        JButton a4 = new JButton("Exit");
        a4.setBounds(115,230,140,40);
        a4.setFont(new Font("Arial",Font.BOLD,12));
        add(a4);
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });

        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new ShowCustomers();
            }
        });
        setVisible(true);
    }
}
