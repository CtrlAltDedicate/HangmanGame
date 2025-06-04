import javax.swing.*;

public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton registerBtn = new JButton("Register");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerBtn);

        registerBtn.addActionListener(e -> {
            boolean success = UserStorage.register(usernameField.getText(), new String(passwordField.getPassword()));
            if (success) {
                JOptionPane.showMessageDialog(this, "Registered! Please login.");
                new LoginFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username taken.");
            }
        });

        add(panel);
        setVisible(true);
    }
}
