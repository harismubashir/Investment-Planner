import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {
    public void options() {

        JFrame menuform = new JFrame();// creating instance of JFrame

        JLabel list = new JLabel("List of Planning Options");

        JLabel buttonpress = new JLabel("No button pressed");

        JButton o1 = new JButton("Create Portfolio");// creating instance of JButton
        JButton o2 = new JButton("View Portfolio");
        JButton o3 = new JButton("Edit Portfolio");
        JButton o4 = new JButton("Review Performance");
        JButton o5 = new JButton("Close");

        list.setBounds(100, 20, 100, 40);

        o1.setBounds(75, 80, 200, 40);// x axis, y axis, width, height
        o2.setBounds(75, 140, 200, 40);
        o3.setBounds(75, 200, 200, 40);
        o4.setBounds(75, 260, 200, 40);
        o5.setBounds(110, 320, 100, 40);

        // adding labels and fields to form
        menuform.add(list);
        menuform.add(o1);
        menuform.add(o2);
        menuform.add(o3);
        menuform.add(o4);
        menuform.add(o5);

        menuform.setSize(800, 1000);// 400 width and 500 height
        menuform.setLayout(null);// using no layout managers
        menuform.setVisible(true);// making the frame visible

        // adding action listener to buttons

        o1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Create c = new Create();

                c.createplan();

            }

        });

        o2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                buttonpress.setText("o2 pressed");
            }

        });

        o3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                buttonpress.setText("o3 pressed");
            }

        });

        o4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                buttonpress.setText("o4 pressed");
            }

        }

        );

        o5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                menuform.setVisible(false);
            }

        });

    }

}