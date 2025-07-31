package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener {
    String acctype;
    String meter_pass;

    Main_Class(String acctype, String meter_pass) {
        this.meter_pass = meter_pass;
        this.acctype = acctype;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/ebs.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530, 820, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0 + 3, 0, 1530, 820);
        add(imageLabel);

       String[][] adminMenuItems = {
                { "New Customer", "icon/newcustomer.png" },
                { "Customer Details", "icon/customerDetails.png" },
                { "Deposit Details", "icon/depositdetails.png" },
                { "Calculate Bill", "icon/calculatorbills.png" },
                { "Calculator", "icon/calculator.png" },
                { "Exit", "icon/exit.png" }
        };

        String[][] customerMenuItems = {
                { "Pay Bill", "icon/pay.png" },
                { "Bill Details", "icon/detail.png" },
                { "View Info", "icon/information.png" },
                { "Update Info", "icon/refresh.png" },
                { "Generate Bill", "icon/bill.png" },
                { "Notepad", "icon/notepad.png" },
                { "Calculator", "icon/calculator.png" },
                { "Exit", "icon/exit.png" }
        };

        String[][] menuItems = acctype.equals("Admin") ? adminMenuItems : customerMenuItems;

        int y = 100; 
        int width = 200;
        int height = 40;
        int gap = 20;
        int columns = 3; 
        int count = 0;

        int x;

        if (acctype.equals("Admin")) {
            menuItems = adminMenuItems;
            x = 240; 
        } else {
            menuItems = customerMenuItems;
            x = 130;  
        }

        for (String[] item : menuItems) {
            JButton button = createButton(item[0], item[1], x, y, width, height);
            imageLabel.add(button);
            count++;

            if (count % columns == 0) {  
                y += height + gap;
            } else { 
                x += width + gap;
            }
        }


        setLocationRelativeTo(null);        
        setVisible(true);
    }

    private JButton createButton(String text, String iconPath, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 14));
        button.setBounds(x, y, width, height);
        button.setFocusPainted(false);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(iconPath));
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));

        button.addActionListener(this);
        return button;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        switch (msg) {
            case "New Customer" -> new New_Customer();
            case "Customer Details" -> new Customer_Details();  
            case "Deposit Details" -> new Deposite_Details();


            case "Calculate Bill" -> new Calculate_bill();
            case "Pay Bill" -> new Pay_bill(meter_pass);
            case "Bill Details" -> new Bill_Details(meter_pass);
            case "View Info" -> new View_Information(meter_pass);
            case "Update Info" -> new Update_information(meter_pass);
            case "Generate Bill" -> new Generate_bill(meter_pass);
            case "Calculator" -> {
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            case "Notepad" -> {
                try {
                    Runtime.getRuntime().exec("notepad.exe");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            case "Exit" -> {
                setVisible(false);
                new Login();
            }
        }
    }

    public static void main(String[] args) {
        new Main_Class("Admin", "");  
    }
}