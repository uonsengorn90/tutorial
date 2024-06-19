import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {
    private JTextField passcodeField;
    private JButton enterButton;
    private JLabel statusLabel;

    private String storedPassword;
    private boolean passwordSet = false;

    public LockerApplication() {
        setTitle("Locker Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Components
        passcodeField = new JTextField(15);
        enterButton = new JButton("Enter");
        statusLabel = new JLabel("Enter your passcode to set password.");

        // Layout
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(passcodeField);
        inputPanel.add(enterButton);

        add(inputPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        // Event handling
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!passwordSet) {
                    // Setting the password for the first time
                    storedPassword = passcodeField.getText();
                    passwordSet = true;
                    statusLabel.setText("Password Set");
                    passcodeField.setText("");
                } else {
                    // Verifying the password
                    String enteredPassword = passcodeField.getText();
                    if (enteredPassword.equals(storedPassword)) {
                        JOptionPane.showMessageDialog(LockerApplication.this,
                                "Correct Password", "Access Granted", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(LockerApplication.this,
                                "Incorrect Password", "Access Denied", JOptionPane.ERROR_MESSAGE);
                    }
                    passcodeField.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LockerApplication lockerApp = new LockerApplication();
                lockerApp.setVisible(true);
            }
        });
    }
}