package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class v8_addEmployee extends JFrame implements ActionListener {
    JTextField nameTxt , ageTxt,salaryTxt,phoneTxt,aadharTxt,emailTxt;
    JRadioButton maleR,femaleR;
    JComboBox jobBox;
    JButton add,back;
    ButtonGroup group;
    v8_addEmployee(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        this.add(panel);

        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.white);
        panel.add(name);
        nameTxt = new JTextField();
        nameTxt.setBounds(200,30,150,27);
        nameTxt.setBackground(new Color(16,108,115));
        nameTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        nameTxt.setForeground(Color.white);
        panel.add(nameTxt);

        JLabel age = new JLabel("AGE");
        age.setBounds(60,80,150,27);
        age.setFont(new Font("serif",Font.BOLD,17));
        age.setForeground(Color.white);
        panel.add(age);
        ageTxt = new JTextField();
        ageTxt.setBounds(200,80,150,27);
        ageTxt.setBackground(new Color(16,108,115));
        ageTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        ageTxt.setForeground(Color.white);
        panel.add(ageTxt);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("serif",Font.BOLD,17));
        gender.setForeground(Color.white);
        panel.add(gender);
        maleR = new JRadioButton("MALE");
        maleR.setBounds(200,120,70,27);
        maleR.setBackground(new Color(3,45,48));
        maleR.setFont(new Font("Tahoma",Font.BOLD,14));
        maleR.setFocusable(false);
        maleR.setForeground(Color.white);
        panel.add(maleR);
        femaleR = new JRadioButton("FEMALE");
        femaleR.setBounds(280,120,100,27);
        femaleR.setBackground(new Color(3,45,48));
        femaleR.setFont(new Font("Tahoma",Font.BOLD,14));
        femaleR.setForeground(Color.white);
        femaleR.setFocusable(false);
        panel.add(femaleR);
        group = new ButtonGroup();
        group.add(maleR);
        group.add(femaleR);

        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.white);
        panel.add(job);
        String[] arr = {"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Accountant","chief"};
        jobBox = new JComboBox(arr);
        jobBox.setBackground(new Color(16,108,115));
        jobBox.setBounds(200,170,150,30);
        jobBox.setFont(new Font("Tahoma",Font.BOLD,14));
        jobBox.setForeground(Color.WHITE);
        panel.add(jobBox);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("serif",Font.BOLD,17));
        salary.setForeground(Color.white);
        panel.add(salary);
        salaryTxt = new JTextField();
        salaryTxt.setBounds(200,220,150,27);
        salaryTxt.setBackground(new Color(16,108,115));
        salaryTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        salaryTxt.setForeground(Color.white);
        panel.add(salaryTxt);

        JLabel phone = new JLabel("PHONE NO");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("serif",Font.BOLD,17));
        phone.setForeground(Color.white);
        panel.add(phone);
        phoneTxt = new JTextField();
        phoneTxt.setBounds(200,270,150,27);
        phoneTxt.setBackground(new Color(16,108,115));
        phoneTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneTxt.setForeground(Color.white);
        panel.add(phoneTxt);

        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,320,150,27);
        aadhar.setFont(new Font("serif",Font.BOLD,17));
        aadhar.setForeground(Color.white);
        panel.add(aadhar);
        aadharTxt = new JTextField();
        aadharTxt.setBounds(200,320,150,27);
        aadharTxt.setBackground(new Color(16,108,115));
        aadharTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        aadharTxt.setForeground(Color.white);
        panel.add(aadharTxt);

        JLabel email = new JLabel("Email");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("serif",Font.BOLD,17));
        email.setForeground(Color.white);
        panel.add(email);
        emailTxt = new JTextField();
        emailTxt.setBounds(200,370,150,27);
        emailTxt.setBackground(new Color(16,108,115));
        emailTxt.setFont(new Font("Tahoma",Font.BOLD,14));
        emailTxt.setForeground(Color.white);
        panel.add(emailTxt);

        JLabel aed = new JLabel("Add Employee Detail");
        aed.setBounds(450,24,445,35 );
        aed.setFont(new Font("Tahoma",Font.BOLD,31));
        aed.setForeground(Color.white);
        panel.add(aed);

        add = new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setFocusable(false);
        add.addActionListener(this);
        panel.add(add);
        back = new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFocusable(false);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon newimg = new ImageIcon(image);
        JLabel label = new JLabel(newimg);
        label.setBounds(500,100,300,300);
        panel.add(label);
        this.setSize(900,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLocation(60,160);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new v8_addEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            String name = nameTxt.getText();
            String age = ageTxt.getText();
            String gender = null;
            if(maleR.isSelected()){
                gender = "MAlE";
            }else{
                gender = "FEMALE";
            }
            String job = (String) jobBox.getSelectedItem();
            String salary = salaryTxt.getText();
            String phone = phoneTxt.getText();
            String email = emailTxt.getText();
            String aadhar = aadharTxt.getText();
            v3_new_database db = new v3_new_database();
            String query = "INSERT INTO employee (name,age,gender,job,salary,phone,email,aadhar) VALUES(?,?,?,?,?,?,?,?)";
            try{
                PreparedStatement preparedStatement = db.connection.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,age);
                preparedStatement.setString(3,gender);
                preparedStatement.setString(4,job);
                preparedStatement.setString(5,salary);
                preparedStatement.setString(6,phone);
                preparedStatement.setString(7,email);
                preparedStatement.setString(8,aadhar);
                int num = preparedStatement.executeUpdate();
                if(num > 0){
                    JOptionPane.showMessageDialog(null,"Inserted Successfully","Successful",JOptionPane.PLAIN_MESSAGE);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }catch(Exception e1){
                System.out.println(e1.toString());
            }

        }else{
            this.setVisible(false);
        }

    }
}
