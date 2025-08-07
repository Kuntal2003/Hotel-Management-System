package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class v6_admin extends JFrame implements ActionListener {
    JButton addEmployee,addRoom,addDriver,logout,back;
    v6_admin(){

        addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(250,230,200,30);
        addEmployee.setBackground(Color.WHITE);
        addEmployee.setForeground(Color.BLACK);
        addEmployee.setFont(new Font("Tahoma",Font.BOLD,15));
        addEmployee.setFocusable(false);
        addEmployee.addActionListener(this);
        this.add(addEmployee);

        addRoom = new JButton("Add Room");
        addRoom.setBounds(250,380,200,30);
        addRoom.setBackground(Color.WHITE);
        addRoom.setForeground(Color.BLACK);
        addRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        addRoom.setFocusable(false);
        addRoom.addActionListener(this);
        this.add(addRoom);

        addDriver = new JButton("Add Drivers");
        addDriver.setBounds(250,530,200,30);
        addDriver.setBackground(Color.WHITE);
        addDriver.setForeground(Color.BLACK);
        addDriver.setFont(new Font("Tahoma",Font.BOLD,15));
        addDriver.setFocusable(false);
        addDriver.addActionListener(this);
        this.add(addDriver);

        logout = new JButton("Logout");
        logout.setBounds(10,800,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.setFocusable(false);
        logout.addActionListener(this);
        this.add(logout);

        back = new JButton("BACK");
        back.setBounds(110,800,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.setFocusable(false);
        back.addActionListener(this);
        this.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image scaleImg = imageIcon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon newImg = new ImageIcon(scaleImg);
        JLabel label = new JLabel(newImg);
        label.setBounds(70,180,120,120);
        this.add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image scaleImg1 = imageIcon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon newImg1 = new ImageIcon(scaleImg1);
        JLabel label1 = new JLabel(newImg1);
        label1.setBounds(70,340,120,120);
        this.add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image scaleImg2 = imageIcon2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon newImg2 = new ImageIcon(scaleImg2);
        JLabel label2 = new JLabel(newImg2);
        label2.setBounds(70,500,120,120);
        this.add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image scaleImg3 = imageIcon3.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon newImg3 = new ImageIcon(scaleImg3);
        JLabel label3 = new JLabel(newImg3);
        label3.setBounds(1000,200,400,400);
        this.add(label3);

        this.setSize(1950,1090);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(3,45,48));
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v6_admin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addEmployee){
            new v8_addEmployee();
        } else if (e.getSource()==addRoom) {
            new v7_addRoom();
        }else if (e.getSource() == addDriver){
            new v9_addDriver();
        } else if (e.getSource() == logout) {
            System.exit(1);
        }else{
            new v4_Dashboard();
            this.setVisible(false);
        }
    }
}
