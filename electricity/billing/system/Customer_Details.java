package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;


public class Customer_Details extends JFrame implements ActionListener{

    Choice searchMeterCho, searchNameCho;
    JTable table;
    JButton search, print, close;
    Customer_Details(){

        super("Customer Details");

        getContentPane().setBackground(new Color(138, 235, 185));
        setSize(700,500);
        setLocation(350,120);
        setLayout(null);


        JLabel searchMeter = new JLabel("Search by Meater Number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);


        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            while(resultSet.next()){
            searchMeterCho.add(resultSet.getString("meter_no"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }


        JLabel searchName = new JLabel("Search by Name");
        searchName.setBounds(400,20,100,20);
        add(searchName);
        searchNameCho = new Choice();
        searchNameCho.setBounds(520,20,150,20);
        add(searchNameCho);


        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery(("select * from new_customer"));
            while(resultSet.next()){
                searchNameCho.add(resultSet.getString("name"));
            }

        }catch(Exception E){
            E.printStackTrace();
        }


        table = new JTable();

        try{
            Database c = new Database();
            ResultSet resultSet = c.statement.executeQuery("select * from new_customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        
        }catch(Exception E){
            E.printStackTrace();
        }


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);


        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);


        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);


        close = new JButton("Close");
        close.setBounds(600,70,80,20);
        close.addActionListener(this);
        add(close);


        setLocationRelativeTo(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == search){
        String query_search = "select * from new_customer where meter_no = '"+searchMeterCho.getSelectedItem()+"' and name = '"+searchNameCho.getSelectedItem()+"'" ;
        try{
            Database c= new Database();
            ResultSet resultSet = c.statement.executeQuery(query_search);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception E){
            E.printStackTrace();
        }
    }else if(e.getSource() == print){
        try{
            table.print();
        }catch(Exception E){
            E.printStackTrace();
        }
    }else{
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new Customer_Details();
    }    
}
