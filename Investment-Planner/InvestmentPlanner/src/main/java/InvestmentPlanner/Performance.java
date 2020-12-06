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

    public void show(Plan plan) {

        JFrame performanceForm = new JFrame();

        JLabel performanceLabel = new JLabel("Investment Performance");
        JLabel selectPlanLabel = new JLabel("Dollar Return");
        JLabel percentageReturnLabel = new JLabel("Percentage Return");
        JLabel monthlyGrowthLabel = new JLabel("Monthly Growth");

        XYDataset ds = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart("Return on Investment", "Date", "Dollars", ds,
                PlotOrientation.VERTICAL, true, true, false);

        ChartPanel performanceChartPanel = new ChartPanel(chart);

        JTextField dollarReturnTextField = new JTextField("Name of plan", 30);
        JTextField percentageReturnTextField = new JTextField("$", 30);
        JTextField monthlyGrowthTextField = new JTextField("$", 30);

        JComboBox<String> selectPlanComboBox = new JComboBox<String>();

        JButton selectPlanButton = new JButton("Select Plan");
        JButton closebutton = new JButton("Close");

        performanceLabel.setBounds(100, 20, 120, 40);

        selectPlanLabel.setBounds(75, 60, 200, 40);
        percentageReturnLabel.setBounds(75, 140, 200, 40);
        monthlyGrowthLabel.setBounds(75, 200, 200, 40);
        selectPlanButton.setBounds(450, 80, 100, 40);
        closebutton.setBounds(110, 520, 100, 40);

        selectPlanComboBox.setBounds(200, 60, 200, 40);
        percentageReturnTextField.setBounds(200, 140, 200, 40);
        monthlyGrowthTextField.setBounds(200, 200, 200, 40);
        performanceChartPanel.setBounds(100, 300, 400, 200);

        performanceForm.add(performanceLabel);
        performanceForm.add(selectPlanLabel);
        performanceForm.add(percentageReturnLabel);
        performanceForm.add(monthlyGrowthLabel);

        performanceForm.add(closebutton);
        performanceForm.add(selectPlanButton);
        performanceForm.add(performanceChartPanel);

        for (int i = 0; i <= Database.plans.size(); i++) {
            try {
                selectPlanComboBox.addItem(Database.plans.get(i).planNo);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                showMessageDialog(null, "No saved plans exist.");
                ;
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

        selectPlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectPlanComboBox.getSelectedIndex() + "" + Database.plans.size());
                if (selectPlanComboBox.getSelectedIndex() <= Database.plans.size())
                    try {
                        performancePlan = Database.getPlanByNumber(Integer.valueOf(selectPlanComboBox.getselectedItem()) + 1);
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

    private XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { { 0.1, 0.2, 0.3 }, { 1, 2, 3 } };

        ds.addSeries("series1", data);

        return ds;
    }

    // Skip the graph
    // Calculate ROI's on stocks using for loops

}
