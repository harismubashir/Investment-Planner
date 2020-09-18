package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login {

    public void show() {

        JFrame loginForm = new JFrame();
        JButton loginButton = new JButton("Login");
        JLabel nameLabel = new JLabel("Name");
        JLabel passwordLabel = new JLabel("Password");

        JTextField nameTextField = new JTextField("Name", 30);
        JPasswordField passwordTextField = new JPasswordField("*******", 30);

        loginButton.setBounds(75, 150, 100, 40);
        nameLabel.setBounds(50, 25, 100, 40);
        nameTextField.setBounds(150, 25, 100, 40);
        passwordLabel.setBounds(50, 75, 100, 40);
        passwordTextField.setBounds(150, 75, 100, 40);

        loginForm.setName("Login");

        loginForm.add(nameLabel);
        loginForm.add(nameTextField);
        loginForm.add(passwordLabel);
        loginForm.add(passwordTextField);

        loginForm.add(loginButton);

        loginForm.setSize(400, 500);
        loginForm.setTitle("Login to Investment Planner");
        loginForm.setLayout(null);
        loginForm.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String password = passwordTextField.getText();
                String inputData[] = { name, password };
                FileReadWrite read = new FileReadWrite();

                Boolean loginMatch = read.readWrite(Mode.READ, inputData);

                // String actualUsername = actualData[0];
                // String actualPassword = actualData[1];

                if (loginMatch == true) {

                    new Menu(nameTextField.getText());
                } else {

                    showMessageDialog(null, "Password or username do not match");
                }

            }

        }

        );
    }

}