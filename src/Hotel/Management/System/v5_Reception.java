package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class v5_Reception extends JFrame {
    v5_Reception(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(281,5,1248,850);
        panel.setBackground(new Color(3,45,48));
        this.add(panel);

//        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
//        Image scaleImage = imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
//        ImageIcon newImage = new ImageIcon(scaleImage);
//        JLabel label = new JLabel(newImage);
//        label.setBounds(300,20,800,800);
//        panel.add(label);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/extra.gif"));
        Image scaleImage2 = imageIcon2.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon newImage2 = new ImageIcon(scaleImage2);
        JLabel label2 = new JLabel(newImage2);
        label2.setBounds(450,150,500,450);
        panel.add(label2);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,850);
        panel1.setBackground(new Color(3,45,48));
        this.add(panel1);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image scaleImage3 = imageIcon3.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon newImage3 = new ImageIcon(scaleImage3);
        JLabel label3 = new JLabel(newImage3);
        label3.setBounds(5,600,250,250);
        panel1.add(label3);

        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.black);
        btnNCF.setForeground(Color.white);
        btnNCF.setFocusable(false);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v15_newCustomer();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.black);
        btnRoom.setForeground(Color.white);
        btnRoom.setFocusable(false);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v11_Room();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setBackground(Color.black);
        btnDepartment.setForeground(Color.white);
        btnDepartment.setFocusable(false);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v12_Department();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnAEI = new JButton("All Employee Information");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.black);
        btnAEI.setForeground(Color.white);
        btnAEI.setFocusable(false);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v13_Employee();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnCI = new JButton("Customer info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.black);
        btnCI.setForeground(Color.white);
        btnCI.setFocusable(false);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v17_customerInfo();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.black);
        btnMI.setForeground(Color.white);
        btnMI.setFocusable(false);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v14_Manager_Info();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(Color.black);
        btnCO.setForeground(Color.white);
        btnCO.setFocusable(false);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v21_CheckOut();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnUC = new JButton("Update check-in Details");
        btnUC.setBounds(30,310,200,30);
        btnUC.setBackground(Color.black);
        btnUC.setForeground(Color.white);
        btnUC.setFocusable(false);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v19_UpdateCheck();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setBackground(Color.black);
        btnURS.setForeground(Color.white);
        btnURS.setFocusable(false);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v20_updateRoom();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnPQS = new JButton("Pick up service");
        btnPQS.setBounds(30,390,200,30);
        btnPQS.setBackground(Color.black);
        btnPQS.setForeground(Color.white);
        btnPQS.setFocusable(false);
        panel1.add(btnPQS);
        btnPQS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v18_pickup();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.black);
        btnSR.setForeground(Color.white);
        btnSR.setFocusable(false);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new v16_SearchRoom();
                }catch(Exception e3){
                    System.out.println(e3.toString());
                }
            }
        });
        JButton logout = new JButton("Logout");
        logout.setBounds(30,470,95,30);
        logout.setFocusable(false);
        logout.setBackground(Color.black);
        logout.setForeground(Color.WHITE);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(140,470,95,30);
        back.setFocusable(false);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new v4_Dashboard();
            }
        });




        this.setSize(1950,1090);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new v5_Reception();
    }
}
