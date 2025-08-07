package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class v21_CheckOut extends JFrame {
    v21_CheckOut(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,100,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel userId = new JLabel("Customer ID: ");
        userId.setBounds(30,80,150,30);
        userId.setFont(new Font("Tahoma",Font.BOLD,14));
        userId.setForeground(Color.WHITE);
        panel.add(userId);
        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);
        try{
            v3_new_database db = new v3_new_database();
            String query = "Select * from customer";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("number");
                choice.add(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel roomNum = new JLabel("Room Number: ");
        roomNum.setBounds(30,130,150,30);
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNum.setForeground(Color.WHITE);
        panel.add(roomNum);

        JLabel labelRoom = new JLabel();
        labelRoom.setBounds(200,130,100,30);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        JLabel checkInTime = new JLabel("Check In Time: ");
        checkInTime.setBounds(30,180,150,30);
        checkInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkInTime.setForeground(Color.WHITE);
        panel.add(checkInTime);

        JLabel labelCheckInTime = new JLabel();
        labelCheckInTime.setBounds(200  ,180,300,30);
        labelCheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JLabel CheckOutTime = new JLabel("Check Out Time: ");
        CheckOutTime.setBounds(30,230,150,30);
        CheckOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        CheckOutTime.setForeground(Color.WHITE);
        panel.add(CheckOutTime);

        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy h:m a (E)");
        String MyDate = df.format(dt);
        JLabel labelCheckOutTime = new JLabel();
        labelCheckOutTime.setText(MyDate);
        labelCheckOutTime.setBounds(200  ,230,300,30);
        labelCheckOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckOutTime.setForeground(Color.WHITE);
        panel.add(labelCheckOutTime);

        JButton checkout = new JButton("Check Out");
        checkout.setBounds(30,300,120,30);
        checkout.setForeground(Color.white);
        checkout.setBackground(Color.BLACK);
        checkout.setFocusable(false);
        panel.add(checkout);
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v3_new_database db = new v3_new_database();
                try{
                    String query2 = "SELECT * FROM customer WHERE number = ?";
                    PreparedStatement preparedStatement2 = db.connection.prepareStatement(query2);
                    preparedStatement2.setString(1,choice.getSelectedItem());
                    ResultSet resultSet = preparedStatement2.executeQuery();
                    while (resultSet.next()){
                        String roomNo = resultSet.getString("room");
                        String query1 = "UPDATE room SET cleaningStatus = ? WHERE roomNumber = ?";
                        PreparedStatement preparedStatement1 = db.connection.prepareStatement(query1);
                        preparedStatement1.setString(1,"Dirty");
                        preparedStatement1.setString(2,roomNo);
                        preparedStatement1.executeUpdate();
                        String query3 = "UPDATE room SET availability = ? WHERE roomNumber = ?";
                        PreparedStatement preparedStatement3 = db.connection.prepareStatement(query3);
                        preparedStatement3.setString(1,"Available");
                        preparedStatement3.setString(2,roomNo);
                        preparedStatement3.executeUpdate();
                    }
                    String roomQuery = "SELECT * FROM customer WHERE number = ?";
                    PreparedStatement preparedStatement6 = db.connection.prepareStatement(roomQuery);
                    preparedStatement6.setString(1,choice.getSelectedItem());
                    ResultSet resultSet6 = preparedStatement6.executeQuery();
                    while (resultSet6.next()){
                        String roomNumber = resultSet6.getString("room");
                        String deposit = resultSet6.getString("deposit");
                        String query5 = "SELECT * FROM room WHERE roomNumber = ?";
                        PreparedStatement preparedStatement5 = db.connection.prepareStatement(query5);
                        preparedStatement5.setString(1,roomNumber);
                        ResultSet resultSet1 = preparedStatement5.executeQuery();
                        while (resultSet1.next()){
                            String price = resultSet1.getString("price");
                            if(deposit.equals(price)){
                                String query = "DELETE FROM customer WHERE number = ?";
                                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                                preparedStatement.setString(1,choice.getSelectedItem());
                                preparedStatement.executeUpdate();
                                JOptionPane.showMessageDialog(null,"Check out Completed","Successful",JOptionPane.PLAIN_MESSAGE);
                                setVisible(false);
                            }else{
                                int num = Integer.parseInt(price)-Integer.parseInt(deposit);
                                JOptionPane.showMessageDialog(null,"Due Amount: "+num);
                            }
                        }
                    }




                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        check.setFocusable(false);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v3_new_database db = new v3_new_database();
                try {
                    String query = "SELECT * FROM customer WHERE number = ?";
                    PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                    preparedStatement.setString(1,choice.getSelectedItem());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        labelRoom.setText(resultSet.getString("room"));
                        labelCheckInTime.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setFocusable(false);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        this.setSize(800,400);
        this.setLocation(500,210);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v21_CheckOut();
    }
}
