package com.bms.service;

import com.bms.repo.entity.CreateStaff;
import com.bms.repository.DeleteCustomer;
import com.bms.repository.DeleteStaff;
import com.bms.repository.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
    public AdminPanel(){
        setTitle("Admin Panel");
        setSize(600,600);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lable = new JLabel("Admin Panel");
        lable.setBounds(190,50,320,70);
        lable.setFont(new Font("Arial", Font.BOLD, 24));
        add(lable);

        JButton cus = new JButton("Create New Staff");
        cus.setBounds(180,140,200,40);
        add(cus);
        cus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateStaff();
            }
        });

        JButton cus1 = new JButton("Delete Customer");
        cus1.setBounds(180,185,200,40);
        add(cus1);
        cus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           new DeleteCustomer();
            }
        });

        JButton log = new JButton("Delete Staff");
        log.setBounds(180,230,200,40);
        add(log);
        log.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
         new DeleteStaff();
            }
        });

       JButton sig = new JButton("Sign Out");
        sig.setBounds(180,275,200,40);
        add(sig);
sig.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new Login();
    }
});
        setVisible(true);
    }
}
