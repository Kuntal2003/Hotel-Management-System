package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class v7_addRoom extends JFrame implements ActionListener {
    JTextField t1,t3;
    JComboBox t2,t4,t5;
    JButton button,button2;
    v7_addRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JLabel label = new JLabel("Add Room");
        label.setBounds(194,10,160,22);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1 = new JLabel("Room number");
        label1.setBounds(64,70,152,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);
        t1 = new JTextField();
        t1.setBounds(200,70,156,20);
        t1.setFont(new Font("Tahoma",Font.PLAIN,14));
        t1.setForeground(Color.white);
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(64,110,152,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);
        String[] arr = {"Available","Occupied"};
        t2 = new JComboBox(arr);
        t2.setBounds(200,110,156,20);
        t2.setFont(new Font("Tahoma",Font.PLAIN,14));
        t2.setForeground(Color.white);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(64,150,152,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);
        t3 = new JTextField();
        t3.setBounds(200,150,156,20);
        t3.setFont(new Font("Tahoma",Font.PLAIN,14));
        t3.setForeground(Color.white);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel label4 = new JLabel("Cleaning Status");
        label4.setBounds(64,190,152,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);
        String[] arr4 ={"Cleaned","Dirty"};
        t4 = new JComboBox(arr4);
        t4.setBounds(200,190,156,20);
        t4.setFont(new Font("Tahoma",Font.PLAIN,14));
        t4.setForeground(Color.white);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        JLabel label5 = new JLabel("Bed Type");
        label5.setBounds(64,230,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);
        String[] arr5 ={"Single Bed","Double Bed"};
        t5 = new JComboBox(arr5);
        t5.setBounds(200,230,156,20);
        t5.setFont(new Font("Tahoma",Font.PLAIN,14));
        t5.setForeground(Color.white);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        button = new JButton("Add");
        button.setBounds(64,321,111,33);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setFocusable(false);
        button.addActionListener(this);
        panel.add(button);

        button2 = new JButton("Back");
        button2.setBounds(198,321,111,33);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        button2.setFocusable(false);
        button2.addActionListener(this);
        panel.add(button2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image scaleImg = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(scaleImg);
        JLabel label6 = new JLabel(imageIcon1);
        label6.setBounds(500,60,300,300);
        panel.add(label6);

        this.setSize(885,500);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(60,160);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v7_addRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            v3_new_database db = new v3_new_database();
            String Room_number = t1.getText();
            String Availability = (String) t2.getSelectedItem();
            String Price = t3.getText();
            String Cleaning_Status = (String) t4.getSelectedItem();
            String Bed_Type = (String) t5.getSelectedItem();
            String query = "INSERT INTO room (roomNumber,availability,price,cleaningStatus,bedType)Values(?,?,?,?,?)";
            try{
                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                preparedStatement.setString(1,Room_number);
                preparedStatement.setString(2,Availability);
                preparedStatement.setString(3,Price);
                preparedStatement.setString(4,Cleaning_Status);
                preparedStatement.setString(5,Bed_Type);
                int num = preparedStatement.executeUpdate();
                if(num > 0){
                    JOptionPane.showMessageDialog(null,"successful Operation","operation",JOptionPane.PLAIN_MESSAGE);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"error");
                }
            }catch(Exception e1){
                System.out.println(e1.getMessage());
            }

        }else{
            setVisible(false);
        }
    }
}
