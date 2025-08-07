package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class v15_newCustomer extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber,textFieldName,textFieldDeposit,textFieldCountry;
    JRadioButton rMale,rFemale;
    Choice choice;
    JLabel date,time;
    JButton add,back;
    String DateTime;
    v15_newCustomer(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(4,45,48));
        this.add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(550,150,200,200);
        panel.add(jLabel);

        JLabel jLabel1 = new JLabel();
        jLabel1.setText("NEW CUSTOMER FORM");
        jLabel1.setBounds(118,11,260,53);
        jLabel1.setFont(new Font("Tahoma",Font.BOLD,20));
        jLabel1.setForeground(Color.WHITE);
        panel.add(jLabel1);

        JLabel labelId = new JLabel("ID: ");
        labelId.setBounds(35,75,200,14);
        labelId.setForeground(Color.white);
        labelId.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelId);
        String[] arr = {"Passport","Aadhar Card","Voter Card","Driving Licence"};
        comboBox = new JComboBox(arr);
        comboBox.setBounds(271,73,150,20);
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.PLAIN,14));
        comboBox.setBackground(new Color(3,45,48));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("NUMBER: ");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setForeground(Color.white);
        labelNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelNumber);
        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("NAME: ");
        labelName.setBounds(35,151,200,14);
        labelName.setForeground(Color.white);
        labelName.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelName);
        textFieldName = new JTextField();
        textFieldName.setBounds(271,151,150,20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("GENDER: ");
        labelGender.setBounds(35,191,200,14);
        labelGender.setForeground(Color.white);
        labelGender.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelGender);
        rMale = new JRadioButton("Male");
        rMale.setBounds(271,191,80,18);
        rMale.setFont(new Font("Tahoma",Font.BOLD,14));
        rMale.setForeground(Color.WHITE);
        rMale.setBackground(new Color(3,45,48));
        rMale.setFocusable(false);
        panel.add(rMale);
        rFemale = new JRadioButton("Female");
        rFemale.setBounds(350,191,80,18);
        rFemale.setFont(new Font("Tahoma",Font.BOLD,14));
        rFemale.setForeground(Color.WHITE);
        rFemale.setBackground(new Color(3,45,48));
        rFemale.setFocusable(false);
        panel.add(rFemale);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rFemale);
        buttonGroup.add(rMale);

        JLabel labelCountry = new JLabel("COUNTRY: ");
        labelCountry.setBounds(35,231,200,14);
        labelCountry.setForeground(Color.white);
        labelCountry.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelCountry);
        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(271,231,150,20);
        panel.add(textFieldCountry);

        JLabel labelRoom = new JLabel("ALLOCATED ROOM NUMBER: ");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setForeground(Color.white);
        labelRoom.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelRoom);
        choice = new Choice();
        try {
            v3_new_database db = new v3_new_database();
            String query = "SELECT * FROM room";
            PreparedStatement preparedStatement = db.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String roomNumber1 = resultSet.getString("roomNumber");
                String cleanStatus = resultSet.getString("cleaningStatus");
                String availability = resultSet.getString("availability");
                if(cleanStatus.equals("Cleaned") && availability.equals("Available")){
                    choice.add(roomNumber1);
                }else{
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        choice.setBounds(271,274,150,20);
        choice.setFont(new Font("Tahoma",Font.BOLD,14));
        choice.setForeground(Color.white);
        choice.setBackground(new Color(3,45,48));
        panel.add(choice);

        JLabel labelCheckIn = new JLabel("CHECKED-IN: ");
        labelCheckIn.setBounds(35,316,200,14);
        labelCheckIn.setForeground(Color.white);
        labelCheckIn.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelCheckIn);

        date = new JLabel();
        date.setBounds(271,316,200,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(date);

        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String MyDate = df.format(dt);
        date.setText(MyDate);

        time = new JLabel();
        time.setBounds(370,316,200,14);
        time.setForeground(Color.white);
        time.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(time);
        LocalDateTime dt1 = LocalDateTime.now();
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern(" h:m a (E)");
        String MyTime = df1.format(dt1);
        time.setText(MyTime);

        DateTime = MyDate+MyTime;

        JLabel labelDeposit = new JLabel("Deposit: ");
        labelDeposit.setBounds(35,359,200,14);
        labelDeposit.setForeground(Color.white);
        labelDeposit.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(labelDeposit);
        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,359,150,20);
        panel.add(textFieldDeposit);

        add = new JButton("Add");
        add.setBounds(100,430,120,30);
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setFocusable(false);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setFocusable(false);
        panel.add(back);
        this.setSize(850,550);
        this.setLayout(null);
        this.setLocation(500,150);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v15_newCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String document =  (String) comboBox.getSelectedItem();
            String number = textFieldNumber.getText();
            String name = textFieldName.getText();
            String gender = null;
            if(rFemale.isSelected()){
                gender = rFemale.getText();
            }else{
                gender = rMale.getText();
            }
            String country = textFieldCountry.getText();
            String room = choice.getSelectedItem();
            String checkInTime = DateTime;
            String Deposit = textFieldDeposit.getText();
            v3_new_database db1 = new v3_new_database();
            String query1 = "INSERT INTO customer(document,number,name,gender,country,room,checkintime,deposit) VALUES(?,?,?,?,?,?,?,?)";
            String query2 = "UPDATE room set availability = ? WHERE roomNumber = ?";
            try{
                PreparedStatement preparedStatement = db1.connection.prepareStatement(query1);
                preparedStatement.setString(1,document);
                preparedStatement.setString(2,number);
                preparedStatement.setString(3,name);
                preparedStatement.setString(4,gender);
                preparedStatement.setString(5,country);
                preparedStatement.setString(6,room);
                preparedStatement.setString(7,checkInTime);
                preparedStatement.setString(8,Deposit);
                PreparedStatement preparedStatement1 = db1.connection.prepareStatement(query2);
                preparedStatement1.setString(1,"Occupied");
                preparedStatement1.setString(2,room);
                int num = preparedStatement.executeUpdate();
                int num1 = preparedStatement1.executeUpdate();
                if(num>0){
                    JOptionPane.showMessageDialog(null,"Successfully Added","Success",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"DATA not added!!!!");
                }
                this.setVisible(false);
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }else{
            this.setVisible(false);
        }
    }
}
