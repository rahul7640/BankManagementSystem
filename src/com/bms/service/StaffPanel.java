package com.bms.service;

import com.bms.repo.entity.AddCustomer;
import com.bms.repository.CheckBalance;
import com.bms.repository.Deposit;
import com.bms.repository.ShowCustomers;
import com.bms.repository.UpdateCus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffPanel extends JFrame {
    public StaffPanel(){
        setTitle("Staff Panel");
        setSize(600,600);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lable = new JLabel("Staff Dashboard");
        lable.setBounds(190,50,320,70);
        lable.setFont(new Font("Arial", Font.BOLD, 24));
        add(lable);

        JButton cus = new JButton("Create Customer");
        cus.setBounds(180,140,200,40);
        add(cus);

        cus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomer();
            }
        });
        JButton cus1 = new JButton("Add Money");
        cus1.setBounds(180,185,200,40);
        add(cus1);
        cus1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Deposit();
            }
        });

        JButton log = new JButton("Account Details");
        log.setBounds(180,230,200,40);
        add(log);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShowCustomers();
            }
        });

        JButton nes = new JButton("Check Balance");
        nes.setBounds(180,275,200,40);
        add(nes);
        nes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CheckBalance();
            }
        });

        JButton bck = new JButton("Update Details");
        bck.setBounds(180,320,200,40);
        add(bck);

        bck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateCus();
            }
        });



        JButton sig = new JButton("Sign Out");
        sig.setBounds(180,365,200,40);
        add(sig);
        sig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
