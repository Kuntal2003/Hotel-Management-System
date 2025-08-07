package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class v4_Dashboard extends JFrame implements ActionListener {
    JButton admin,other;
    v4_Dashboard(){
        super("Hotel Management System");



        other = new JButton("RECEPTION");
        other.setBounds(425,510,140,30);
        other.setFont(new Font("Tahoma",Font.BOLD,15));
        other.setBackground(new Color(255,98,0));
        other.setForeground(Color.WHITE);
        other.setFocusable(false);
        other.addActionListener(this);
        this.add(other);

        admin = new JButton("ADMIN");
        admin.setBounds(880,510,140,30);
        admin.setFont(new Font("Tahoma",Font.BOLD,15));
        admin.setBackground(new Color(255,98,0));
        admin.setForeground(Color.WHITE);
        admin.setFocusable(false);
        admin.addActionListener(this);
        this.add(admin);

        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("./icon/Reception.png"));
        Image scaleImage2 = img2.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon newImg2 = new ImageIcon(scaleImage2);
        JLabel label2 = new JLabel(newImg2);
        label2.setBounds(400,300,200,195);
        this.add(label2);
        ImageIcon img3 = new ImageIcon(ClassLoader.getSystemResource("./icon/boss.png"));
        Image scaleImage3 = img3.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon newImg3 = new ImageIcon(scaleImage3);
        JLabel label3 = new JLabel(newImg3);
        label3.setBounds(850,300,200,195);
        this.add(label3);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icon/Dashboard.gif"));
        Image i1 = img.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i1);
        JLabel label = new JLabel();
        label.setBounds(0,0,1950,1090);
        label.setIcon(img1);


        this.add(label);
        this.setSize(1950,1090);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new v4_Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == other){
            new v5_Reception();
            this.setVisible(false);
        }else{
            new v10_login2();
            setVisible(false);
        }
    }
}
