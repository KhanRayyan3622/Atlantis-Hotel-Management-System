package AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class PalmReceptionLogin extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JCheckBox showPasswordCheckBox;
    JButton loginButton,cancelButton;
    PalmReceptionLogin(){
        setSize(1280, 680);//Frame Size
        setLocation(0,5);//Frame Location
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);//Frame Layout
        setTitle("The Palm Login");

        ImageIcon palmLogin = new ImageIcon(ClassLoader.getSystemResource("icons/PalmLoginReception.png"));
        JLabel image1 = new JLabel(palmLogin);
        image1.setBounds(0,0,1280,680);
        add(image1);

        username = new JTextField();
        username.setBounds(845,335,370,37);
        image1.add(username);
        password = new JPasswordField();
        password.setBounds(845,436,370,37);
        image1.add(password);

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(845,477,150,20);
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.addActionListener(this);
        image1.add(showPasswordCheckBox);

        loginButton = new JButton("Log-in");
        loginButton.setBounds(845,511,370,38);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        image1.add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(845,560,370,38);
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        image1.add(cancelButton);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == loginButton) {
            //File logindata = new File("logindata.txt");
            try {
                String user = username.getText();
                String pass = password.getText();

                String enteredid = "reception";
                String enteredcode = "123";
                if ((user.equals(enteredid)) && (pass.equals(enteredcode))) {
                    System.out.println("True");
                    PalmReceptionLogin.this.setVisible(false);
                    Reception newGUIClass = new Reception();
                    newGUIClass.setVisible(true);
                } else if (!(user.equals("reception"))) {
                    JOptionPane.showMessageDialog(this, "Login Failed. Please try again.");
                } else if (!(pass.equals("123"))) {
                    JOptionPane.showMessageDialog(this, "Login Failed. Please try again.");
                }
            } catch (Exception ae) {
                System.out.println("Enter Correct Data" );
                ae.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
            new ThePalm();
        } else if (e.getSource() == showPasswordCheckBox){
            JCheckBox cb = (JCheckBox) e.getSource();
            if (cb.isSelected()) {
                password.setEchoChar((char) 0); // Show password characters
            } else {
                password.setEchoChar('\u2022'); // Hide password characters
            }
        }
    }
    public static void main(String[] args) {
        new PalmAdminLogin();
    }
}
