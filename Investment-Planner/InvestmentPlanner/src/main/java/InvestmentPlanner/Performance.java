package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Performance {
    public void show() {

        JFrame performanceForm = new JFrame();

        JLabel performanceLabel = new JLabel("Investment Performance");
        JLabel dollarReturnLabel = new JLabel("Dollar Return");
        JLabel percentageReturnLabel = new JLabel("Percentage Return");
        JLabel monthlyGrowthLabel = new JLabel("Monthly Growth");
        JLabel performanceChartLabel = new JLabel("Performance Chart");

        JTextField dollarReturnTextField = new JTextField("Name of plan", 30);
        JTextField percentageReturnTextField = new JTextField("$", 30);
        JTextField monthlyGrowthTextField = new JTextField("$", 30);
        JTextField percentageReturnTextfield = new JTextField("...---~|```", 30);

        JButton closebutton = new JButton("Close");

        performanceLabel.setBounds(100, 20, 120, 40);

        dollarReturnLabel.setBounds(75, 80, 200, 40);
        percentageReturnLabel.setBounds(75, 140, 200, 40);
        monthlyGrowthLabel.setBounds(75, 200, 200, 40);
        performanceChartLabel.setBounds(125, 260, 200, 40);
        closebutton.setBounds(110, 520, 100, 40);

        dollarReturnTextField.setBounds(200, 80, 200, 40);
        percentageReturnTextField.setBounds(200, 140, 200, 40);
        monthlyGrowthTextField.setBounds(200, 200, 200, 40);
        percentageReturnTextfield.setBounds(100, 300, 200, 200);

        performanceForm.add(performanceLabel);
        performanceForm.add(dollarReturnLabel);
        performanceForm.add(percentageReturnLabel);
        performanceForm.add(monthlyGrowthLabel);
        performanceForm.add(performanceChartLabel);

        performanceForm.add(closebutton);

        performanceForm.add(dollarReturnTextField);
        performanceForm.add(percentageReturnTextField);
        performanceForm.add(monthlyGrowthTextField);
        performanceForm.add(percentageReturnTextfield);

        performanceForm.setSize(800, 1000);
        performanceForm.setLayout(null);
        performanceForm.setVisible(true);

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
    public void calculatePerformanceMetric(int roi, int months) {

    }

}
