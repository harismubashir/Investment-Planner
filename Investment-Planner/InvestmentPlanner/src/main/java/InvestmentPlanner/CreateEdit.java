package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CreateEdit {
    public int arrayIndex;

    public void show(Mode mode, String planNo) {

        JFrame createForm = new JFrame();

        Plan newPlan;
        if (mode == Mode.CREATING) {
            arrayIndex = Database.plans.size() + 1;
            newPlan = new Plan();
        } else {
            arrayIndex = Integer.parseInt(planNo);
            newPlan = Database.plans.get(arrayIndex);
        }

        JLabel createLabel = new JLabel((mode == Mode.CREATING) ? "Create Plan" : "Edit Plan");

        JLabel namePlanLabel = new JLabel("Plan Number");
        JLabel totalFundsLabel = new JLabel("Total funds lump sum");
        JLabel recurringContributionLabel = new JLabel("Recurring contribution");
        JLabel riskToleranceLabel = new JLabel("Risk Tolerance");

        JTextField namePlanTextField = new JTextField(newPlan.name, 30);
        JTextField planNoTextField = new JTextField(String.valueOf(arrayIndex), 30);
        JTextField totalFundsTextField = new JTextField(newPlan.totalFunds.toString(), 30);
        JTextField recurringContributionTextFied = new JTextField(newPlan.recurringContribution.toString(), 30);
        JTextField riskToleranceTextField = new JTextField(Integer.toString(newPlan.riskTolerance), 30);

        JButton selectInvestmentButton = new JButton("Select Investment");
        JButton saveButton = new JButton("Save");

        JTextField planDetails = new JTextField();
        String planDetailsText = "";
        for (int i = 0; i < newPlan.stocks.size(); i++) {
            planDetailsText += newPlan.stocks.get(i).ticker + "\n";
        }
        planDetails.setText(planDetailsText);

        createLabel.setBounds(100, 20, 120, 40);

        namePlanLabel.setBounds(75, 80, 200, 40);
        totalFundsLabel.setBounds(75, 140, 200, 40);
        recurringContributionLabel.setBounds(75, 200, 200, 40);
        riskToleranceLabel.setBounds(75, 260, 200, 40);
        selectInvestmentButton.setBounds(110, 320, 100, 40);
        saveButton.setBounds(110, 400, 100, 40);

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
        createForm.add(saveButton);

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

                    pickInvestment.show(Mode.CREATING, newPlan);

                } else {
                    // JFrame pickInvestment = new JFrame();
                    // pickInvestment.show(Mode.EDITING);

                }
            }

        });

        // when the save button is clicked:
        // - save the changed text boxes to the plan
        // - add the plan to the db

        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                newPlan.planNo = String.valueOf(arrayIndex);
                newPlan.dateObj = new Date();
                newPlan.recurringContribution = Double.parseDouble(recurringContributionTextFied.getText());
                newPlan.riskTolerance = Integer.parseInt(riskToleranceTextField.getText());
                newPlan.totalFunds = Double.parseDouble(totalFundsTextField.getText());

                Database.plans.add(newPlan);

            }

        });

    }

}