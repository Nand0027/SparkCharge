package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField userText;
    JPasswordField passwordText;
    JCheckBox showPasswordCheckbox;
    Choice loginChoice;
    JButton loginButton, cancelButton, signupButton;

    Login() {
        super("Login Page");

        getContentPane().setBackground(new Color(240, 242, 82));

        // Get screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.7);
        int height = (int) (screenSize.height * 0.7);
        setSize(width, height);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel username = new JLabel("UserName");
        username.setBounds(300, 60, 100, 20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400, 60, 150, 20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300, 100, 100, 20);
        add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(400, 100, 150, 20);
        passwordText.setEchoChar('*');
        add(passwordText);

        // ✅ Show Password Checkbox
        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setBounds(400, 125, 150, 20);
        showPasswordCheckbox.setBackground(new Color(240, 242, 82));
        add(showPasswordCheckbox);

        showPasswordCheckbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (showPasswordCheckbox.isSelected()) {
                    passwordText.setEchoChar((char) 0); // show password
                } else {
                    passwordText.setEchoChar('*'); // hide password
                }
            }
        });

        JLabel loggin = new JLabel("Loggin In As");
        loggin.setBounds(300, 160, 100, 20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400, 160, 150, 20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(330, 200, 100, 20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460, 200, 100, 20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(400, 235, 100, 20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne = new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTwo = profileOne.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTwo);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(10, 10, 250, 250);
        add(profileLabel);

        setSize(640, 330);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String susername = userText.getText();
            String spassword = new String(passwordText.getPassword());
            String suser = loginChoice.getSelectedItem();

            try {
                Database d = new Database();
                String queryy = "select * from SignUp where username = '" + susername + "' and password = '" + spassword + "' and usertype ='" + suser + "'";
                ResultSet resultSet = d.statement.executeQuery(queryy);

                if (resultSet.next()) {
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new Main_Class(suser, meter);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        } else if (e.getSource() == signupButton) {
            setVisible(false);
            new SignUp();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
