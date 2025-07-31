package electricity.billing.system;

import javax.swing.*;
import java.awt.event.*;

public class Payment_bill extends JFrame implements ActionListener {

    JButton back;
    String meter;

    Payment_bill(String meter){
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try{
            j.setPage("https://paytm.com/online-payments");
            j.setBounds(400,150,800,600);
        }catch (Exception E){
            E.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html>Errorr! Errorr!  Errorr!  Errorr!  Errorr!  Errorr! </html>");
        }

        JScrollPane pane = new JScrollPane(j);
        add(pane);

        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);


        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Pay_bill(meter);
    }

    public static void main(String[] args) {
        new Payment_bill("");
    }
}
