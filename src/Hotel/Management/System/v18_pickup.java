package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v18_pickup extends JFrame {
    v18_pickup(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JLabel pickUp = new JLabel("Pick Up Service");
        pickUp.setBounds(90,11,160,20);
        pickUp.setForeground(Color.WHITE);
        pickUp.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(pickUp);

        JLabel typeOfCar = new JLabel("Type of Car: ");
        typeOfCar.setBounds(32,94,89,20);
        typeOfCar.setForeground(Color.WHITE);
        typeOfCar.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(typeOfCar);

        Choice choice = new Choice();
        choice.setBounds(123,94,150,25);
        panel.add(choice);

        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM driver";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                choice.add(resultSet.getString("company"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            v3_new_database db1 = new v3_new_database();
            String query1 = "SELECT * FROM driver";
            PreparedStatement preparedStatement = db1.connection.prepareStatement(query1);
            ResultSet resultSet = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e1){
            e1.printStackTrace();
        }
        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,20);
        name.setForeground(Color.white);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,20);
        age.setForeground(Color.white);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,46,20);
        gender.setForeground(Color.white);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366,208,150,20);
        company.setForeground(Color.white);
        panel.add(company);
        JLabel carname = new JLabel("Car Name");
        carname.setBounds(486,208,100,20);
        carname.setForeground(Color.white);
        panel.add(carname);
        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,20);
        available.setForeground(Color.white);
        panel.add(available);
        JLabel location = new JLabel("Location");
        location.setBounds(700,208,100,20);
        location.setForeground(Color.white);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFocusable(false);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v3_new_database db = new v3_new_database();
                String query = "SELECT * FROM driver WHERE company = ?";
                try{
                    PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                    preparedStatement.setString(1,choice.getSelectedItem());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        this.setSize(800,600);
        this.setLocation(500,100);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v18_pickup();
    }
}
