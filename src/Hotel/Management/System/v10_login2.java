package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class v10_login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField;
    JButton b1,b2;
    v10_login2(){
        JPanel panel = new JPanel();
        panel.setBounds(490,300,600,300);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        this.add(panel);
        JLabel label1 = new JLabel("Username");
        label1.setBounds(40,20,100,30);
        panel.add(label1);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        label1.setForeground(Color.white);

        textField1 = new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField1.setBackground(new Color(26,104,110));
        panel.add(textField1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,70,100,30);
        panel.add(label2);
        label2.setFont(new Font("Tahoma",Font.BOLD,16));
        label2.setForeground(Color.white);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(26,104,110));
        panel.add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i1 = imageIcon.getImage().getScaledInstance(275,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label3 = new JLabel(imageIcon1);
        label3.setBounds(315,0,275,300);
        panel.add(label3);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.PLAIN,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.addActionListener(this);
        panel.add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(190,140,120,30);
        b2.setFont(new Font("serif",Font.PLAIN,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icon/Dashboard.gif"));
        Image i2 = img.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i2);
        JLabel label = new JLabel();
        label.setBounds(0,0,1950,1090);
        label.setIcon(img1);
        this.add(label);

        this.setLayout(null);
        this.setSize(1950,1090);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v10_login2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            v3_new_database db = new v3_new_database();
            String userName = textField1.getText();
            String Password = passwordField.getText();
            String query = "SELECT * FROM adminT WHERE password = ?";
            try{

                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                preparedStatement.setString(1,Password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    new v6_admin();
                    setVisible(false);


                }else{
                    JOptionPane.showMessageDialog(null,"Wrong id pass");
                }
            }catch(Exception e1){
                System.out.println(e1.toString());
            }
        }else{
            this.setVisible(false);
            new v4_Dashboard();
        }
    }
}
