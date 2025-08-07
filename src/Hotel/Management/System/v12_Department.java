package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v12_Department extends JFrame {
    v12_Department(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        this.add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(4,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM department";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton button = new JButton("Back");
        button.setBounds(400,410,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setFocusable(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        JLabel label2 = new JLabel("Budget");
        label2.setBounds(440,11,105,20);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        this.setSize(700,500);
        this.setLayout(null);
        this.setLocation(550,150);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v12_Department();
    }
}
