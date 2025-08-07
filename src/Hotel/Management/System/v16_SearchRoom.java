package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v16_SearchRoom extends JFrame implements ActionListener {
    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton search,back;
    v16_SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JLabel searchForName = new JLabel("SearchForName");
        searchForName.setBounds(250,11,186,31);
        searchForName.setForeground(Color.WHITE);
        searchForName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(searchForName);

        JLabel bedType = new JLabel("Search Bed Type");
        bedType.setBounds(50,70,125,18);
        bedType.setForeground(Color.WHITE);
        bedType.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bedType);

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setBounds(23,162,150,20);
        roomNumber.setForeground(Color.WHITE);
        roomNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNumber);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel cleaning = new JLabel("Cleaning Status");
        cleaning.setBounds(306,162,150,20);
        cleaning.setForeground(Color.WHITE);
        cleaning.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(cleaning);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bedType1 = new JLabel("Bed Type");
        bedType1.setBounds(580,162,150,20);
        bedType1.setForeground(Color.WHITE);
        bedType1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bedType1);

        checkBox = new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.white);
        checkBox.setBackground(new Color(3,45,48));
        checkBox.setFocusable(false);
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(180,70,120,20);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM room";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(200,120,120,30);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        search.setFocusable(false);
        panel.add(search);

        back = new JButton("Back");
        back.setBounds(380,120,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusable(false);
        panel.add(back);


        this.setSize(700,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500,200);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v16_SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String choice1 = choice.getSelectedItem();
            Boolean check = checkBox.isSelected();
            v3_new_database db1 = new v3_new_database();
            String query1 = "SELECT * FROM room WHERE availability = ? AND bedType = ?";
            String query2 = "SELECT * FROM room WHERE bedType = ?";
            try{
                if (check){
                    PreparedStatement preparedStatement = db1.connection.prepareStatement(query1);
                    preparedStatement.setString(1,"Available");
                    preparedStatement.setString(2,choice1);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }else{
                    PreparedStatement preparedStatement1 = db1.connection.prepareStatement(query2);
                    preparedStatement1.setString(1,choice1);
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }else{
            this.setVisible(false);
        }
    }
}
