import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Login {
    public void show() {

        JFrame loginForm = new JFrame();
        JButton loginButton = new JButton("Login");
        JLabel nameLabel = new JLabel("Name");
        JLabel passwordLabel = new JLabel("Password");
        JTextField nameTextField = new JTextField("Name", 30);
        JTextField passwordTextField = new JTextField("*******", 30);

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
        loginForm.setLayout(null);
        loginForm.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Menu(nameTextField.getText());
            }

        }

        );

    }

}