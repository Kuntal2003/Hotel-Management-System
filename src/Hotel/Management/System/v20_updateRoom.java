package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v20_updateRoom extends JFrame {
    v20_updateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,440);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);



        Choice choice = new Choice();
        choice.setBounds(248,129,140,20);
        panel.add(choice);
        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM room";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("roomNumber");
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


        JLabel label4 = new JLabel("Availability: ");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);
//        JTextField textField4 = new JTextField();
//        textField4.setBounds(248,174,140,20);
//        panel.add(textField4);
        JComboBox choice1 = new JComboBox();
        choice1.setBounds(248,174,140,20);
        panel.add(choice1);

        JLabel label5 = new JLabel("Cleaning Status: ");
        label5.setBounds(25,216,125,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
//        JTextField textField5 = new JTextField();
//        textField5.setBounds(248,216,140,20);
//        panel.add(textField5);
        JComboBox choice2 = new JComboBox<>();
        choice2.setBounds(248,216,140,20);
        panel.add(choice2);


        JButton check = new JButton("Check");
        check.setBounds(100,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFocusable(false);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice1.removeAllItems();
                choice2.removeAllItems();
                String id = choice.getSelectedItem();
                v3_new_database db1 = new v3_new_database();
                String query = "SELECT * FROM room WHERE roomNumber = ? ";
                try{
                    PreparedStatement preparedStatement = db1.connection.prepareStatement(query);
                    preparedStatement.setString(1,id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        String availability = resultSet.getString("availability");
                        String cleaningStatus = resultSet.getString("cleaningStatus");
//                        textField4.setText(availability);
//                        textField5.setText(cleaningStatus);
                        choice1.addItem(availability);
                        if (availability.equals("Available")){
                            choice1.addItem("Occupied");
                        }else{
                            choice1.addItem("Available");
                        }
                        choice2.addItem(cleaningStatus);
                        if (cleaningStatus.equals("Cleaned")){
                            choice2.addItem("Dirty");
                        }else{
                            choice2.addItem("Cleaned");
                        }
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton update = new JButton("update");
        update.setBounds(250,355,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFocusable(false);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v3_new_database db = new v3_new_database();
                String status = (String) choice2.getSelectedItem();
                String available = (String) choice1.getSelectedItem();
                String query = "UPDATE room SET cleaningStatus = ? , availability = ? WHERE roomNumber = ?";
                try{
                    PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                    preparedStatement.setString(1,status);
                    preparedStatement.setString(2,available);
                    preparedStatement.setString(3,choice.getSelectedItem());
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Updated","Successfull",JOptionPane.PLAIN_MESSAGE);

                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(400,355,89,23);
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

        this.setSize(950,450);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(400,200);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v20_updateRoom();
    }
}
