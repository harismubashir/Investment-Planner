package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateEdit {
    public int reference;

    public void show(Mode mode, String planNo) {

        JFrame createForm = new JFrame();

        if (mode == Mode.CREATING) {
            reference = Database.plans.size() + 1;

        } else {
            reference = Integer.parseInt(planNo);
        }

        JLabel createLabel = new JLabel((mode == Mode.CREATING) ? "Create Plan" : "Edit Plan");

        // Plan plan1[] = new Plan[reference];

        Plan plan2 = new Plan();

        // Database.plans.add(plan2);

        JLabel namePlanLabel = new JLabel("Plan Number");
        JLabel totalFundsLabel = new JLabel("Total funds lump sum");
        JLabel recurringContributionLabel = new JLabel("Recurring contribution");
        JLabel riskToleranceLabel = new JLabel("Risk Tolerance");

        JTextField namePlanTextField = new JTextField(plan2.name, 30);
        JTextField planNoTextField = new JTextField("Enter plan number", 30);
        JTextField totalFundsTextField = new JTextField(plan2.totalFunds.toString(), 30);
        JTextField recurringContributionTextFied = new JTextField(plan2.recurringContribution.toString(), 30);
        JTextField riskToleranceTextField = new JTextField(Integer.toString(plan2.riskTolerance), 30);

        JButton selectInvestmentButton = new JButton("Select Investment");

        createLabel.setBounds(100, 20, 120, 40);

        namePlanLabel.setBounds(75, 80, 200, 40);
        totalFundsLabel.setBounds(75, 140, 200, 40);
        recurringContributionLabel.setBounds(75, 200, 200, 40);
        riskToleranceLabel.setBounds(75, 260, 200, 40);
        selectInvestmentButton.setBounds(110, 320, 100, 40);

        planNoTextField.setBounds(275, 80, 200, 40);
        namePlanTextField.disable();
        namePlanTextField.setBounds(170, 10, 200, 40);
        totalFundsTextField.setBounds(275, 140, 200, 40);
        recurringContributionTextFied.setBounds(275, 200, 200, 40);
        riskToleranceTextField.setBounds(275, 260, 200, 40);

        createForm.add(createLabel);
        createForm.add(namePlanLabel);
        createForm.add(totalFundsLabel);
        createForm.add(recurringContributionLabel);
        createForm.add(riskToleranceLabel);

        createForm.add(selectInvestmentButton);

        createForm.add(namePlanTextField);
        createForm.add(planNoTextField);
        createForm.add(totalFundsTextField);
        createForm.add(recurringContributionTextFied);
        createForm.add(riskToleranceTextField);

        createForm.setSize(800, 1000);
        createForm.setLayout(null);
        createForm.setVisible(true);

        selectInvestmentButton.addActionListener(new ActionListener() {

            public Ticker pickInvestment = new Ticker();

            public void actionPerformed(ActionEvent e) {

                if (mode == Mode.CREATING) {

                    pickInvestment.show(Mode.CREATING, plan2);

                } else {
                    // JFrame pickInvestment = new JFrame();
                    // pickInvestment.show(Mode.EDITING);

                }
            }

        });

    }

}