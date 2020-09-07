package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pick {

    public void show(Mode mode) {

        JFrame pickForm = new JFrame();

        JButton addDeleteButton = new JButton((mode == Mode.CREATING) ? "Add" : "Delete");
        JLabel tickerLabel = new JLabel("Stock Name");
        JTextField tickerTextField = new JTextField("Stock Ticker", 30);

        addDeleteButton.setBounds(75, 150, 100, 40);
        tickerLabel.setBounds(50, 25, 100, 40);
        tickerTextField.setBounds(150, 25, 100, 40);

        pickForm.setName("Select Investment");

        pickForm.add(tickerLabel);
        pickForm.add(tickerTextField);

        pickForm.add(addDeleteButton);

        pickForm.setSize(400, 500);
        pickForm.setLayout(null);
        pickForm.setVisible(true);

        addDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                pickForm.setVisible(false);
            }

        }

        );

    }

}