import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(registerBtn);

        loginBtn.addActionListener(e -> {
            User user = UserStorage.login(usernameField.getText(), new String(passwordField.getPassword()));
            if (user != null) {
                new GameFrame(user);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }
        });

        registerBtn.addActionListener(e -> {
            dispose();
            new RegisterFrame();
        });

        add(panel);
        setVisible(true);
    }
}
