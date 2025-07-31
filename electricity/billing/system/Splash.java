package electricity.billing.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame{            

    Splash(){

        super("Spark Charge");  
        
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Splash.gif"));
        Image imageOne = imageIcon.getImage().getScaledInstance(700,465 ,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLable = new JLabel(imageIcon2);
        add(imageLable);

        setSize(700,500);
        setLocationRelativeTo(null);      //JFrame in center
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);

            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }     
    public static void main(String[] args){
        new Splash();                           

    }
}
