package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        list.setBounds(80, 20, 200, 40);

        createButton.setBounds(75, 80, 200, 40);
        editButton.setBounds(75, 140, 200, 40);
        reviewButton.setBounds(75, 200, 200, 40);
        closeButton.setBounds(110, 260, 100, 40);

        menuForm.add(list);
        menuForm.add(createButton);
        menuForm.add(editButton);
        menuForm.add(reviewButton);
        menuForm.add(closeButton);

        menuForm.setSize(800, 1000);
        menuForm.setLayout(null);
        menuForm.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateEdit c = new CreateEdit();
                c.show(Mode.CREATING, menuName);
            }

        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateEdit c = new CreateEdit();
                c.show(Mode.EDITING, menuName);
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