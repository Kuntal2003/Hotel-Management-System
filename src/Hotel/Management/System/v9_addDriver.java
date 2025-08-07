package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class v9_addDriver extends JFrame implements ActionListener {
    JTextField nameTXT,ageText,ccText,cnText,locationText;
    JComboBox genderBox,availableBox;
    JButton add,back;
    v9_addDriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        this.add(panel);

        JLabel label = new JLabel("Add Driver");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        JLabel name = new JLabel("Name");
        name.setBounds(64,70,102,22);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.white);
        panel.add(name);
        nameTXT = new JTextField();
        nameTXT.setBounds(174,70,150,27);
        nameTXT.setBackground(new Color(16,108,115));
        nameTXT.setFont(new Font("Tahoma",Font.BOLD,14));
        nameTXT.setForeground(Color.white);
        panel.add(nameTXT);

        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.white);
        panel.add(age);
        ageText = new JTextField();
        ageText.setBounds(174,110,150,27);
        ageText.setBackground(new Color(16,108,115));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.white);
        panel.add(ageText);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(64,150,102,22);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.white);
        panel.add(gender);
        String[] arr = {"Male","Female"};
        genderBox = new JComboBox(arr);
        genderBox.setBackground(new Color(16,108,115));
        genderBox.setBounds(174,150,154,27);
        genderBox.setFont(new Font("Tahoma",Font.BOLD,14));
        genderBox.setForeground(Color.WHITE);
        panel.add(genderBox);

        JLabel cc = new JLabel("Car Company");
        cc.setBounds(64,190,102,22);
        cc.setFont(new Font("Tahoma",Font.BOLD,14));
        cc.setForeground(Color.white);
        panel.add(cc);
        ccText = new JTextField();
        ccText.setBounds(174,190,150,27);
        ccText.setBackground(new Color(16,108,115));
        ccText.setFont(new Font("Tahoma",Font.BOLD,14));
        ccText.setForeground(Color.white);
        panel.add(ccText);

        JLabel cn = new JLabel("Car Name");
        cn.setBounds(64,230,102,22);
        cn.setFont(new Font("Tahoma",Font.BOLD,14));
        cn.setForeground(Color.white);
        panel.add(cn);
        cnText = new JTextField();
        cnText.setBounds(174,230,150,27);
        cnText.setBackground(new Color(16,108,115));
        cnText.setFont(new Font("Tahoma",Font.BOLD,14));
        cnText.setForeground(Color.white);
        panel.add(cnText);

        JLabel available = new JLabel("Availability");
        available.setBounds(64,270,102,22);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.white);
        panel.add(available);
        String[] arr1 = {"Yes","No"};
        availableBox = new JComboBox(arr1);
        availableBox.setBackground(new Color(16,108,115));
        availableBox.setBounds(174,270,154,27);
        availableBox.setFont(new Font("Tahoma",Font.BOLD,14));
        availableBox.setForeground(Color.WHITE);
        panel.add(availableBox);

        JLabel location = new JLabel("Location");
        location.setBounds(64,310,102,22);
        location.setFont(new Font("Tahoma",Font.BOLD,14));
        location.setForeground(Color.white);
        panel.add(location);
        locationText = new JTextField();
        locationText.setBounds(174,310,150,27);
        locationText.setBackground(new Color(16,108,115));
        locationText.setFont(new Font("Tahoma",Font.BOLD,14));
        locationText.setForeground(Color.white);
        panel.add(locationText);

        add = new JButton("ADD");
        add.setBounds(64,380,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setFocusable(false);
        add.addActionListener(this);
        panel.add(add);
        back = new JButton("BACK");
        back.setBounds(198,380,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon newImg = new ImageIcon(image);
        JLabel label1 = new JLabel(newImg);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        this.setSize(900,500);
        this.setLayout(null);
        this.setLocation(60,160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v9_addDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            v3_new_database db = new v3_new_database();
            String name = nameTXT.getText();
            String age = ageText.getText();
            String gender = (String) genderBox.getSelectedItem();
            String company = ccText.getText();
            String carName = cnText.getText();
            String available = (String) availableBox.getSelectedItem();
            String location = locationText.getText();
            String query = "INSERT INTO driver (name,age,gender,company,carname,available,location) VALUES (?,?,?,?,?,?,?)";
            try{
                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,age);
                preparedStatement.setString(3,gender);
                preparedStatement.setString(4,company);
                preparedStatement.setString(5,carName);
                preparedStatement.setString(6,available);
                preparedStatement.setString(7,location);
                int num = preparedStatement.executeUpdate();
                if(num > 0){
                    JOptionPane.showMessageDialog(null,"Inserted Successfully","Successful",JOptionPane.PLAIN_MESSAGE);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }catch(Exception e1){
                System.out.println(e.toString());
            }
        }else{
            this.setVisible(false);
        }
    }
}
