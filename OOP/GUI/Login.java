import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    String Username = "davin";
    String Password = "PBOkeren";
    String msg = " ";
    
    JFrame frame;
    JTextField txtUsername;
    JPasswordField txtPassword;

    public static void main(String[] args) {
        Login gui = new Login();
        gui.go();
    }

    public void go() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        
        txtPassword.addActionListener(new LoginListener());

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());
        
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String password = new String(txtPassword.getPassword());
            if (Username.equals(txtUsername.getText()) && Password.equals(password)) {
                msg = "Login Granted!";
                JOptionPane.showMessageDialog(null, msg);
                frame.dispose(); 
                new ImageViewer(); 
            } else {
                msg = "Login Denied";
                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }

    public class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}
