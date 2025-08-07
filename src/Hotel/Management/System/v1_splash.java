package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;

public class v1_splash extends JFrame{
    v1_splash(){
        JPanel panel = new JPanel();
        panel.setBounds(0,0,858,680);
        panel.setLayout(null);
        this.add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        Image image = imageIcon.getImage().getScaledInstance(858,680,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel();
        label.setBounds(0,0,858,680);
        label.setIcon(imageIcon1);
        panel.add(label);
        this.setSize(858,680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);
        try{
            Thread.sleep(5000);
            this.setVisible(false);
            v2_login v2_login = new v2_login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new v1_splash();
    }
}
