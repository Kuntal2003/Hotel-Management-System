package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v19_UpdateCheck extends JFrame {
    v19_UpdateCheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("ID: ");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,20);
        panel.add(choice);
        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM customer";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("number");
                choice.add(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number: ");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);
        JTextField textField3 = new JTextField();
        textField3.setBounds(248,129,140,20);
        panel.add(textField3);

        JLabel label4 = new JLabel("Name: ");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
        JTextField textField4 = new JTextField();
        textField4.setBounds(248,174,140,20);
        panel.add(textField4);

        JLabel label5 = new JLabel("Check-In: ");
        label5.setBounds(25,216,97,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        JTextField textField5 = new JTextField();
        textField5.setBounds(248,216,140,20);
        panel.add(textField5);

        JLabel label6 = new JLabel("Amount paid (Rs): ");
        label6.setBounds(25,261,140,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);
        JTextField textField6 = new JTextField();
        textField6.setBounds(248,261,140,20);
        panel.add(textField6);

        JLabel label7 = new JLabel("Pending Amount (Rs): ");
        label7.setBounds(25,302,150,20);
        label7.setFont(new Font("Tahoma",Font.PLAIN,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);
        JTextField textField7 = new JTextField();
        textField7.setBounds(248,302,140,20);
        panel.add(textField7);

        JButton check = new JButton("Check");
        check.setBounds(100,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFocusable(false);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                v3_new_database db1 = new v3_new_database();
                String query = "SELECT * FROM customer WHERE number = ? ";
                try{
                    PreparedStatement preparedStatement = db1.connection.prepareStatement(query);
                    preparedStatement.setString(1,id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        String roomNumber = resultSet.getString("room");
                        String Name = resultSet.getString("name");
                        String checkIn = resultSet.getString("checkintime");
                        String paid = resultSet.getString("deposit");
                        textField3.setText(roomNumber);
                        textField4.setText(Name);
                        textField5.setText(checkIn);
                        textField6.setText(paid);
                        String query1 = "SELECT * FROM room WHERE roomNumber = ? ";
                        PreparedStatement preparedStatement1 = db1.connection.prepareStatement(query1);
                        preparedStatement1.setString(1,roomNumber);
                        ResultSet resultSet1 = preparedStatement1.executeQuery();
                        while (resultSet1.next()) {
                            String total = resultSet1.getString("price");
                            int num  = Integer.parseInt(total)-Integer.parseInt(paid);
                            String pending = Integer.toString(num);
                            textField7.setText(pending);
                        }
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton update = new JButton("update");
        update.setBounds(250,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFocusable(false);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v3_new_database db = new v3_new_database();
                String id = choice.getSelectedItem();
                String roomNumber = textField3.getText();
                String Name = textField4.getText();
                String checkIn = textField5.getText();
                String paid = textField6.getText();
                String query = "UPDATE customer SET room = ?, name = ?, checkintime = ?, deposit = ? WHERE number = ?";
                try{
                    PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                    preparedStatement.setString(1,roomNumber);
                    preparedStatement.setString(2,Name);
                    preparedStatement.setString(3,checkIn);
                    preparedStatement.setString(4,paid);
                    preparedStatement.setString(5,id);
                    int num1 = preparedStatement.executeUpdate();
                    String query1 = "SELECT * FROM room WHERE roomNumber = ? ";
                    JOptionPane.showMessageDialog(null,"Updated","Successfull",JOptionPane.PLAIN_MESSAGE);
                    PreparedStatement preparedStatement1 = db.connection.prepareStatement(query1);
                    preparedStatement1.setString(1,roomNumber);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    while (resultSet1.next()) {
                        String total = resultSet1.getString("price");
                        int num  = Integer.parseInt(total)-Integer.parseInt(paid);
                        String pending = Integer.toString(num);
                        textField7.setText(pending);
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(400,378,89,23);
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

        this.setSize(950,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,200);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v19_UpdateCheck();
    }
}