package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static javax.swing.JOptionPane.showMessageDialog;

public class Menu {
    public Menu(String name) {
        setupGUI(name);
    }

    private void setupGUI(String menuName) {
        JFrame menuForm = new JFrame();

        JLabel list = new JLabel("List of Planning Options for " + menuName);

        JButton createButton = new JButton("Create Portfolio");
        JButton editButton = new JButton("Edit Portfolio");
        JButton reviewButton = new JButton("Review Performance");
        JButton closeButton = new JButton("Close");
        JTextField editPlanNoTextfield = new JTextField("Enter Plan # to Edit", 40);

        list.setBounds(80, 20, 200, 40);

        createButton.setBounds(75, 80, 200, 40);
        editButton.setBounds(75, 140, 200, 40);
        editPlanNoTextfield.setBounds(275, 140, 50, 40);
        reviewButton.setBounds(75, 200, 200, 40);
        closeButton.setBounds(110, 260, 100, 40);

        menuForm.add(list);
        menuForm.add(createButton);
        menuForm.add(editButton);
        menuForm.add(editPlanNoTextfield);
        menuForm.add(reviewButton);
        menuForm.add(closeButton);

        menuForm.setSize(800, 1000);
        menuForm.setLayout(null);
        menuForm.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateEdit c = new CreateEdit();
                try {
                    c.show(Mode.CREATING, null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (Integer.valueOf(editPlanNoTextfield.getText()) <= Database.plans.size()) {
                    CreateEdit c = new CreateEdit();
                    try {

                        c.show(Mode.EDITING, Database.getPlanByNumber(editPlanNoTextfield.getText()));
                    } catch (Exception e1) {
                        // TODO show error to user
                        showMessageDialog(null, "Plan not found, please enter correct no.");
                    }
                } else {
                    showMessageDialog(null, "Plan No does not match");
                }

            }

        });

        reviewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Performance performance = new Performance();

                performance.show();
            }

        }

        );

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuForm.setVisible(false);
            }

        });
    }

}