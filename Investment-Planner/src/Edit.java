
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit {
    public void editplan() {

        JFrame editform = new JFrame();// creating instance of JFrame

        JLabel editlabel = new JLabel("Edit Plan");
        JLabel nplabel = new JLabel("Select name of plan");
        JLabel tflabel = new JLabel("Total funds lump sum");
        JLabel rclabel = new JLabel("Recurring contribution");
        JLabel rtlabel = new JLabel("Risk Tolerance");

        JTextField nptext = new JTextField("Name of plan", 30);
        JTextField tftext = new JTextField("$", 30);
        JTextField rctext = new JTextField("$", 30);
        JTextField rttext = new JTextField("5", 30);

        JButton sibutton = new JButton("Select Investment");// creating instance of JButton

        editlabel.setBounds(100, 20, 120, 40);

        nplabel.setBounds(75, 80, 200, 40);// x axis, y axis, width, height
        tflabel.setBounds(75, 140, 200, 40);
        rclabel.setBounds(75, 200, 200, 40);
        rtlabel.setBounds(75, 260, 200, 40);
        sibutton.setBounds(110, 320, 100, 40);

        nptext.setBounds(150, 80, 200, 40);// x axis, y axis, width, height
        tftext.setBounds(150, 140, 200, 40);
        rctext.setBounds(150, 200, 200, 40);
        rttext.setBounds(150, 260, 200, 40);

        // adding labels and fields to form
        editform.add(editlabel);
        editform.add(nplabel);
        editform.add(tflabel);
        editform.add(rclabel);
        editform.add(rttext);

        editform.add(sibutton);

        editform.add(nptext);
        editform.add(tftext);
        editform.add(rctext);
        editform.add(rttext);

        editform.setSize(800, 1000);// 400 width and 500 height
        editform.setLayout(null);// using no layout managers
        editform.setVisible(true);// making the frame visible

        // adding action listener to buttons

        sibutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                sibutton.setText("Button pressed");
            }

        });

    }

}