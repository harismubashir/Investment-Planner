package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.showMessageDialog;

//import org.jfree.chart;

public class Performance {
    public void show(Plan plan) {

        JFrame performanceForm = new JFrame();

        JLabel performanceLabel = new JLabel("Investment Performance");
        JLabel selectPlanLabel = new JLabel("Dollar Return");
        JLabel percentageReturnLabel = new JLabel("Percentage Return");
        JLabel monthlyGrowthLabel = new JLabel("Monthly Growth");
        // JFreeChart chart = new JFreeChart;
        // chart.createXYLineChart("Test Chart",
        // "x", "y", ds, PlotOrientation.VERTICAL, true, true,
        // false);

        JTextField dollarReturnTextField = new JTextField("Name of plan", 30);
        JTextField percentageReturnTextField = new JTextField("$", 30);
        JTextField monthlyGrowthTextField = new JTextField("$", 30);
        JTextField percentageReturnTextfield = new JTextField("...---~|```", 30);

        JComboBox<String> selectPlanComboBox = new JComboBox<String>();

        JButton selectPlanButton = new JButton("Select Plan");
        JButton closebutton = new JButton("Close");

        performanceLabel.setBounds(100, 20, 120, 40);

        selectPlanLabel.setBounds(75, 60, 200, 40);
        percentageReturnLabel.setBounds(75, 140, 200, 40);
        monthlyGrowthLabel.setBounds(75, 200, 200, 40);
        // chart.setBounds(125, 260, 200, 40);
        selectPlanButton.setBounds(450, 80, 100, 40);
        closebutton.setBounds(110, 520, 100, 40);

        selectPlanComboBox.setBounds(200, 60, 200, 40);
        percentageReturnTextField.setBounds(200, 140, 200, 40);
        monthlyGrowthTextField.setBounds(200, 200, 200, 40);
        percentageReturnTextfield.setBounds(100, 300, 200, 200);

        performanceForm.add(performanceLabel);
        performanceForm.add(selectPlanLabel);
        performanceForm.add(percentageReturnLabel);
        performanceForm.add(monthlyGrowthLabel);
        // performanceForm.add(chart);

        performanceForm.add(closebutton);
        performanceForm.add(selectPlanButton);

        Plan performancePlan = new Plan();

        for (int i = 0; i <= performancePlan.stocks.size(); i++) {
            selectPlanComboBox.addItem(String.valueOf(i));
        }
        ;

        performanceForm.add(selectPlanComboBox);

        performanceForm.add(dollarReturnTextField);
        performanceForm.add(percentageReturnTextField);
        performanceForm.add(monthlyGrowthTextField);
        performanceForm.add(percentageReturnTextfield);

        performanceForm.setSize(800, 1000);
        performanceForm.setLayout(null);
        performanceForm.setVisible(true);

        selectPlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectPlanComboBox.getSelectedIndex() + "" + Database.plans.size());
                if (selectPlanComboBox.getSelectedIndex() <= Database.plans.size())
                    try {
                        Plan performancePlan = new Plan();
                        performancePlan = Database.getPlanByNumber(selectPlanComboBox.getSelectedIndex() + 1);
                        dollarReturnTextField.setText(String.valueOf(calculatePerformanceMetric(5, performancePlan)));
                    } catch (Exception e1) {
                        // TODO show error to user
                        showMessageDialog(null, "Plan not found, please enter correct no.");
                    }
                else {
                    showMessageDialog(null, "Plan No" + (selectPlanComboBox.getSelectedIndex()) + " does not match");
                }

            }

        });

        closebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                performanceForm.setVisible(false);
            }

        });

    }

    /**
     * Does x
     *
     * @param roi    this is the ROI that should be passed to this function
     * @param months pass in the length of the investment in months
     */

    public double calculatePerformanceMetric(int months, Plan planNo) {
        double totalFunds = 0;
        for (int i = 0; i <= planNo.stocks.size(); i++) {
            totalFunds = totalFunds + planNo.stocks.get(i).purchasePrice;
        }
        ;
        return totalFunds;

    }

    // Skip the graph
    // Calculate ROI's on stocks using for loops

}
