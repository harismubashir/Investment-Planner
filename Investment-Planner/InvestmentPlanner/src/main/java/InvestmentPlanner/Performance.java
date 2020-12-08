package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class Performance {

    public Plan performancePlan = new Plan();
    public String selectedPlanNo;
    JTextField selectedPlanTextField = new JTextField("Plan No", 30);
    JTextField dollarReturnTextField = new JTextField("$$$", 30);
    JTextField percentageReturnTextField = new JTextField("$", 30);
    JTextField monthlyGrowthTextField = new JTextField("$", 30);

    public void show(Plan plan) {

        JFrame performanceForm = new JFrame();

        JLabel performanceLabel = new JLabel("Investment Performance");
        JLabel selectPlanLabel = new JLabel("Select Plan");
        JLabel dollarReturnLabel = new JLabel("Dollar Return");
        JLabel percentageReturnLabel = new JLabel("Percentage Return");
        JLabel monthlyGrowthLabel = new JLabel("Monthly Growth");

        XYDataset ds = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart("Return on Investment", "Date", "Dollars", ds,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel performanceChartPanel = new ChartPanel(chart);

        JComboBox<String> selectPlanComboBox = new JComboBox<String>();

        JButton selectPlanButton = new JButton("Select Plan");
        JButton closebutton = new JButton("Close");

        performanceLabel.setBounds(100, 20, 120, 40);

        selectPlanLabel.setBounds(75, 60, 200, 40);
        dollarReturnLabel.setBounds(75, 110, 200, 40);

        percentageReturnLabel.setBounds(75, 150, 200, 40);
        monthlyGrowthLabel.setBounds(75, 200, 200, 40);
        selectPlanButton.setBounds(450, 80, 100, 40);
        closebutton.setBounds(110, 520, 100, 40);

        selectPlanComboBox.setBounds(200, 60, 200, 40);
        selectedPlanTextField.setBounds(200, 60, 200, 40);
        dollarReturnTextField.setBounds(200, 110, 200, 40);
        percentageReturnTextField.setBounds(200, 150, 200, 40);
        monthlyGrowthTextField.setBounds(200, 200, 200, 40);
        performanceChartPanel.setBounds(100, 300, 400, 200);

        performanceForm.add(performanceLabel);
        performanceForm.add(selectPlanLabel);
        performanceForm.add(percentageReturnLabel);
        performanceForm.add(monthlyGrowthLabel);
        performanceForm.add(dollarReturnLabel);

        performanceForm.add(closebutton);
        performanceForm.add(selectPlanButton);
        performanceForm.add(performanceChartPanel);

        for (int i = 0; i < Database.plans.size(); i++) {
            try {
                selectPlanComboBox.addItem(String.valueOf(i + 1) + ") " + Database.plans.get(i).planNo);
            } catch (Exception e1) {
                showMessageDialog(null, "No saved plans exist.");
            }

        }
        ;

        performanceForm.add(selectPlanComboBox);
        performanceForm.add(dollarReturnTextField);
        performanceForm.add(percentageReturnTextField);
        performanceForm.add(monthlyGrowthTextField);

        performanceForm.setSize(800, 1000);
        performanceForm.setLayout(null);
        performanceForm.setVisible(true);

        selectPlanComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedPlanTextField.setText(String.valueOf(selectPlanComboBox.getSelectedIndex()));
                selectedPlanNo = selectedPlanTextField.getText();
            }
        });

        selectPlanButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (Integer.valueOf(selectedPlanNo) <= Database.plans.size())
                    try {
                        performancePlan = Database.getPlanByNumber(Integer.valueOf(selectedPlanNo) + 1);
                        dollarReturnTextField.setText("You have a LOTT of money");
                        percentageReturnTextField.setText(performancePlan.planNo);
                        calculatePerformanceMetric(performancePlan);

                    } catch (Exception e1) {
                        // TODO show error to user
                        showMessageDialog(null, "Plan not found, please enter correct no.");
                    }
                else {
                    showMessageDialog(null, "Plan No" + selectedPlanNo + " does not match");
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
     * Takes the Plan and returns the return on investment in dollar value
     *
     * @param roi    this is the ROI that should be passed to this function
     * @param months pass in the length of the investment in months
     */

    public void calculatePerformanceMetric(Plan planNo) {
        double totalFunds = 0;
        for (int i = 0; i < planNo.stocks.size(); i++) {
            totalFunds = totalFunds + planNo.stocks.get(i).purchasePrice;
        }
        ;

        dollarReturnTextField.setText(String.valueOf(totalFunds));
    }

    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { { 1, 2, 3 }, { 1, 2, 3 } };

        ds.addSeries("series1", data);

        return ds;
    }

}

// Skip the graph
// Calculate ROI's on stocks using for loops
