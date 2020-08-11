
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Performance {
    public void analysis() {

        JFrame performanceform = new JFrame();// creating instance of JFrame

        JLabel performancelabel = new JLabel("Investment Performance");
        JLabel drlabel = new JLabel("Dollar Return");
        JLabel prlabel = new JLabel("Percentage Return");
        JLabel mglabel = new JLabel("Monthly Growth");
        JLabel pclabel = new JLabel("Performance Chart");

        JTextField drtext = new JTextField("Name of plan", 30);
        JTextField prtext = new JTextField("$", 30);
        JTextField mgtext = new JTextField("$", 30);
        JTextField pctext = new JTextField("5", 30);

        JButton closebutton = new JButton("Close");// creating instance of JButton

        performancelabel.setBounds(100, 20, 120, 40);

        drlabel.setBounds(75, 80, 200, 40);// x axis, y axis, width, height
        prlabel.setBounds(75, 140, 200, 40);
        mglabel.setBounds(75, 200, 200, 40);
        pclabel.setBounds(75, 260, 200, 40);
        closebutton.setBounds(110, 320, 100, 40);

        drtext.setBounds(200, 80, 200, 40);// x axis, y axis, width, height
        prtext.setBounds(200, 140, 200, 40);
        mgtext.setBounds(200, 200, 200, 40);
        pctext.setBounds(200, 260, 200, 40);

        // adding labels and fields to form
        performanceform.add(performancelabel);
        performanceform.add(drlabel);
        performanceform.add(prlabel);
        performanceform.add(mglabel);
        performanceform.add(pctext);

        performanceform.add(closebutton);

        performanceform.add(drtext);
        performanceform.add(prtext);
        performanceform.add(mgtext);
        performanceform.add(pctext);

        performanceform.setSize(800, 1000);// 400 width and 500 height
        performanceform.setLayout(null);// using no layout managers
        performanceform.setVisible(true);// making the frame visible

        // adding action listener to buttons

        closebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                performanceform.setVisible(false);
            }

        });

    }

}

}