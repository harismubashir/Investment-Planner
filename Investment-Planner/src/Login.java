import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login {

    public void show() throws Exception {

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
                String name = nameTextField.getText();
                String password = passwordTextField.getText();
                String actualUsername = "";
                String actualPassword = "";
                int lineCount = 0;
                String filePath = "C:\\Users\\Haris\\Desktop\\test.txt";
                BufferedReader br;
                String fileReadData;

                try {
                    br = new BufferedReader(new FileReader(new File(filePath)));
                    while ((fileReadData = br.readLine()) != null) {
                        System.out.println(fileReadData);

                        if (lineCount == 0) {
                            actualUsername = fileReadData;
                            System.out.println(actualUsername);
                        } else {
                            actualPassword = fileReadData;
                            System.out.println(actualPassword);
                        }

                        // TODO: store the first line into actualUsername, store the second line in
                        // actualPassword
                    }
                } catch (FileNotFoundException e1) {
                    showMessageDialog(null, "File " + filePath + " not found. Program will be closed");

                    // TODO: tell the user the file was not found and terminate the program
                } catch (IOException e1) {
                    showMessageDialog(null, "File " + filePath + " could not be read");
                    // TODO: something went wrong
                }

                if (name.equals(actualUsername) && password.equals(actualPassword)) {

                    new Menu(nameTextField.getText());
                } else {

                    showMessageDialog(null, "Password or username do not match");
                    // TODO: show alert
                }

            }

        }

        );

        Exception newException = new Exception();
        throw newException;
    }

}