package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v2_login extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField;
    JButton b1,b2;
    v2_login(){
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        this.add(label1);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.white);

        textField1 = new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        this.add(textField1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        this.add(label2);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(26,104,110));
        this.add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label3 = new JLabel(imageIcon1);
        label3.setBounds(315,0,255,300);
        this.add(label3);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.PLAIN,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        this.add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(190,140,120,30);
        b2.setFont(new Font("serif",Font.PLAIN,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        this.add(b2);

        this.setLayout(null);
        this.setSize(600,300);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(3,45,48));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new v2_login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            try{
//                DataBase d = new DataBase();
//                String user = textField1.getText();
//                String pass = passwordField.getText();
//
//                String q = "select * from login where username = '"+user+"' AND password = '"+pass+"'";
//                ResultSet resultSet = d.statement.executeQuery(q);
//                if(resultSet.next()){
//                    this.setVisible(false);
//                }else{
//                    JOptionPane.showMessageDialog(null,"Invalid Login");
//                }
                v3_new_database db = new v3_new_database();
                String user = textField1.getText();
                String pass = passwordField.getText();
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                preparedStatement.setString(1,user);
                preparedStatement.setString(2,pass);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    this.setVisible(false);
                    new v4_Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid login");
                }
            }catch(Exception e1){
               e1.printStackTrace();
            }
        }else{
            System.exit(0);
        }
    }
}
