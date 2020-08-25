
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Create {
    // Hash Map

    public void createplan(Mode mode) {

        JFrame createForm = new JFrame();// creating instance of JFrame

        JLabel createLabel = new JLabel((mode == Mode.CREATING) ? "Create Plan" : "Edit Plan");

        JLabel namePlanLabel = new JLabel("Name of plan");
        JLabel totalFundsLabel = new JLabel("Total funds lump sum");
        JLabel recurringContributionLabel = new JLabel("Recurring contribution");
        JLabel riskToleranceLabel = new JLabel("Risk Tolerance");

        JTextField namePlanTextField = new JTextField("Name of plan", 30);
        JTextField totalFundsTextField = new JTextField("$", 30);
        JTextField recurringContributionTextFied = new JTextField("$", 30);
        JTextField riskToleranceTextField = new JTextField("5", 30);

        JButton selectInvestmentButton = new JButton("Select Investment");// creating instance of JButton

        createLabel.setBounds(100, 20, 120, 40);

        namePlanLabel.setBounds(75, 80, 200, 40);// x axis, y axis, width, height
        totalFundsLabel.setBounds(75, 140, 200, 40);
        recurringContributionLabel.setBounds(75, 200, 200, 40);
        riskToleranceLabel.setBounds(75, 260, 200, 40);
        selectInvestmentButton.setBounds(110, 320, 100, 40);

        namePlanTextField.setBounds(150, 80, 200, 40);// x axis, y axis, width, height
        totalFundsTextField.setBounds(150, 140, 200, 40);
        recurringContributionTextFied.setBounds(150, 200, 200, 40);
        riskToleranceTextField.setBounds(150, 260, 200, 40);

        // adding labels and fields to form
        createForm.add(createLabel);
        createForm.add(namePlanLabel);
        createForm.add(totalFundsLabel);
        createForm.add(recurringContributionLabel);
        createForm.add(riskToleranceLabel);

        createForm.add(selectInvestmentButton);

        createForm.add(namePlanTextField);
        createForm.add(totalFundsTextField);
        createForm.add(recurringContributionTextFied);
        createForm.add(riskToleranceTextField);

        createForm.setSize(800, 1000);// 400 width and 500 height
        createForm.setLayout(null);// using no layout managers
        createForm.setVisible(true);// making the frame visible

        // adding action listener to buttons

        selectInvestmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // system.out.print("button pressed");
                selectInvestmentButton.setText("SI pressed");

                if (mode == Mode.CREATING) {

                } else {

                }
            }

        });

    }

}