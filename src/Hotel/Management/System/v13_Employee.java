package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v13_Employee extends JFrame {
    v13_Employee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM employee";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setBounds(350,500,120,30);
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        button.setFocusable(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.white);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(159,11,70,19);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.white);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        job.setForeground(Color.white);
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        salary.setForeground(Color.white);
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        phone.setForeground(Color.white);
        panel.add(phone);

        JLabel email = new JLabel("Email");
        email.setBounds(786,11,70,19);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        email.setForeground(Color.white);
        panel.add(email);

        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(896,11,70,19);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        aadhar.setForeground(Color.white);
        panel.add(aadhar);

        this.setSize(1000,600);
        this.setLayout(null);
        this.setLocation(430,100);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new v13_Employee();
    }
}
