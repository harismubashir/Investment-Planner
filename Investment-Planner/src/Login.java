import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Login {
    public void show() {

        JFrame f = new JFrame();// creating instance of JFrame

        JButton b = new JButton("click");// creating instance of JButton

        // creating labels for login
        JLabel nlabel = new JLabel("Name");
        JLabel plabel = new JLabel("Password");

        // initiating textfields for Java
        JTextField ntf = new JTextField("Name", 30);
        JTextField ptf = new JTextField("*******", 30);

        // setting bounds of all text fields and labels

        b.setBounds(75, 150, 100, 40);// x axis, y axis, width, height

        nlabel.setBounds(50, 25, 100, 40);
        ntf.setBounds(150, 25, 100, 40);
        plabel.setBounds(50, 75, 100, 40);
        ptf.setBounds(150, 75, 100, 40);

        // form label
        f.setName("Login");

        // adding labels and fields to form
        f.add(nlabel);
        f.add(ntf);
        f.add(plabel);
        f.add(ptf);

        f.add(b);// adding button in JFrame

        f.setSize(400, 500);// 400 width and 500 height
        f.setLayout(null);// using no layout managers
        f.setVisible(true);// making the frame visible

        // adding action listener to button

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                ntf.setText("button pressed");
                new Menu(ntf.getText());
            }

        }

        );

    }

}