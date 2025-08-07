package Hotel.Management.System;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v17_customerInfo extends JFrame {
    v17_customerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM customer";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel id = new JLabel("Id");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150,11,100,14);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270,11,100,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360,11,100,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(480,11,100,20);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(600,11,100,14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        JLabel CheckinTime = new JLabel("CheckinTime");
        CheckinTime.setBounds(680,11,100,14);
        CheckinTime.setForeground(Color.WHITE);
        CheckinTime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(CheckinTime);

        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(800,11,100,14);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Deposit);

        JButton button = new JButton("Back");
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setBounds(450,510,120,30);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        this.setSize(900,600);
        this.setLocation(500,100);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
    new v17_customerInfo();
    }
}
