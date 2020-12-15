package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.google.gson.JsonElement;

import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import static javax.swing.JOptionPane.showMessageDialog;

public class CreateEdit {
    public int arrayIndex;

    public void show(Mode mode, Plan plan) throws Exception {

        JFrame createForm = new JFrame();

        Plan newPlan;
        if (mode == Mode.CREATING) {
            arrayIndex = Database.plans.size() + 1;
            newPlan = new Plan();

        } else {
            newPlan = plan;
            arrayIndex = Integer.valueOf(newPlan.index);
        }

        JLabel createLabel = new JLabel((mode == Mode.CREATING) ? "Create Plan" : "Edit Plan");

        JLabel namePlanLabel = new JLabel("Plan Number");
        JLabel totalFundsLabel = new JLabel("Total funds lump sum");
        JLabel recurringContributionLabel = new JLabel("Recurring contribution");
        JLabel riskToleranceLabel = new JLabel("Risk Tolerance");

        JLabel namePlanLabelDetails = new JLabel("for " + newPlan.name);
        JTextField planNoTextField = new JTextField(newPlan.planNo, 30);
        JTextField totalFundsTextField = new JTextField(newPlan.totalFunds.toString(), 30);
        JTextField recurringContributionTextFied = new JTextField(newPlan.recurringContribution.toString(), 30);
        JTextField riskToleranceTextField = new JTextField(Integer.toString(newPlan.riskTolerance), 30);

        JButton selectInvestmentButton = new JButton("Select Investment");
        JButton saveButton = new JButton("Save");

        JTextField planDetails = new JTextField();
        String planDetailsText = "";
        for (int i = 0; i < newPlan.stocks.size(); i++) {
            planDetailsText += newPlan.stocks.get(i).ticker + "\n";
            planDetails.setText(planDetailsText);
        }

        createLabel.setBounds(100, 20, 120, 40);

        namePlanLabel.setBounds(75, 80, 200, 40);
        totalFundsLabel.setBounds(75, 140, 200, 40);
        recurringContributionLabel.setBounds(75, 200, 200, 40);
        riskToleranceLabel.setBounds(75, 260, 200, 40);
        selectInvestmentButton.setBounds(110, 320, 100, 40);
        saveButton.setBounds(110, 400, 100, 40);

        planNoTextField.setBounds(275, 80, 200, 40);
        namePlanLabelDetails.setBounds(170, 20, 200, 40);
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

        createForm.add(namePlanLabelDetails);
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
                    pickInvestment.show(Mode.EDITING, newPlan);

                }
            }

        });

        // when the save button is clicked:
        // - save the changed text boxes to the plan
        // - add the plan to the db

        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                newPlan.planNo = planNoTextField.getText();
                newPlan.index = String.valueOf(arrayIndex);
                newPlan.dateObj = new Date();
                newPlan.recurringContribution = Double.parseDouble(recurringContributionTextFied.getText());
                newPlan.riskTolerance = Integer.parseInt(riskToleranceTextField.getText());
                newPlan.totalFunds = Double.parseDouble(totalFundsTextField.getText());
                saveHistoricalStockData(newPlan);

                System.out.println("Historical Data Updated");
                showMessageDialog(null, "Plan saved successfully.");
                Database.plans.add(newPlan);

            }

        });

    }

    public void saveHistoricalStockData(Plan plan) {

        String stock;

        try {
            for (int i = 0; i < plan.stocks.size(); i++) {
                stock = plan.stocks.get(i).stockName;

                final String stockHistoricalPrice = "https://www.alphavantage.co/query?function=TIME_SERIES_MONTHLY&symbol="
                        + stock + "&apikey=XIME2HD6DHN7WPYZ";

                final HttpResponse<String> httpResponseHistorical = Unirest.get(stockHistoricalPrice).asString();
                if (httpResponseHistorical.getBody().contains("Thank you for using Alpha Vantage!")) {
                    try {
                        showMessageDialog(null, "Please wait 1 minute while plan updates");
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        showMessageDialog(null, "Press save again");
                    }

                }

                JsonElement e3 = JsonParser.parseString(httpResponseHistorical.getBody());
                plan.stocks.get(i).priceOneMonthAgo = e3.getAsJsonObject().get("Monthly Time Series").getAsJsonObject()
                        .get("2020-11-30").getAsJsonObject().get("4. close").getAsDouble();

                plan.stocks.get(i).priceTwoMonthsAgo = e3.getAsJsonObject().get("Monthly Time Series").getAsJsonObject()
                        .get("2020-10-30").getAsJsonObject().get("4. close").getAsDouble();

            }
        } catch (Exception e) {
            showMessageDialog(null, "Request limit exceeded");

        }

    }

}